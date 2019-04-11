package pl.decerto.hyperon.telco.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.IntervalDictionaryDto;
import pl.decerto.hyperon.telco.demo.converter.IntervalDictionaryConverter;
import pl.decerto.hyperon.runtime.model.HyperonDomainObject;

/**
 * @author Maciej Główka on 14.03.2019
 */
@Service
public class IntervalService {
	private final IntervalDictionaryConverter dictionaryConverter;

	public IntervalService(IntervalDictionaryConverter dictionaryConverter) {
		this.dictionaryConverter = dictionaryConverter;
	}

	public List<IntervalDictionaryDto> getALlIntervals(HyperonDomainObject root) {
		return root.getChildren("INTERVALS").stream()
			.map(dictionaryConverter::convert)
			.sorted(Comparator.comparing(dto -> dto != null ? dto.getValue() : 0))
			.collect(Collectors.toList());
	}
}
