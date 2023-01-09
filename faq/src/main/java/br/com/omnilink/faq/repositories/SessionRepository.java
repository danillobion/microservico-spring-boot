package br.com.omnilink.faq.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnilink.faq.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findAllByFaqId(Long faqId);
	
	@Transactional
	void deleteById(Long sessionId);
}
