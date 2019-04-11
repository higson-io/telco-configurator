package pl.decerto.hyperon.telco.demo.context;

import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.CollectionAdapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

/**
 * @author Maciej Główka on 14.03.2019
 */
public class OfferPackageAdapter extends Adapter {
	private final OfferPackage offerPackage;

	public OfferPackageAdapter(OfferPackage offerPackage) {
		this.offerPackage = offerPackage;
	}

	@Override protected Mapping getMapping() {
		return super.getMapping()
			.add("code", offerPackage.getPackageCode().toUpperCase())
			.add("duration", offerPackage.getDuration())
			.add("extraChannels", new CollectionAdapter<>(offerPackage.getExtraChannels(), ExtraChannelAdapter::new))
			.add("services", new CollectionAdapter<>(offerPackage.getExtraServices(), ExtraServiceAdapter::new))
			.add("hardware", new CollectionAdapter<>(offerPackage.getHardware(), HardwareAdapter::new));
	}
}
