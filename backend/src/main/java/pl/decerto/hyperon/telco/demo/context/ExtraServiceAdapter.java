package pl.decerto.hyperon.telco.demo.context;

import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

/**
 * @author Maciej Główka on 26.03.2019
 */
public class ExtraServiceAdapter extends Adapter {
	private final ExtraService service;

	public ExtraServiceAdapter(ExtraService service) {
		this.service = service;
	}

	@Override protected Mapping getMapping() {
		return super.getMapping()
			.add("selected", service.isSelected())
			.add("code", service.getCode());
	}
}
