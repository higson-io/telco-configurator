package pl.decerto.hyperon.telco.demo.api.dto.dictionary;

import java.math.BigDecimal;

import lombok.Data;

import pl.decerto.hyperon.telco.demo.domain.DurationUnit;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
public class PromotionDictionaryDto {
	private BigDecimal price;
	private int duration;
	private DurationUnit unit;
}
