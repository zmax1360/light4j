
package com.networknt.licenses.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Services.LicenseService;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class LicensesLicenseidDeleteHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(LicensesLicenseidDeleteHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		service.deleteLicense(licenseId);
		 exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.endExchange();

	}
}
