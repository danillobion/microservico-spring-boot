package br.com.omnilink.faq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.faq.dto.SessionPostRequestBody;
import br.com.omnilink.faq.dto.SessionPutRequestBody;
import br.com.omnilink.faq.entities.Faq;
import br.com.omnilink.faq.entities.Session;
import br.com.omnilink.faq.mapper.SessionMapper;
import br.com.omnilink.faq.repositories.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private ServicesUtils servicesUtils;

	public Session newSession(String systemName, SessionPostRequestBody sessionPostRequestBody) {
		Faq savedFaq = servicesUtils.findFaqBySystemName(systemName);
		Session session = SessionMapper.INSTANCE.toSession(sessionPostRequestBody);
		session.setFaq(savedFaq);
		return sessionRepository.save(session);
	}

	public List<Session> listAllSessionsByFaqId(String systemName) {
		Faq faq = servicesUtils.findFaqBySystemName(systemName);
		return sessionRepository.findAllByFaqId(faq.getId());
	}

	public Session editSessionName(String systemName, Long sessionId, SessionPutRequestBody sessionPutRequestBody) {
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		Session savedSession = servicesUtils.findSessionById(sessionId);
		savedSession.setSessionName(sessionPutRequestBody.getSessionName());
		return sessionRepository.save(savedSession);
	}

	public void removeSessionById(String systemName, Long sessionId) {
		servicesUtils.isValidSessionFaq(systemName, sessionId);
		sessionRepository.deleteById(sessionId);
	}

}
