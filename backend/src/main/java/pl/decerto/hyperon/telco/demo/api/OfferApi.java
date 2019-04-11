package pl.decerto.hyperon.telco.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.decerto.hyperon.telco.demo.api.dto.ChangeDurationDto;
import pl.decerto.hyperon.telco.demo.api.dto.CreateOfferDto;
import pl.decerto.hyperon.telco.demo.api.dto.OfferPackageDto;
import pl.decerto.hyperon.telco.demo.api.dto.SelectExtraChannelDto;
import pl.decerto.hyperon.telco.demo.api.dto.SelectExtraServiceDto;
import pl.decerto.hyperon.telco.demo.api.dto.SelectHardwareDto;
import pl.decerto.hyperon.telco.demo.converter.OfferPackageConverter;
import pl.decerto.hyperon.telco.demo.service.OfferPackageService;

@RestController
@RequestMapping("/offers")
public class OfferApi {

	private final OfferPackageService offerPackageService;

	private final OfferPackageConverter offerPackageConverter;

	@Autowired
	public OfferApi(OfferPackageService offerPackageService, OfferPackageConverter offerPackageConverter) {
		this.offerPackageService = offerPackageService;
		this.offerPackageConverter = offerPackageConverter;
	}

	@GetMapping("/{offerId}")
	public OfferPackageDto getOffer(@PathVariable String offerId) {
		if (StringUtils.isEmpty(offerId) || "null".equals(offerId)) {
			return null;
		} else {
			var offer = offerPackageService.getExistingOffer(offerId);
			return offerPackageConverter.convert(offer);
		}
	}

	@PostMapping
	public OfferPackageDto createOffer(@RequestBody CreateOfferDto createOfferDto) {
		var offer = offerPackageService.createOffer(createOfferDto.getPackageCode(), createOfferDto.getDuration());
		return offerPackageConverter.convert(offer);
	}

	@PostMapping("/{offerId}/duration")
	public OfferPackageDto changeDuration(@PathVariable String offerId, @RequestBody ChangeDurationDto changeDurationDto) {
		var offer = offerPackageService.changeDuration(offerId, changeDurationDto.getDuration());
		return offerPackageConverter.convert(offer);
	}

	@PostMapping("/{offerId}/hardware")
	public OfferPackageDto selectHardware(@PathVariable String offerId, @RequestBody SelectHardwareDto selectHardwareDto) {
		var offer = offerPackageService.selectHardware(offerId, selectHardwareDto.getCode());
		return offerPackageConverter.convert(offer);
	}

	@PostMapping("/{offerId}/extra-channels")
	public OfferPackageDto selectExtraChannel(@PathVariable String offerId, @RequestBody SelectExtraChannelDto selectExtraChannelDto) {
		var offer = offerPackageService.selectExtraChannel(offerId, selectExtraChannelDto.getCode());
		return offerPackageConverter.convert(offer);
	}

	@DeleteMapping("/{offerId}/hardware/{hardwareCode}")
	public OfferPackageDto deselectHardware(@PathVariable String offerId, @PathVariable String hardwareCode) {
		var offer = offerPackageService.deselectHardware(offerId, hardwareCode);
		return offerPackageConverter.convert(offer);
	}

	@DeleteMapping("/{offerId}/extra-channels/{channelCode}")
	public OfferPackageDto deselectExtraChannel(@PathVariable String offerId, @PathVariable String channelCode) {
		var offer = offerPackageService.deselectExtraChannel(offerId, channelCode);
		return offerPackageConverter.convert(offer);
	}

	@PostMapping("/{offerId}/service")
	public OfferPackageDto selectExtraService(@PathVariable String offerId, @RequestBody SelectExtraServiceDto selectExtraServiceDto) {
		var offer = offerPackageService.selectExtraService(offerId, selectExtraServiceDto.getCode());
		return offerPackageConverter.convert(offer);
	}

	@DeleteMapping("/{offerId}/service/{serviceCode}")
	public OfferPackageDto deselectExtraService(@PathVariable String offerId, @PathVariable String serviceCode) {
		var offer = offerPackageService.deselectExtraService(offerId, serviceCode);
		return offerPackageConverter.convert(offer);
	}
}
