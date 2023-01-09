package br.com.omnilink.blacklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.blacklist.dto.SentenceRequest;
import br.com.omnilink.blacklist.dto.SentenceResponse;
import br.com.omnilink.blacklist.models.Sentence;
import br.com.omnilink.blacklist.repository.SentenceRepository;

@Service
public class SentenceService {
	@Autowired
	private SentenceRepository sentenceRepository;
	
	public List<SentenceResponse> getAllSentences(){
		List<Sentence> sentences = sentenceRepository.findAll();
		return sentences.stream().map(SentenceResponse::new).toList();
	}
	
	public SentenceResponse createSentence(SentenceRequest sentenceRequest) {
		return new SentenceResponse(sentenceRepository.save(sentenceRequest.toSentence()));
	}
	
	public SentenceResponse updateSentence(SentenceRequest sentenceRequest) {
		Sentence sentence = sentenceRepository.findById(sentenceRequest.getId()).orElseThrow( 
                () -> new RuntimeException("It doesn't exist Sentence with id = " + sentenceRequest.toSentence().getId()));
		
		sentence.setText(sentenceRequest.getText());
		return new SentenceResponse(sentenceRepository.save(sentence));
	}
	
	public SentenceResponse deleteSentence(SentenceRequest sentenceRequest) {
		try {
			sentenceRepository.deleteById(sentenceRequest.getId());
			return new SentenceResponse(sentenceRequest.getId()); 
		} catch (Exception e) {
			throw new RuntimeException("It doesn't exist Sentence with id = " + sentenceRequest.getId());
		}
		
	}

}
