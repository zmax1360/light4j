
package com.networknt.licenses.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.Mapper.ClassMapper;
import com.networknt.Services.LicenseService;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.PathTemplateMatch;

public class LicensesGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {

		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		PathTemplateMatch pathMatch = exchange.getAttachment(PathTemplateMatch.ATTACHMENT_KEY);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(ClassMapper.mapper(service.getall()));
	
	}
}
