package br.com.omnilink.dto;

import br.com.omnilink.models.Sentence;
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