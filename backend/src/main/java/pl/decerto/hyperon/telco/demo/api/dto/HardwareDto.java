package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HardwareDto {
	private String code;
	private BigDecimal monthlyPayment;
	private BigDecimal activationPrice;
	private boolean selected;
	private boolean multiRoom;
}
