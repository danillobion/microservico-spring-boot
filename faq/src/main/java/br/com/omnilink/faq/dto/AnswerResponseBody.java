package br.com.omnilink.faq.dto;

import lombok.Data;

@Data
public class AnswerResponseBody {

	private Long id;
	private String question;
	private String theAnswer;
	private Long sessionId;
	
}
