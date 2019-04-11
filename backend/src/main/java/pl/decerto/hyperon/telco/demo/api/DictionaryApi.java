package pl.decerto.hyperon.telco.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.decerto.hyperon.telco.demo.api.dto.DictionaryDto;
import pl.decerto.hyperon.telco.demo.service.DictionaryService;

@RestController
@RequestMapping("/dictionaries")
public class DictionaryApi {

	private final DictionaryService dictionaryService;

	@Autowired
	public DictionaryApi(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@GetMapping
	public DictionaryDto getAllDictionaries() {
		return dictionaryService.getAll();
	}
}
