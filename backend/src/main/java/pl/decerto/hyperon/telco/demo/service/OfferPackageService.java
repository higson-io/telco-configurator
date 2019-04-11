package pl.decerto.hyperon.telco.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.OfferPackageDictionaryDto;
import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.converter.OfferPackageDictionaryConverter;
import pl.decerto.hyperon.telco.demo.domain.Invoice;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.telco.demo.domain.PaymentEntry;
import pl.decerto.hyperon.telco.demo.domain.SelectedDateHolder;
import pl.decerto.hyperon.telco.demo.exceptions.UnknownOfferException;
import pl.decerto.hyperon.runtime.core.HyperonEngine;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

@Service
public class OfferPackageService {
	private static Logger log = LoggerFactory.getLogger(OfferPackageService.class);
	private static final String UNKNOWN_OFFER_ID_MESSAGE = "unknown offer with id:%s";

	private final HyperonEngine hyperonEngine;
	private final HardwareService hardwareService;
	private final ExtraChannelService extraChannelService;
	private final ExtraServiceService extraServiceService;
	private final OfferPackageDictionaryConverter dictionaryConverter;
	private final String hyperonProfile;
	private SelectedDateHolder selectedDateHolder;

	private Map<String, OfferPackage> idToOfferMapping = new HashMap<>();

	@Autowired
	public OfferPackageService(HyperonEngine hyperonEngine, HardwareService hardwareService, ExtraChannelService extraChannelService,
		ExtraServiceService extraServiceService, OfferPackageDictionaryConverter dictionaryConverter,
		@Value("${hyperon.profile}") String profile, SelectedDateHolder selectedDateHolder) {
		this.hyperonEngine = hyperonEngine;
		this.hardwareService = hardwareService;
		this.extraChannelService = extraChannelService;
		this.extraServiceService = extraServiceService;
		this.dictionaryConverter = dictionaryConverter;
		this.hyperonProfile = profile;
		this.selectedDateHolder = selectedDateHolder;
	}

	public OfferPackage getExistingOffer(String offerId) {
		return calculate(getOffer(offerId));
	}

	public OfferPackage createOffer(String packageCode, int duration) {
		String id = RandomStringUtils.random(8, "0123456789abcdef");
		log.info("creating offer with id:{}, package:{} and duration:{}", id, packageCode, duration);
		OfferPackage offerPackage = new OfferPackage(id, packageCode, duration);

		idToOfferMapping.put(id, offerPackage);

		if (Objects.nonNull(selectedDateHolder.getDate())) {
			hyperonEngine.setEffectiveDate(selectedDateHolder.getDate());
		}
		HyperonDomainObject packageObject = hyperonEngine.getDomain(hyperonProfile, "/").getChild("Packages", packageCode.toUpperCase());
		offerPackage.setHardware(hardwareService.getHardware(packageObject));
		offerPackage.setExtraChannels(extraChannelService.getExtraChannels(packageObject, duration));
		offerPackage.setExtraServices(extraServiceService.getExtraServices(packageObject, offerPackage));
		offerPackage.setMonthlyPrice(packageObject.getAttrDecimal("MonthlyPrice", null));

		return calculate(offerPackage);
	}

	public OfferPackage changeDuration(String offerId, int duration) {
		OfferPackage offerPackage = getOffer(offerId);
		offerPackage.setDuration(duration);

		return calculate(offerPackage);
	}

	public OfferPackage selectHardware(String offerId, String hardwareCode) {
		log.info("selecting hardware code:{} in offer:{}", hardwareCode, offerId);

		return calculate(changeHardwareState(offerId, hardwareCode, true));
	}

	public OfferPackage deselectHardware(String offerId, String hardwareCode) {
		log.info("deselecting hardware code:{} in offer:{}", hardwareCode, offerId);

		return calculate(changeHardwareState(offerId, hardwareCode, false));
	}

	private OfferPackage changeHardwareState(String offerId, String hardwareCode, boolean select) {
		return hardwareService.changeHardwareState(getOffer(offerId), hardwareCode, select);
	}

	public OfferPackage selectExtraChannel(String offerId, String extraChannelCode) {
		log.info("selecting extra channel:{} in offer:{}", extraChannelCode, offerId);

		return calculate(changeExtraChannelState(offerId, extraChannelCode, true));
	}

	public OfferPackage deselectExtraChannel(String offerId, String extraChannelCode) {
		log.info("deselecting extra channel:{} in offer:{}", extraChannelCode, offerId);

		return calculate(changeExtraChannelState(offerId, extraChannelCode, false));
	}

	private OfferPackage changeExtraChannelState(String offerId, String extraChannelCode, boolean select) {
		return extraChannelService.changeExtraChannelState(getOffer(offerId), extraChannelCode, select);
	}

	public OfferPackage getOffer(String offerId) {
		return Optional.ofNullable(idToOfferMapping.get(offerId))
			.orElseThrow(() -> createUnknownOfferException(offerId));
	}

	public OfferPackage calculate(OfferPackage offerPackage) {
		if (Objects.nonNull(selectedDateHolder.getDate())) {
			hyperonEngine.setEffectiveDate(selectedDateHolder.getDate());
		}

		HyperonDomainObject packageObject = hyperonEngine.getDomain(hyperonProfile, "/").getChild("Packages", offerPackage.getPackageCode().toUpperCase());

		var ctx = new TelcoContext(offerPackage);
		offerPackage.getExtraChannels().forEach(extraChannel -> {
			HyperonDomainObject channel = packageObject.getChild("EXTRA_CHANNELS", extraChannel.getCode());
			extraChannel.setPrice(channel.getAttrDecimal("Price", new TelcoContext(extraChannel)));
		});

		offerPackage.getExtraServices().forEach(service -> {
			HyperonDomainObject serviceElement = packageObject.getChild("SERVICES", service.getCode());
			service.setMonthlyPriceAfterDiscounts(serviceElement.getAttrDecimal("MonthlyPriceAfterDiscounts", new TelcoContext(service)));
		});

		offerPackage.setActivationPrice(packageObject.getAttrDecimal("ActivationPrice", ctx));
		offerPackage.setActivationPriceAfterDiscounts(packageObject.getAttrDecimal("ActivationPriceAfterDiscounts", ctx));
		offerPackage.setOverallPrice(packageObject.getAttrDecimal("OverallPrice", ctx));
		offerPackage.setOverallPriceAfterDiscounts(packageObject.getAttrDecimal("OverallPriceAfterDiscounts", ctx));
		offerPackage.setInvoice(getInvoice(packageObject, ctx));

		offerPackage.print();

		return offerPackage;
	}

	private Invoice getInvoice(HyperonDomainObject packageObject, TelcoContext ctx) {
		Invoice invoice = new Invoice();
		List<PaymentEntry> entries = packageObject.getAttr("Invoice").getValue(ctx)
			.rows()
			.stream()
			.map(mv -> new PaymentEntry(mv.getBigDecimal("OverallPrice"),
				mv.getBigDecimal("OverallPriceAfterDiscounts"),
				convertToLocalDate(mv.getDate("PaymentDate"))))
			.collect(Collectors.toList());

		invoice.setPaymentEntries(entries);

		return invoice;
	}

	private LocalDate convertToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private UnknownOfferException createUnknownOfferException(String offerId) {
		return new UnknownOfferException(String.format(UNKNOWN_OFFER_ID_MESSAGE, offerId));
	}

	public List<OfferPackageDictionaryDto> getAllPackages(HyperonDomainObject root) {
		return root.getChildren("Packages").stream()
			.map(dictionaryConverter::convert)
			.collect(Collectors.toList());
	}

	public OfferPackage selectExtraService(String offerId, String serviceCode) {
		log.info("selecting service code:{} in offer:{}", serviceCode, offerId);

		return calculate(changeServiceState(offerId, serviceCode, true));
	}

	public OfferPackage deselectExtraService(String offerId, String serviceCode) {
		log.info("deselecting service code:{} in offer:{}", serviceCode, offerId);

		return calculate(changeServiceState(offerId, serviceCode, false));
	}

	private OfferPackage changeServiceState(String offerId, String hardwareCode, boolean select) {
		return extraServiceService.changeServiceState(getOffer(offerId), hardwareCode, select);
	}
}
