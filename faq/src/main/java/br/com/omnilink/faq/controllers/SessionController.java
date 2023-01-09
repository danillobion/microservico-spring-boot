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

import br.com.omnilink.faq.dto.SessionPostRequestBody;
import br.com.omnilink.faq.dto.SessionPutRequestBody;
import br.com.omnilink.faq.dto.SessionResponseBody;
import br.com.omnilink.faq.facade.Facade;

@RestController
@RequestMapping("faq")
public class SessionController {

	@Autowired
	private Facade facade;
	
	@PostMapping(value = "/{systemName}")
	public ResponseEntity<SessionPostRequestBody> newSessionFaq(@PathVariable("systemName") String systemName, @Valid SessionPostRequestBody sessionPostRequestBody) {
		return new ResponseEntity<>(facade.newSessionFaq(systemName, sessionPostRequestBody), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{systemName}")
	public ResponseEntity<List<SessionResponseBody>> listAllSessionsByFaqId(@PathVariable("systemName") String systemName) {
		return new ResponseEntity<>(facade.listAllSessionsByFaqId(systemName), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{systemName}/{sessionId}")
	public ResponseEntity<SessionPutRequestBody> editSessionName(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId,
			@Valid SessionPutRequestBody sessionPutRequestBody) {
		return new ResponseEntity<>(facade.editSessionName(systemName, sessionId, sessionPutRequestBody), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/{systemName}/{sessionId}")
	public ResponseEntity<Void> removeSessionByFaqId(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId) {
		facade.removeSessionByFaqId(systemName, sessionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
