package br.com.omnilink.faq.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.faq.dto.AnswerPostRequestBody;
import br.com.omnilink.faq.dto.AnswerPutRequestBody;
import br.com.omnilink.faq.dto.AnswerResponseBody;
import br.com.omnilink.faq.dto.FaqPostRequestBody;
import br.com.omnilink.faq.dto.FaqPutRequestBody;
import br.com.omnilink.faq.dto.FaqResponseBody;
import br.com.omnilink.faq.dto.SessionPostRequestBody;
import br.com.omnilink.faq.dto.SessionPutRequestBody;
import br.com.omnilink.faq.dto.SessionResponseBody;
import br.com.omnilink.faq.mapper.AnswerMapper;
import br.com.omnilink.faq.mapper.FaqMapper;
import br.com.omnilink.faq.mapper.SessionMapper;
import br.com.omnilink.faq.services.AnswerService;
import br.com.omnilink.faq.services.FaqService;
import br.com.omnilink.faq.services.SessionService;

@Service
public class Facade {

	@Autowired
	private FaqService faqService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private AnswerService answerService;
	
	/*
	 * FAQ
	 */
	public FaqPostRequestBody newFaq(FaqPostRequestBody faqPostRequestBody) {
		return FaqMapper.INSTANCE.toFaqPostRequestBody(faqService.newFaq(faqPostRequestBody));
	}


	public List<FaqResponseBody> listAllFaq() {
		return FaqMapper.INSTANCE.toFaqResponseBodyList(faqService.listAllFaq());
	}

	public FaqPutRequestBody editFaqSystemName(String systemName, FaqPutRequestBody faqPutRequestBody) {
		return FaqMapper.INSTANCE.toFaqPutRequestBody(faqService.editFaqSystemName(systemName, faqPutRequestBody));
	}
	
	public void removeFaqByName(String systemName) {
		faqService.removeFaqByName(systemName);
	}
	
	/*
	 * Sessions
	 */
	public SessionPostRequestBody newSessionFaq(String systemName, SessionPostRequestBody sessionPostRequestBody) {
		return SessionMapper.INSTANCE.toSessionPostRequestBody(sessionService.newSession(systemName, sessionPostRequestBody));
	}

	public List<SessionResponseBody> listAllSessionsByFaqId(String systemName) {
		return SessionMapper.INSTANCE.toSessionResponseBodyList(sessionService.listAllSessionsByFaqId(systemName));
	}

	public SessionPutRequestBody editSessionName(String systemName, Long sessionId, SessionPutRequestBody sessionPutRequestBody) {
		return SessionMapper.INSTANCE.toSessionPutRequestBody(sessionService.editSessionName(systemName, sessionId, sessionPutRequestBody));
	}

	public void removeSessionByFaqId(String systemName, Long sessionId) {
		sessionService.removeSessionById(systemName, sessionId);
	}

	/*
	 * Answers
	 */
	public AnswerPostRequestBody newAnswerSessionFaq(String systemName, Long sessionId, AnswerPostRequestBody answerPostRequestBody) {
		return AnswerMapper.INSTANCE.toAnswerPostRequestBody(answerService.newAnswer(systemName, sessionId, answerPostRequestBody));
	}


	public List<AnswerResponseBody> listAllAnswersBySessionId(String systemName, Long sessionId) {
		return AnswerMapper.INSTANCE.toAnswerResponseBodyList(answerService.listAllAnswersBySessionId(systemName, sessionId));
	}


	public AnswerPutRequestBody editQuestionOrAnswerOnSession(String systemName, Long sessionId, Long answerId, 
			AnswerPutRequestBody answerPutRequestBody) {
		return AnswerMapper.INSTANCE.toAnswerPutRequestBody(answerService.editQuestionOrAnswerOnSession(systemName, sessionId, answerId,
				answerPutRequestBody));
	}


	public void removeAnswerBySessionId(String systemName, Long sessionId, Long answerId) {
		answerService.removeAnswerBySessionId(systemName, sessionId, answerId);
	}

}
