package pl.decerto.hyperon.telco.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraChannelDictionaryDto;
import pl.decerto.hyperon.telco.demo.context.TelcoContext;
import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 18.03.2019
 */

@Component
public class ExtraChannelDictionaryConverter implements Converter<HyperonDomainObject, ExtraChannelDictionaryDto> {
	@Override public ExtraChannelDictionaryDto convert(HyperonDomainObject extraChannel) {
		var dto = new ExtraChannelDictionaryDto();

		dto.setCode(extraChannel.getCode());
		dto.setName(extraChannel.getAttrString("Name", null));
		if (extraChannel.isAttrSet("Description")) {
			dto.setDescription(extraChannel.getAttrString("Description", null));
		}
		dto.setDetails(getChannelDetails(extraChannel));

		return dto;
	}

	private List<String> getChannelDetails(HyperonDomainObject extraChannel) {
		var ctx = new TelcoContext(new ExtraChannel(extraChannel.getCode()));
		return extraChannel.getAttr("Details").getValue(ctx)
			.rows()
			.stream()
			.map(mv -> mv.getString(0))
			.collect(Collectors.toList());
	}
}
