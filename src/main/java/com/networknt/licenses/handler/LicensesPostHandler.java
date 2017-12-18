
package com.networknt.licenses.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Contaners.ContainerManger;
import com.networknt.Mapper.ClassMapper;
import com.networknt.body.BodyHandler;
import com.networknt.licenses.model.License;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;

public class LicensesPostHandler implements HttpHandler {

	static final Logger logger = LoggerFactory.getLogger(LicensesPostHandler.class);

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);
		License newLicense = ContainerManger.service.createLicense(body);
		exchange.setStatusCode(StatusCodes.CREATED);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(ClassMapper.MAPPER.writeValueAsString(newLicense));
		exchange.endExchange();
	}
}
