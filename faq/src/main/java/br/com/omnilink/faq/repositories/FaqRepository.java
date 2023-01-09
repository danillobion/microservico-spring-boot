package br.com.omnilink.faq.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnilink.faq.entities.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>{

	public Optional<Faq> findBySystemName(String systemName);
	
}
