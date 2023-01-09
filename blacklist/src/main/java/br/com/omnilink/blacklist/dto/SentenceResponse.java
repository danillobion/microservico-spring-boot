package br.com.omnilink.blacklist.dto;

import br.com.omnilink.blacklist.models.Sentence;
import lombok.Data;

@Data
public class SentenceResponse {
	private long id;
    private String text;
	
	public SentenceResponse(Sentence s) {
		this.id = s.getId();
		this.text = s.getText();
	}
	
	public SentenceResponse(long id) {
		this.id = id;
		this.text = "";
	}
}
