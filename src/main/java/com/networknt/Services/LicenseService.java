package com.networknt.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.networknt.licenses.model.License;

public interface LicenseService {

	ArrayList<License> getall() throws SQLException;

	License createLicense(Map<String, Object> MapLicense) throws SQLException;

	License getLicenseById(String licenseId) throws SQLException;
	
	void deleteLicenseById(String licenseId) throws SQLException;
	
	License updateLicenseById(String licenseId,Map<String, Object> bodyLicense)throws SQLException;

}