package br.com.omnilink.faq.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/messages/validation_messages"
		// ,"classpath:/messages/.._messages"
		);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
}
