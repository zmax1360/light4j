
package com.networknt.licenses.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Contaners.ContainerManger;
import com.networknt.Mapper.ClassMapper;
import com.networknt.licenses.model.Error;
import com.networknt.licenses.model.License;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;

public class LicensesLicenseidGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesLicenseidGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		License license = ContainerManger.service.getLicenseById(licenseId);
		String output;
		if (license == null) {
			Error e = new Error("licenseId " + licenseId + " has not found",new Date().getTime(),"not found",this.getClass().getName(),exchange.getRequestURI(),404);					
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = ClassMapper.MAPPER.writeValueAsString(e);
			
		} else {
			output = ClassMapper.MAPPER.writeValueAsString(license);
		}
		exchange.setStatusCode(StatusCodes.ACCEPTED);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send((output));
	}
}
