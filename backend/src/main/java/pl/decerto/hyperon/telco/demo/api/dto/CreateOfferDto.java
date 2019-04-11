package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
public class CreateOfferDto {
	@JsonProperty("package")
	private String packageCode;
	private int duration;
}
