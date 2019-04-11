package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraChannelDto {
	private String code;
	private BigDecimal price;
	private boolean selected;
}
