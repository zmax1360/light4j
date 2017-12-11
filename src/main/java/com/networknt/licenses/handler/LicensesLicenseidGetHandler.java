
package com.networknt.licenses.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Mapper.ClassMapper;
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
		LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
		String licenseId = exchange.getQueryParameters().get("licenseid").peek();
		 exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		 License l =service.getLicense(licenseId);
		if(l!=null){
		exchange.getResponseSender().send(ClassMapper.mapper(l));
		}else{
			
			Error e = new Error();
			
			e.setCode(41236157);
			e.setMessage("licenseId "+ licenseId +" has not found");
			exchange.setStatusCode(404);
			exchange.getResponseSender().send(ClassMapper.mapper(e));
		}
	}
}
