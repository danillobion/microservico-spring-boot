package br.com.omnilink.faq.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnilink.faq.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

	List<Answer> findAllBySessionId(Long sessionId);
	
	@Transactional
	void deleteBySessionId(Long sessionId);
	
}
