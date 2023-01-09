package br.com.omnilink.blacklist.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.blacklist.dto.BlacklistRequest;
import br.com.omnilink.blacklist.dto.BlacklistResponse;
import br.com.omnilink.blacklist.dto.SentenceRequest;
import br.com.omnilink.blacklist.dto.SentenceResponse;
import br.com.omnilink.blacklist.service.BlacklistService;
import br.com.omnilink.blacklist.service.SentenceService;

@Service
public class Facade {
	@Autowired
	private SentenceService sentenceService;
	@Autowired
	private BlacklistService blacklistService;
	
	public List<SentenceResponse> getAllSentences() {
		return sentenceService.getAllSentences();
	}
	
	public SentenceResponse createSentence(SentenceRequest sentenceRequest) {
		return sentenceService.createSentence(sentenceRequest);
	}
	
	public SentenceResponse updateSentence(SentenceRequest sentenceRequest) {
		return sentenceService.updateSentence(sentenceRequest);
	}
	
	public SentenceResponse deleteSentence(SentenceRequest sentenceRequest) {
		return sentenceService.deleteSentence(sentenceRequest);
	}
	
	public BlacklistResponse isTextClean(BlacklistRequest blacklistRequest) {
		return blacklistService.isTextClean(blacklistRequest);
	}
}
