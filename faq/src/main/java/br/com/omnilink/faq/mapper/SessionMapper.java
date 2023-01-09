package br.com.omnilink.faq.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.omnilink.faq.dto.SessionPostRequestBody;
import br.com.omnilink.faq.dto.SessionPutRequestBody;
import br.com.omnilink.faq.dto.SessionResponseBody;
import br.com.omnilink.faq.entities.Session;

@Mapper(componentModel = "spring")
public abstract class SessionMapper {

	public static final SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "faq", ignore = true)
	public abstract Session toSession(SessionPostRequestBody sessionPostRequestBody);

	@Mapping(target = "faq", ignore = true)
	public abstract Session toSession(SessionPutRequestBody sessionPutRequestBody);

	@Mapping(target = "faq", ignore = true)
	public abstract Session toSession(SessionResponseBody sessionResponseBody);
	
	@Mapping(target="faqId", source="faq.id")
	public abstract SessionPostRequestBody toSessionPostRequestBody(Session session);
	
	@Mapping(target="faqId", source="faq.id")
	public abstract SessionPutRequestBody toSessionPutRequestBody(Session session);

	@Mapping(target="faqId", source="faq.id")
	public abstract SessionResponseBody toSessionResponseBody(Session session);
	
	public abstract List<Session> toSessionList(List<SessionResponseBody> sessionResponseBodyList);

	public abstract List<SessionResponseBody> toSessionResponseBodyList(List<Session> sessionList);
}
