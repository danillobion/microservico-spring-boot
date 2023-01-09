package br.com.omnilink.blacklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.blacklist.dto.SentenceRequest;
import br.com.omnilink.blacklist.dto.SentenceResponse;
import br.com.omnilink.blacklist.facade.Facade;

@RestController
@RequestMapping("blacklist")
public class SentenceController {

	@Autowired
	private Facade facade;
	
	@GetMapping(value = "/sentence/")
	public List<SentenceResponse> listAll() {
		return facade.getAllSentences();
	}
	
	@PostMapping(value = "/sentence/")
	public SentenceResponse create(@RequestBody SentenceRequest sentence) {
		return facade.createSentence(sentence);
	}
	
	@PutMapping(value = "/sentence/")
	public SentenceResponse update(@RequestBody SentenceRequest sentence) {
		return facade.updateSentence(sentence);
	}
	
	@DeleteMapping(value = "/sentence/")
	public SentenceResponse delete(@RequestBody SentenceRequest sentence) {
		return facade.deleteSentence(sentence);
	}
}
