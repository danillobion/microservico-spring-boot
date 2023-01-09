package br.com.omnilink.blacklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnilink.blacklist.models.Sentence;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long>{

}
