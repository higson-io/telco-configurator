package pl.decerto.hyperon.telco.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.HardwareDictionaryDto;
import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.telco.demo.domain.HardwareCategory;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */
@Component
public class HardwareDictionaryConverter implements Converter<HyperonDomainObject, HardwareDictionaryDto> {
	@Override public HardwareDictionaryDto convert(HyperonDomainObject hardware) {
		var dto = new HardwareDictionaryDto();

		dto.setCategory(HardwareCategory.valueOf(hardware.getAttrString("Category", null).toUpperCase()));
		dto.setCode(hardware.getCode());
		dto.setName(hardware.getAttrString("Name", null));
		if (hardware.isAttrSet("Description")) {
			dto.setDescription(hardware.getAttrString("Description", null));
		}
		dto.setMultiRoom(hardware.getAttrBoolean("MultiRoom", null));
		dto.setDetails(getHardwareDetails(hardware));

		return dto;
	}

	private List<String> getHardwareDetails(HyperonDomainObject hardware) {
		return hardware.getAttr("Details").getValue(new TelcoContext(new Hardware(hardware.getCode())))
			.rows()
			.stream()
			.map(mv -> mv.getString(0))
			.collect(Collectors.toList());
	}
}
