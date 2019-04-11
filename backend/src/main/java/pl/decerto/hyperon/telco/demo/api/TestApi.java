package pl.decerto.hyperon.telco.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maciej Główka on 08.04.2019
 */
@RestController
public class TestApi {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
