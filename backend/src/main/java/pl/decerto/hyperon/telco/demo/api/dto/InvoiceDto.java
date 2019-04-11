package pl.decerto.hyperon.telco.demo.api.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Maciej Główka on 01.04.2019
 */
@Data
public class InvoiceDto {
	private List<PaymentEntryDto> values;
}
