package br.com.omnilink.faq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.faq.dto.AnswerPostRequestBody;
import br.com.omnilink.faq.dto.AnswerPutRequestBody;
import br.com.omnilink.faq.entities.Answer;
import br.com.omnilink.faq.entities.Session;
import br.com.omnilink.faq.mapper.AnswerMapper;
import br.com.omnilink.faq.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private ServicesUtils servicesUtils;

	public Answer newAnswer(String systemName, Long sessionId, AnswerPostRequestBody answerPostRequestBody) {
		Session savedSession = servicesUtils.findSessionById(sessionId);
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		Answer answer = AnswerMapper.INSTANCE.toAnswer(answerPostRequestBody);
		answer.setSession(savedSession);
		return answerRepository.save(answer);
	}

	public List<Answer> listAllAnswersBySessionId(String systemName, Long sessionId) {
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		return answerRepository.findAllBySessionId(sessionId);
	}

	public Answer editQuestionOrAnswerOnSession(String systemName, Long sessionId, Long answerId,
			AnswerPutRequestBody answerPutRequestBody) {
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		servicesUtils.isValidAnswerSession(answerId, sessionId);
		Answer savedAnswer = servicesUtils.findAnswerById(answerId);
		savedAnswer.setQuestion(answerPutRequestBody.getQuestion());
		savedAnswer.setTheAnswer(answerPutRequestBody.getTheAnswer());
		return answerRepository.save(savedAnswer);
	}

	public void removeAnswerBySessionId(String systemName, Long sessionId, Long answerId) {
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		servicesUtils.isValidAnswerSession(answerId, sessionId);
		answerRepository.deleteById(answerId);
	}

}
