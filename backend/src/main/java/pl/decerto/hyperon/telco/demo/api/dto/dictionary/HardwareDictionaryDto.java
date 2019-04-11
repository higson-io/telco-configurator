package pl.decerto.hyperon.telco.demo.api.dto.dictionary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

import pl.decerto.hyperon.telco.demo.domain.HardwareCategory;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HardwareDictionaryDto {
	private HardwareCategory category;
	private String code;
	private String name;
	private String description;
	private List<String> details;
	@JsonProperty("multiroom")
	private boolean multiRoom;
}