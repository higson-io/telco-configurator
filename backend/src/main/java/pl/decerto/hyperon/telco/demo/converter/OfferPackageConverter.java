package pl.decerto.hyperon.telco.demo.converter;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.ExtraChannelDto;
import pl.decerto.hyperon.telco.demo.api.dto.ExtraServiceDto;
import pl.decerto.hyperon.telco.demo.api.dto.HardwareDto;
import pl.decerto.hyperon.telco.demo.api.dto.InvoiceDto;
import pl.decerto.hyperon.telco.demo.api.dto.OfferPackageDto;
import pl.decerto.hyperon.telco.demo.api.dto.PaymentEntryDto;
import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.telco.demo.domain.Invoice;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.telco.demo.domain.PaymentEntry;

@Component
public class OfferPackageConverter implements Converter<OfferPackage, OfferPackageDto> {

	@Override
	public OfferPackageDto convert(OfferPackage offerPackage) {
		Objects.requireNonNull(offerPackage, "Offer can not be null");
		var dto = new OfferPackageDto();

		dto.setId(offerPackage.getId());
		dto.setDuration(offerPackage.getDuration());
		dto.setPackageCode(offerPackage.getPackageCode());
		dto.setExtraChannels(offerPackage.getExtraChannels()
			.stream()
			.map(this::convertToExtraChannelsDto)
			.collect(Collectors.toList()));
		dto.setHardware(offerPackage.getHardware()
			.stream()
			.map(this::convertToHardwareDto)
			.collect(Collectors.toList()));
		dto.setExtraServices(offerPackage.getExtraServices()
			.stream()
			.map(this::convertToExtraServiceDto)
			.collect(Collectors.toList()));
		dto.setActivationPrice(offerPackage.getActivationPrice());
		dto.setActivationPriceAfterDiscounts(offerPackage.getActivationPriceAfterDiscounts());
		dto.setPrice(offerPackage.getOverallPrice());
		dto.setPriceAfterDiscounts(offerPackage.getOverallPriceAfterDiscounts());
		dto.setInvoice(convertToInvoiceDto(offerPackage.getInvoice()));

		return dto;
	}

	private InvoiceDto convertToInvoiceDto(Invoice invoice) {
		var dto = new InvoiceDto();

		dto.setValues(invoice.getPaymentEntries().stream()
			.map(this::convertPaymentEntry)
			.collect(Collectors.toList()));

		return dto;
	}

	private PaymentEntryDto convertPaymentEntry(PaymentEntry entry) {
		var dto = new PaymentEntryDto();

		dto.setPaymentDate(entry.getPaymentDate());
		dto.setValue(entry.getValue());
		dto.setValueAfterDiscounts(entry.getValueAfterDiscounts());

		return dto;
	}

	private ExtraChannelDto convertToExtraChannelsDto(ExtraChannel extraChannel) {
		var dto = new ExtraChannelDto();
		dto.setCode(extraChannel.getCode());
		dto.setPrice(extraChannel.getPrice());
		dto.setSelected(extraChannel.isSelected());

		return dto;
	}

	private HardwareDto convertToHardwareDto(Hardware hardware) {
		var dto = new HardwareDto();
		dto.setCode(hardware.getCode());
		dto.setMonthlyPayment(hardware.getMonthlyPayment());
		dto.setActivationPrice(hardware.getActivationPrice());
		dto.setSelected(hardware.isSelected());
		dto.setMultiRoom(hardware.isMultiRoom());

		return dto;
	}

	private ExtraServiceDto convertToExtraServiceDto(ExtraService extraService) {
		var dto = new ExtraServiceDto();

		dto.setCode(extraService.getCode());
		dto.setSelected(extraService.isSelected());
		dto.setActivationPrice(extraService.getActivationPrice());
		dto.setMonthlyPriceAfterDiscounts(extraService.getMonthlyPriceAfterDiscounts());
		dto.setMonthlyPrice(extraService.getMonthlyPrice());

		return dto;
	}
}
