
package com.networknt.licenses.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Contaners.ContainerManger;
import com.networknt.Mapper.ClassMapper;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class LicensesGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(ClassMapper.MAPPER.writeValueAsString(ContainerManger.service.getall()));
	
	}
}
	