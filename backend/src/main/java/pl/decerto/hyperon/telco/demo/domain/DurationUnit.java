package pl.decerto.hyperon.telco.demo.domain;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Maciej Główka on 11.03.2019
 */
public enum DurationUnit {
	MONTH("month");

	private String value;

	DurationUnit(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}

