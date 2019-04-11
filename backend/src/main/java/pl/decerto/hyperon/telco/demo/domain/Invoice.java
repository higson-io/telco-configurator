package pl.decerto.hyperon.telco.demo.domain;

import java.util.List;

import lombok.Data;

/**
 * @author Maciej Główka on 01.04.2019
 */
@Data
public class Invoice {
	private List<PaymentEntry> paymentEntries;
}
