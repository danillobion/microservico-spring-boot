package br.com.omnilink.faq.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.omnilink.faq.dto.FaqPostRequestBody;
import br.com.omnilink.faq.dto.FaqPutRequestBody;
import br.com.omnilink.faq.dto.FaqResponseBody;
import br.com.omnilink.faq.entities.Faq;

@Mapper(componentModel = "spring")
public abstract class FaqMapper {

	public static final FaqMapper INSTANCE = Mappers.getMapper(FaqMapper.class);
	
	@Mapping(target = "id", ignore = true)
	public abstract Faq toFaq(FaqPostRequestBody faqPostRequestBody);
	
	public abstract Faq toFaq(FaqPutRequestBody faqPutRequestBody);
	
	public abstract Faq toFaq(FaqResponseBody faqPutRequestBody);
	
	public abstract FaqPostRequestBody toFaqPostRequestBody(Faq faq);
	
	public abstract FaqPutRequestBody toFaqPutRequestBody(Faq faq);
	
	public abstract FaqResponseBody toFaqResponseBody(Faq faq);
	
	public abstract List<Faq> toFaqList(List<FaqResponseBody> faqResponseBodyList);
	
	public abstract List<FaqResponseBody> toFaqResponseBodyList(List<Faq> faqList);
}
