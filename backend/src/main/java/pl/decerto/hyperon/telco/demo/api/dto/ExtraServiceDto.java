package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Maciej Główka on 27.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraServiceDto {
	private String code;
	private BigDecimal monthlyPrice;
	private BigDecimal monthlyPriceAfterDiscounts;
	private BigDecimal activationPrice;
	private boolean selected;
}
