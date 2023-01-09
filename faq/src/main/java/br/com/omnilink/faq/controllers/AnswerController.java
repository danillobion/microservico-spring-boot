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

import br.com.omnilink.faq.dto.AnswerPostRequestBody;
import br.com.omnilink.faq.dto.AnswerPutRequestBody;
import br.com.omnilink.faq.dto.AnswerResponseBody;
import br.com.omnilink.faq.facade.Facade;

@RestController
@RequestMapping("faq")
public class AnswerController {

	@Autowired
	private Facade facade;
	
	@PostMapping("/{systemName}/{sessionId}")
	public ResponseEntity<AnswerPostRequestBody> newAnswerSessionFaq(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId,
			@Valid AnswerPostRequestBody answerPostRequestBody) {
		return new ResponseEntity<>(facade.newAnswerSessionFaq(systemName, sessionId, answerPostRequestBody), HttpStatus.OK);
	}
	
	@GetMapping("/{systemName}/{sessionId}")
	public ResponseEntity<List<AnswerResponseBody>> listAllAnswersBySessionId(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId) {
		return new ResponseEntity<>(facade.listAllAnswersBySessionId(systemName, sessionId), HttpStatus.OK);
	}
	
	@PutMapping("/{systemName}/{sessionId}/{answerId}")
	public ResponseEntity<AnswerPutRequestBody> editQuestionOrAnswerOnSession(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId,
			@PathVariable("answerId") Long answerId, @Valid AnswerPutRequestBody answerPutRequestBody) {
		return new ResponseEntity<>(facade.editQuestionOrAnswerOnSession(systemName, sessionId, answerId, answerPutRequestBody), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{systemName}/{sessionId}/{answerId}")
	public ResponseEntity<Void> removeAnswerBySessionId(@PathVariable("systemName") String systemName, @PathVariable("sessionId") Long sessionId,
			@PathVariable("answerId") Long answerId) {
		facade.removeAnswerBySessionId(systemName, sessionId, answerId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
