package br.com.omnilink.blacklist.dto;

import java.util.List;

import lombok.Data;

@Data
public class BlacklistResponse {
    private List<String> inappropriateSentences;
    private boolean cleanText;
	
	public BlacklistResponse(boolean cleanText, List<String> inappropriateSentences) {
		this.inappropriateSentences = inappropriateSentences;
		this.cleanText = cleanText;
	}
}
