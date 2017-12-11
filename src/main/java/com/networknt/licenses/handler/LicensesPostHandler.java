
package com.networknt.licenses.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Services.LicenseService;
import com.networknt.body.BodyHandler;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class LicensesPostHandler implements HttpHandler {
	
	static final Logger logger = LoggerFactory.getLogger(LicensesPostHandler.class);

	@SuppressWarnings("unchecked")
	@Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
    	final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);
    	service.setLicense(body); 
    	logger.info("Size of list after get", service.getall().size());
    	
            exchange.endExchange();
    }
}
