package com.networknt.Contaners;

import javax.sql.DataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.Services.LicenseService;
import com.networknt.service.SingletonServiceFactory;

public class ContainerManger {

	public static LicenseService service = SingletonServiceFactory.getBean(LicenseService.class);
	public static final DataSource ds = (DataSource) SingletonServiceFactory.getBean(DataSource.class);
	
}
