package br.com.omnilink.faq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.faq.dto.FaqPostRequestBody;
import br.com.omnilink.faq.dto.FaqPutRequestBody;
import br.com.omnilink.faq.entities.Faq;
import br.com.omnilink.faq.mapper.FaqMapper;
import br.com.omnilink.faq.repositories.FaqRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	@Autowired
	private ServicesUtils servicesUtils;

	public Faq newFaq(FaqPostRequestBody faqPostRequestBody) {
		servicesUtils.systemNameAlreadyExists(faqPostRequestBody.getSystemName());
		return faqRepository.save(FaqMapper.INSTANCE.toFaq(faqPostRequestBody));
	}
	
	public List<Faq> listAllFaq() {
		return faqRepository.findAll();
	}

	public Faq editFaqSystemName(String systemName, FaqPutRequestBody faqPutRequestBody) {
		Faq editedFaq = servicesUtils.findFaqBySystemName(systemName);
		servicesUtils.systemNameAlreadyExists(faqPutRequestBody.getSystemName());
		editedFaq.setSystemName(faqPutRequestBody.getSystemName());
		return faqRepository.save(editedFaq);
	}

	public void removeFaqByName(String systemName) {
		faqRepository.delete(servicesUtils.findFaqBySystemName(systemName));
	}
	
}
