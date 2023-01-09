package br.com.omnilink.faq.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.omnilink.faq.dto.AnswerPostRequestBody;
import br.com.omnilink.faq.dto.AnswerPutRequestBody;
import br.com.omnilink.faq.dto.AnswerResponseBody;
import br.com.omnilink.faq.entities.Answer;

@Mapper(componentModel = "spring")
public abstract class AnswerMapper {

	public static final AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "session", ignore = true)
	public abstract Answer toAnswer(AnswerPostRequestBody answerPostRequestBody);

	@Mapping(target = "session", ignore = true)
	public abstract Answer toAnswer(AnswerPutRequestBody answerPutRequestBody);

	@Mapping(target = "session", ignore = true)
	public abstract Answer toAnswer(AnswerResponseBody answerResponseBody);

	@Mapping(target="sessionId", source="session.id")
	public abstract AnswerPostRequestBody toAnswerPostRequestBody(Answer answer);

	@Mapping(target="sessionId", source="session.id")
	public abstract AnswerPutRequestBody toAnswerPutRequestBody(Answer answer);

	@Mapping(target="sessionId", source="session.id")
	public abstract AnswerResponseBody toAnswerResponseBody(Answer answer);
	
	public abstract List<Answer> toAnswerList(List<AnswerResponseBody> answerResponseBody);

	public abstract List<AnswerResponseBody> toAnswerResponseBodyList(List<Answer> answerList);
}
