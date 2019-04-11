package pl.decerto.hyperon.telco.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Maciej Główka on 01.04.2019
 */
@Data
@AllArgsConstructor
public class PaymentEntry {
	private BigDecimal value;
	private BigDecimal valueAfterDiscounts;
	private LocalDate paymentDate;
}
