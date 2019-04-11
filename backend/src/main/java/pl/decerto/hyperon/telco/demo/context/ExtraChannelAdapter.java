package pl.decerto.hyperon.telco.demo.context;

import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

/**
 * @author Maciej Główka on 14.03.2019
 */
public class ExtraChannelAdapter extends Adapter {
	private final ExtraChannel extraChannel;

	public ExtraChannelAdapter(ExtraChannel extraChannel) {
		this.extraChannel = extraChannel;
	}

	@Override protected Mapping getMapping() {
		return super.getMapping()
			.add("code", extraChannel.getCode())
			.add("selected", extraChannel.isSelected());
	}
}
