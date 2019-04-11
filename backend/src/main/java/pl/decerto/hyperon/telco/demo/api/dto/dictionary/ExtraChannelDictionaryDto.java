package pl.decerto.hyperon.telco.demo.api.dto.dictionary;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import lombok.Data;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraChannelDictionaryDto {
	private String code;
	private String name;
	private String description;
	private List<String> details;
}
