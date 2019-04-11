package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import lombok.Data;

import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraChannelDictionaryDto;
import pl.decerto.hyperon.telco.demo.api.dto.dictionary.HardwareDictionaryDto;
import pl.decerto.hyperon.telco.demo.api.dto.dictionary.IntervalDictionaryDto;
import pl.decerto.hyperon.telco.demo.api.dto.dictionary.OfferPackageDictionaryDto;
import pl.decerto.hyperon.telco.demo.api.dto.dictionary.ExtraServiceDictionaryDto;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictionaryDto {
	private List<OfferPackageDictionaryDto> packages;
	private List<ExtraChannelDictionaryDto> extraChannels;
	private List<HardwareDictionaryDto> hardware;
	private List<IntervalDictionaryDto> intervals;
	private List<ExtraServiceDictionaryDto> services;
}
