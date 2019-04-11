package pl.decerto.hyperon.telco.demo.api.dto.dictionary;

import lombok.Data;

/**
 * @author Maciej Główka on 13.03.2019
 */
@Data
public class IntervalDictionaryDto {
	private int value;
	private String unit;
	private String displayUnitValue;
}
