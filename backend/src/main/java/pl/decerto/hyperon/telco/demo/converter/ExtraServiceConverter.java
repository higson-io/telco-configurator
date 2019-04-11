package pl.decerto.hyperon.telco.demo.converter;

import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 27.03.2019
 */
@Component
public class ExtraServiceConverter {

	public ExtraService convert(HyperonDomainObject serviceObject, OfferPackage offerPackage) {
		var ctx = new TelcoContext(new ExtraService(serviceObject.getCode(), offerPackage));
		var service = new ExtraService();

		service.setCode(serviceObject.getCode());
		service.setMonthlyPrice(serviceObject.getAttrDecimal("MonthlyPrice", ctx));
		service.setMonthlyPriceAfterDiscounts(serviceObject.getAttrDecimal("MonthlyPriceAfterDiscounts", ctx));
		service.setActivationPrice(serviceObject.getAttrDecimal("ActivationPrice", ctx));

		return service;
	}
}
