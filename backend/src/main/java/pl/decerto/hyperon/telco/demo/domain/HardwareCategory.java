package pl.decerto.hyperon.telco.demo.domain;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Maciej Główka on 11.03.2019
 */
public enum HardwareCategory {
	DECODER("decoder");

	private String value;

	HardwareCategory(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
