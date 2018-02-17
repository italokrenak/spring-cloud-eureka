package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.service.SentenceService;

@RestController
public class SentenceController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SentenceService sentenceService;

	@GetMapping("/sentence")
	public String getSentence() {
		/*
		 * return getWord("LAB-4-SUBJECT") + " " + getWord("LAB-4-VERB") + " " +
		 * getWord("LAB-4-ARTICLE") + " " + getWord("LAB-4-ADJECTIVE") + " " +
		 * getWord("LAB-4-NOUN") + ".";
		 */ 
		
		return sentenceService.getWords();
	}

	public String getWord(String service) {
		return this.restTemplate.getForObject("http://" + service, String.class);
	}

}
