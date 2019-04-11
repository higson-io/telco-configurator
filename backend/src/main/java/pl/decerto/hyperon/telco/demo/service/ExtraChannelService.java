package pl.decerto.hyperon.telco.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraChannelDictionaryDto;
import pl.decerto.hyperon.telco.demo.converter.ExtraChannelConverter;
import pl.decerto.hyperon.telco.demo.converter.ExtraChannelDictionaryConverter;
import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Service
public class ExtraChannelService {
	private final ExtraChannelDictionaryConverter dictionaryConverter;
	private final ExtraChannelConverter channelConverter;

	public ExtraChannelService(ExtraChannelDictionaryConverter dictionaryConverter, ExtraChannelConverter channelConverter) {
		this.dictionaryConverter = dictionaryConverter;
		this.channelConverter = channelConverter;
	}

	public OfferPackage changeExtraChannelState(OfferPackage offerPackage, String extraChannelCode, boolean select) {
		offerPackage.getExtraChannels().forEach(extraChannel -> {
			if (StringUtils.equals(extraChannel.getCode(), extraChannelCode)) {
				extraChannel.setSelected(select);
			}
		});

		return offerPackage;
	}

	public List<ExtraChannelDictionaryDto> getAllExtraChannels(HyperonDomainObject root) {
		return root.getChildren("EXTRA_CHANNELS").stream()
			.map(dictionaryConverter::convert)
			.collect(Collectors.toList());
	}

	public List<ExtraChannel> getExtraChannels(HyperonDomainObject packageObject, int duration) {
		return packageObject.getChildren("EXTRA_CHANNELS").stream()
			.map(extraChannel -> channelConverter.convert(extraChannel, packageObject.getCode(), duration))
			.collect(Collectors.toList());
	}
}
