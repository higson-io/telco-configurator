package pl.decerto.hyperon.telco.demo.context;

import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

/**
 * @author Maciej Główka on 14.03.2019
 */
public class HardwareAdapter extends Adapter {
	private final Hardware hardware;

	public HardwareAdapter(Hardware hardware) {
		this.hardware = hardware;
	}

	@Override protected Mapping getMapping() {
		return super.getMapping()
			.add("code", hardware.getCode())
			.add("selected", hardware.isSelected())
			.add("package", hardware.getOfferPackage());
	}
}
