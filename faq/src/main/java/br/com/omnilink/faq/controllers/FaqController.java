package br.com.omnilink.faq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.faq.dto.FaqPostRequestBody;
import br.com.omnilink.faq.dto.FaqPutRequestBody;
import br.com.omnilink.faq.dto.FaqResponseBody;
import br.com.omnilink.faq.facade.Facade;

@RestController
@RequestMapping("faq")
public class FaqController {
	
	@Autowired
	private Facade facade;

	@PostMapping(value = "/")
	public ResponseEntity<FaqPostRequestBody> newFaq (@Valid FaqPostRequestBody faqPostRequestBody) {
		return new ResponseEntity<>(facade.newFaq(faqPostRequestBody), HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<FaqResponseBody>> listAllFaq (){
		return new ResponseEntity<>(facade.listAllFaq(), HttpStatus.OK);		
	}
	
	@PutMapping(value = "/{systemName}")
	public ResponseEntity<FaqPutRequestBody> editFaqSystemName(@PathVariable String systemName, @Valid FaqPutRequestBody faqPutRequestBody) {
		return new ResponseEntity<>(facade.editFaqSystemName(systemName, faqPutRequestBody), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/{systemName}")
	public ResponseEntity<Void> removeFaqByName(@PathVariable String systemName) {
		facade.removeFaqByName(systemName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
