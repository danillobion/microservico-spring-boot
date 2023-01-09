package br.com.omnilink.faq.dto;

import lombok.Data;

@Data
public class SessionResponseBody {

	private Long id;
	private String sessionName;
	private Long faqId;
	
}
