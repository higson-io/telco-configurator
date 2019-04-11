package pl.decerto.hyperon.telco.demo.converter;

import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */
@Component
public class HardwareConverter {
	public Hardware convert(HyperonDomainObject hardwareObject, String packageCode) {
		var ctx = new TelcoContext(new Hardware(hardwareObject.getCode(), new OfferPackage(packageCode)));
		Hardware hardware = new Hardware();

		hardware.setCode(hardwareObject.getCode());
		hardware.setMonthlyPayment(hardwareObject.getAttrDecimal("MonthlyPrice", ctx));
		hardware.setActivationPrice(hardwareObject.getAttrDecimal("ActivationPrice", ctx));
		hardware.setMultiRoom(hardwareObject.getAttrBoolean("MultiRoom", null));

		return hardware;
	}
}
