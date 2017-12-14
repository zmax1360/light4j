
package com.networknt.licenses.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.Services.LicenseService;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class LicensesGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		final ObjectMapper mapper = new ObjectMapper();
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(mapper.writeValueAsString(service.getall()));
	
	}
}
