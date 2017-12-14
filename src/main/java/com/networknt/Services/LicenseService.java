package com.networknt.Services;

import java.util.ArrayList;
import java.util.Map;

import com.networknt.licenses.model.License;

public interface LicenseService {

	ArrayList<License> getall();

	License setLicense(Map<String, Object> MapLicense);

	License getLicense(String licenseId);
	
	void deleteLicense(String licenseId);
	
	License updateLicense(String licenseId,Map<String, Object> bodyLicense);

}