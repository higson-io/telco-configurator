package pl.decerto.hyperon.telco.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.HardwareDictionaryDto;
import pl.decerto.hyperon.telco.demo.converter.HardwareConverter;
import pl.decerto.hyperon.telco.demo.converter.HardwareDictionaryConverter;
import pl.decerto.hyperon.telco.demo.domain.Hardware;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Service
public class HardwareService {
	private final HardwareDictionaryConverter dictionaryConverter;
	private final HardwareConverter hardwareConverter;

	public HardwareService(HardwareDictionaryConverter dictionaryConverter, HardwareConverter hardwareConverter) {
		this.dictionaryConverter = dictionaryConverter;
		this.hardwareConverter = hardwareConverter;
	}

	public OfferPackage changeHardwareState(OfferPackage offerPackage, String hardwareCode, boolean select) {
		offerPackage.getHardware().forEach(hardware -> {
			if (StringUtils.equals(hardware.getCode(), hardwareCode)) {
				hardware.setSelected(select);
			}
		});

		return offerPackage;
	}

	public List<HardwareDictionaryDto> getAllHardware(HyperonDomainObject root) {
		return root.getChildren("HARDWARE").stream()
			.map(dictionaryConverter::convert)
			.collect(Collectors.toList());
	}

	public List<Hardware> getHardware(HyperonDomainObject packageObject) {
		return packageObject.getChildren("HARDWARE").stream()
			.map(hardware -> hardwareConverter.convert(hardware, packageObject.getCode()))
			.collect(Collectors.toList());
	}
}
