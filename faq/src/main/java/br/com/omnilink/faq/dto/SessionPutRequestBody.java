package br.com.omnilink.faq.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SessionPutRequestBody {
	
	private Long id;
	@NotNull(message = "{session.name.not.null}")
	@NotEmpty(message = "{session.name.not.empty}")
	private String sessionName;
	private Long faqId;

}
