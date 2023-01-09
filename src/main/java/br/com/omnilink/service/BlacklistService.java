package br.com.omnilink.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.dto.BlacklistRequest;
import br.com.omnilink.dto.BlacklistResponse;
import br.com.omnilink.models.Sentence;
import br.com.omnilink.repository.SentenceRepository;

@Service
public class BlacklistService {
	@Autowired
	private SentenceRepository sentenceRepository;

	public BlacklistResponse isTextClean(BlacklistRequest blacklistRequest) {
		List<Sentence> sentences = sentenceRepository.findAll();
		String text = blacklistRequest.toString();
		
		List<String> inappropriateSentences = new ArrayList<String>();
		for (int i = 0; i < sentences.size(); i++) {
			if(text.indexOf(sentences.get(i).getText()) != -1) {
				inappropriateSentences.add(sentences.get(i).getText());
			}
		}
		
		boolean textClean = inappropriateSentences.size() == 0;
		
		return new BlacklistResponse(textClean, inappropriateSentences);
	}
}
