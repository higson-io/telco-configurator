package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author Maciej Główka on 14.03.2019
 */
@Data
public class ChangeDateDto {
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate date;
}
