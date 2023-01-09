package br.com.omnilink.blacklist.dto;

import br.com.omnilink.blacklist.models.Sentence;
import lombok.Data;

@Data
public class SentenceRequest {
	private long id;
    private String text;

    public Sentence toSentence() {
        return Sentence.builder()
        	.id(id)
            .text(text.toLowerCase())
            .build();
    }
}