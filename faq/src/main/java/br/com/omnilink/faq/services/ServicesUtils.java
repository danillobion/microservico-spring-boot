package br.com.omnilink.faq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.omnilink.faq.entities.Answer;
import br.com.omnilink.faq.entities.Faq;
import br.com.omnilink.faq.entities.Session;
import br.com.omnilink.faq.repositories.AnswerRepository;
import br.com.omnilink.faq.repositories.FaqRepository;
import br.com.omnilink.faq.repositories.SessionRepository;

@Service
public class ServicesUtils {

	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private FaqRepository faqRepository;
	
	/*
	 * FaqService
	 */
	public Faq findFaqBySystemName (String systemName) {
		return faqRepository.findBySystemName(systemName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found FAQ: " + systemName));
	}
	
	public boolean systemNameAlreadyExists(String systemName) {
		if(faqRepository.findBySystemName(systemName).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "System name: " + systemName + " already exists, choose other!");
		} else {
			return false;
		}
	}
	
	/*
	 * SessionService
	 */
	public Session findSessionById(Long id) {
		return sessionRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found session id: " + id));
	}
	
	public boolean isValidSessionFaq(String systemName, Long sessionId) {
		Faq faq = findFaqBySystemName(systemName);
		Session session = findSessionById(sessionId);
		if(!faq.getId().equals(session.getFaq().getId()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found session id: " + sessionId + "on FAQ: " + systemName);
		return true;
	}
	
	/*
	 * AnswerService
	 */
	public Answer findAnswerById (Long id) {
		return answerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found answer id: " + id));
	}
	
	public boolean isValidAnswerSession(Long answerId, Long sessionId) {
		Answer answer = findAnswerById(answerId);
		Session session = findSessionById(sessionId);
		if(!session.getId().equals(answer.getSession().getId()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found answer id: " + answerId + "on Session id: " + sessionId);
		return true;
	}
	
}
