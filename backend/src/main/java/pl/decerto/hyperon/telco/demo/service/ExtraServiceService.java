package pl.decerto.hyperon.telco.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraServiceDictionaryDto;
import pl.decerto.hyperon.telco.demo.converter.ExtraServiceConverter;
import pl.decerto.hyperon.telco.demo.converter.ExtraServiceDictionaryConverter;
import pl.decerto.hyperon.telco.demo.domain.ExtraService;
import pl.decerto.hyperon.telco.demo.domain.OfferPackage;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 26.03.2019
 */
@Service
public class ExtraServiceService {
	private final ExtraServiceDictionaryConverter dictionaryConverter;
	private final ExtraServiceConverter serviceConverter;

	public ExtraServiceService(ExtraServiceDictionaryConverter dictionaryConverter, ExtraServiceConverter serviceConverter) {
		this.dictionaryConverter = dictionaryConverter;
		this.serviceConverter = serviceConverter;
	}

	public List<ExtraServiceDictionaryDto> getAllServices(HyperonDomainObject root) {
		return root.getChildren("SERVICES").stream()
			.map(dictionaryConverter::convert)
			.collect(Collectors.toList());
	}

	public OfferPackage changeServiceState(OfferPackage offer, String serviceCode, boolean select) {
		offer.getExtraServices().forEach(service -> {
			if (StringUtils.equals(service.getCode(), serviceCode)) {
				service.setSelected(select);
			}
		});

		return offer;
	}

	public List<ExtraService> getExtraServices(HyperonDomainObject packageObject, OfferPackage offerPackage) {
		return packageObject.getChildren("SERVICES").stream()
			.map(extraService -> serviceConverter.convert(extraService, offerPackage))
			.collect(Collectors.toList());
	}
}
