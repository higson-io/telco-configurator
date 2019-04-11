package pl.decerto.hyperon.telco.demo.converter;

import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */
@Component
public class ExtraChannelConverter {
	public ExtraChannel convert(HyperonDomainObject extraChannel, String packageCode, int duration) {
		var dto = new ExtraChannel();

		dto.setCode(extraChannel.getCode());
		dto.setPrice(extraChannel.getAttrDecimal("Price", new TelcoContext(new ExtraChannel(extraChannel.getCode(), new OfferPackage(packageCode, duration)))));

		return dto;
	}
}
