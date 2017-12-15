
package com.networknt.licenses.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.util.StatusCodes;
import com.networknt.Services.LicenseService;
import com.networknt.licenses.model.Error;
import com.networknt.licenses.model.License;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class LicensesLicenseidGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesLicenseidGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		final ObjectMapper mapper = new ObjectMapper();
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		License license = service.getLicense(licenseId);
		String output;
		if (license == null) {
			Error e = new Error("licenseId " + licenseId + " has not found",new Date().getTime(),"not found",this.getClass().getName(),exchange.getRequestURI(),404);					
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = mapper.writeValueAsString(e);
			
		} else {
			output = mapper.writeValueAsString(license);
		}
		exchange.setStatusCode(StatusCodes.ACCEPTED);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send((output));
	}
}
