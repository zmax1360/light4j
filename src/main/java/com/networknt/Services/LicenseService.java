package com.networknt.Services;

import java.util.ArrayList;
import java.util.Map;

import com.networknt.licenses.model.License;

public interface LicenseService {

	ArrayList<License> getall();

	void setLicense(Map<String, Object> MapLicense);

	License getLicense(String licenseId);
	
	void deleteLicense(String licenseId);

}