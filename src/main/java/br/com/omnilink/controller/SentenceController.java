package br.com.omnilink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.dto.SentenceRequest;
import br.com.omnilink.dto.SentenceResponse;
import br.com.omnilink.facade.Facade;

@RestController
@RequestMapping("/sentence/")
public class SentenceController {

	@Autowired
	private Facade facade;
	
	@GetMapping(value = "/")
	public List<SentenceResponse> listAll() {
		return facade.getAllSentences();
	}
	
	@PostMapping(value = "/")
	public SentenceResponse create(@RequestBody SentenceRequest sentence) {
		return facade.createSentence(sentence);
	}
	
	@PutMapping(value = "/")
	public SentenceResponse update(@RequestBody SentenceRequest sentence) {
		return facade.updateSentence(sentence);
	}
	
	@DeleteMapping(value = "/")
	public SentenceResponse delete(@RequestBody SentenceRequest sentence) {
		return facade.deleteSentence(sentence);
	}
}
