package com.networknt.licenses.handler;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.Contaners.ContainerManger;
import com.networknt.Mapper.ClassMapper;
import com.networknt.Services.LicenseService;
import com.networknt.body.BodyHandler;
import com.networknt.licenses.model.Error;
import com.networknt.licenses.model.License;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;

public class LicensesLicenseidPutHandler implements HttpHandler {

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);

		License license = ContainerManger.service.getLicenseById(licenseId);
		String output;
		if (license == null) {
			Error e = new Error("licenseId " + licenseId + " has not found", new Date().getTime(), "not found",
					this.getClass().getName(), exchange.getRequestURI(), 404);
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = ClassMapper.MAPPER.writeValueAsString(e);

		} else {

			ContainerManger.service.updateLicenseById(licenseId, body);
			exchange.setStatusCode(StatusCodes.OK);
			output = ClassMapper.MAPPER.writeValueAsString(license);
		}
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send((output));

	}

}
