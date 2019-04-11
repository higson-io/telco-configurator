package pl.decerto.hyperon.telco.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraServiceDictionaryDto;
import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 26.03.2019
 */
@Component
public class ExtraServiceDictionaryConverter implements Converter<HyperonDomainObject, ExtraServiceDictionaryDto> {
	@Override public ExtraServiceDictionaryDto convert(HyperonDomainObject extraService) {
		var dto = new ExtraServiceDictionaryDto();

		dto.setCode(extraService.getCode());
		dto.setName(extraService.getAttrString("Name", null));
		if (extraService.isAttrSet("Description")) {
			dto.setDescription(extraService.getAttrString("Description", null));
		}
		dto.setDetails(getServiceDetails(extraService));

		return dto;
	}

	private List<String> getServiceDetails(HyperonDomainObject extraService) {
		var ctx = new TelcoContext(new ExtraService(extraService.getCode()));
		return extraService.getAttr("Details").getValue(ctx)
			.rows()
			.stream()
			.map(mv -> mv.getString(0))
			.collect(Collectors.toList());
	}
}
