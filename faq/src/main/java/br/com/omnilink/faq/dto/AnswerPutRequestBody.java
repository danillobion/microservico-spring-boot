package br.com.omnilink.faq.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnswerPutRequestBody {

	private Long id;
	
	@NotNull(message = "{question.not.null}")
	@NotEmpty(message = "{question.not.empty}")
	private String question;
	
	@NotNull(message = "{asnwer.not.null}")
	@NotEmpty(message = "{answer.not.empty}")
	private String theAnswer;
	private Long sessionId;
	
}
