package pl.decerto.hyperon.telco.demo.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.decerto.hyperon.telco.demo.api.dto.ChangeDateDto;
import pl.decerto.hyperon.telco.demo.domain.SelectedDateHolder;

/**
 * @author Maciej Główka on 12.03.2019
 */
@RestController
@RequestMapping("/version")
public class VersionApi {
	private static Logger log = LoggerFactory.getLogger(VersionApi.class);

	private SelectedDateHolder selectedDateHolder;

	public VersionApi(SelectedDateHolder selectedDateHolder) {
		this.selectedDateHolder = selectedDateHolder;
	}

	@PostMapping
	public void setDate(@RequestBody ChangeDateDto changeDateDto) {
		log.info("setting date:{}", changeDateDto);
		selectedDateHolder.setDate(convertToDate(changeDateDto.getDate()));
	}

	private Date convertToDate(LocalDate receivedDate) {
		//add one second for hyperon schedul :c
		LocalDateTime selectedDateTime = receivedDate.atStartOfDay().plus(1, ChronoUnit.SECONDS);

		return Date.from(selectedDateTime.plus(1, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant());
	}
}
