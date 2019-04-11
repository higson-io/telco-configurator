package pl.decerto.hyperon.telco.demo.context;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import pl.decerto.hyperon.telco.demo.domain.ExtraChannel;
import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.runtime.core.HyperonContext;

/**
 * @author Maciej Główka on 14.03.2019
 */
public class TelcoContext extends HyperonContext {
	private OfferPackage offerPackage;
	private ExtraChannel extraChannel;
	private Hardware hardware;
	private ExtraService extraService;

	public TelcoContext(Object... args) {
		super(args);
	}

	public TelcoContext(OfferPackage offerPackage) {
		this.offerPackage = offerPackage;
	}

	public TelcoContext(ExtraChannel extraChannel) {
		this.extraChannel = extraChannel;
	}

	public TelcoContext(ExtraService extraService) {
		this.extraService = extraService;
	}

	public TelcoContext(Hardware hardware) {
		this.hardware = hardware;
	}

	public OfferPackage getOfferPackage() {
		if (Objects.isNull(offerPackage) && Objects.nonNull(hardware)) {
			offerPackage = hardware.getOfferPackage();
		}

		if (Objects.isNull(offerPackage) && Objects.nonNull(extraChannel)) {
			offerPackage = extraChannel.getOfferPackage();
		}

		if (Objects.isNull(offerPackage) && Objects.nonNull(extraService)) {
			offerPackage = extraService.getOfferPackage();
		}

		return offerPackage;
	}

	@Override public Object get(String path) {
		String name = getFirstPathToken(path);
		String subpath = skipFirstPathToken(path);

		Adapter adapter = null;
		if (name.equals("package")) {
			adapter = new OfferPackageAdapter(getOfferPackage());
		}

		if (name.equals("extraChannel")) {
			adapter = new ExtraChannelAdapter(extraChannel);
		}

		if (name.equals("hardware")) {
			adapter = new HardwareAdapter(hardware);
		}

		if (name.equals("service")) {
			adapter = new ExtraServiceAdapter(extraService);
		}

		if (adapter != null) {
			return adapter.get(subpath);
		}

		return null;
	}

	private String getFirstPathToken(String path) {
		return StringUtils.substringBefore(path, ".");
	}

	private String skipFirstPathToken(String path) {
		return StringUtils.substringAfter(path, ".");
	}
}
