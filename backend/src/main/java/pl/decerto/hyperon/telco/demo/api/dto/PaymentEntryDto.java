package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

/**
 * @author Maciej Główka on 01.04.2019
 */
@Data
public class PaymentEntryDto {
	private BigDecimal value;
	private BigDecimal valueAfterDiscounts;
	private LocalDate paymentDate;
}
