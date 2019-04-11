package pl.decerto.hyperon.telco.demo.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.OfferPackageDictionaryDto;
import pl.decerto.hyperon.telco.demo.api.dto.dictionary.PromotionDictionaryDto;
import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.DurationUnit;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainAttribute;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */
@Component
public class OfferPackageDictionaryConverter implements Converter<HyperonDomainObject, OfferPackageDictionaryDto> {
	@Override public OfferPackageDictionaryDto convert(HyperonDomainObject packageObject) {
		var dto = new OfferPackageDictionaryDto();

		dto.setPublicName(packageObject.getAttrString("PublicName", null));
		dto.setCode(packageObject.getCode());
		dto.setChannelsSum(getChannelsCount(packageObject));
		dto.setDetails(getPackageDetails(packageObject));
		dto.setMonthlyPrice(packageObject.getAttrDecimal("MonthlyPrice", null));
		dto.setPromos(getPackagePromos(packageObject));

		return dto;
	}

	private List<PromotionDictionaryDto> getPackagePromos(HyperonDomainObject packageObject) {
		HyperonDomainAttribute startingPricePromos = packageObject.getAttr("StartingPricePromos");
		List<PromotionDictionaryDto> promos = new ArrayList<>();

		for (HyperonDomainObject interval : packageObject.getChildren("INTERVALS")) {
			Integer duration = interval.getAttrInteger("Value", null);
			var ctx = new TelcoContext(new OfferPackage(packageObject.getCode(), duration));
			BigDecimal promoPrice = startingPricePromos.getValue(ctx).getBigDecimal();

			if (Objects.nonNull(promoPrice)) {
				promos.add(createPromo(duration, promoPrice,
					DurationUnit.valueOf(interval.getAttrString("Unit", null).toUpperCase())));
			}
		}

		return promos;
	}

	private PromotionDictionaryDto createPromo(int duration, BigDecimal promoPrice, DurationUnit unit) {
		var promo = new PromotionDictionaryDto();

		promo.setDuration(duration);
		promo.setPrice(promoPrice);
		promo.setUnit(unit);

		return promo;
	}

	private List<String> getPackageDetails(HyperonDomainObject packageObject) {
		var ctx = new TelcoContext(new OfferPackage(packageObject.getCode()));
		return packageObject.getAttr("Details").getValue(ctx)
			.rows()
			.stream()
			.map(mv -> mv.getString(0))
			.collect(Collectors.toList());
	}

	private Integer getChannelsCount(HyperonDomainObject packageObject) {
		var ctx = new TelcoContext(new OfferPackage(packageObject.getCode()));
		return packageObject.getAttrInteger("ChannelsCount", ctx);
	}
}
