package br.com.omnilink.faq.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FaqPostRequestBody {

	@NotNull(message = "{system.name.not.null}")
	@NotEmpty(message = "{system.name.not.empty}")
	private String systemName;
	
}
