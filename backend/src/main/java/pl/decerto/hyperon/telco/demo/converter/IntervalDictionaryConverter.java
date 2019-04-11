package pl.decerto.hyperon.telco.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.IntervalDictionaryDto;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */
@Component
public class IntervalDictionaryConverter implements Converter<HyperonDomainObject, IntervalDictionaryDto> {
	@Override public IntervalDictionaryDto convert(HyperonDomainObject interval) {
		var dto = new IntervalDictionaryDto();

		dto.setUnit(interval.getAttrString("Unit", null));
		dto.setDisplayUnitValue(interval.getAttrString("DisplayValue", null));
		dto.setValue(interval.getAttrInteger("Value", null));

		return dto;
	}
}
