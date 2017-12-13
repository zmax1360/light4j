package com.networknt.licenses.handler;

import java.util.Map;

import com.networknt.Services.LicenseService;
import com.networknt.body.BodyHandler;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class LicensesLicenseidPutHandler implements HttpHandler {

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);
    	service.updateLicense(licenseId,body); 
    	exchange.endExchange();

	}

}
