package pl.decerto.hyperon.telco.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.DictionaryDto;
import pl.decerto.hyperon.telco.demo.domain.SelectedDateHolder;
import pl.decerto.hyperon.runtime.core.HyperonEngine;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

@Service
public class DictionaryService {
	private final HyperonEngine engine;
	private final ExtraChannelService extraChannelService;
	private final HardwareService hardwareService;
	private final OfferPackageService offerPackageService;
	private final IntervalService intervalService;
	private final ExtraServiceService extraServiceService;
	private final String hyperonProfile;
	private SelectedDateHolder selectedDateHolder;

	@Autowired
	public DictionaryService(HyperonEngine engine, ExtraChannelService extraChannelService, HardwareService hardwareService,
		OfferPackageService offerPackageService, IntervalService intervalService, ExtraServiceService extraServiceService,
		SelectedDateHolder selectedDateHolder, @Value("${hyperon.profile}") String profile) {
		this.engine = engine;
		this.extraChannelService = extraChannelService;
		this.hardwareService = hardwareService;
		this.offerPackageService = offerPackageService;
		this.intervalService = intervalService;
		this.extraServiceService = extraServiceService;
		this.hyperonProfile = profile;
		this.selectedDateHolder = selectedDateHolder;
	}

	public DictionaryDto getAll() {
		if (Objects.nonNull(selectedDateHolder.getDate())) {
			engine.setEffectiveDate(selectedDateHolder.getDate());
		}

		HyperonDomainObject root = engine.getDomain(hyperonProfile, "/");
		var dict = new DictionaryDto();

		dict.setPackages(offerPackageService.getAllPackages(root));
		dict.setExtraChannels(extraChannelService.getAllExtraChannels(root));
		dict.setHardware(hardwareService.getAllHardware(root));
		dict.setIntervals(intervalService.getALlIntervals(root));
		dict.setServices(extraServiceService.getAllServices(root));

		return dict;
	}

}
