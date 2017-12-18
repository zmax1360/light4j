package com.networknt.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.networknt.licenses.model.License;
import com.networknt.repositories.LicenseRepository;

public class LicenseServiceImpl implements LicenseService  {

	
	
	
	public LicenseServiceImpl(){

	}
	
	@Override
	public ArrayList<License> getall() throws SQLException {
		//ArrayList<License> LicensesList = new ArrayList<>();
		//licenses.values().stream().forEach(x->LicensesList.add(licenses.get(x.getLicenseId())));
		return LicenseRepository.getAll();
	}
	@Override
	public License  createLicense(Map<String, Object> MapLicense) throws SQLException {
		License newLicense = new License(MapLicense);
		//licenses.put(newLicense.getLicenseId(),newLicense);
		return LicenseRepository.createLicense(newLicense);
		
	}

	@Override
	public License getLicenseById(String licenseId) throws SQLException {
		return LicenseRepository.getById(licenseId);
	}

	@Override
	public void deleteLicenseById(String licenseId) throws SQLException {
		
		//licenses.remove(licenseId);
		LicenseRepository.deleteById(licenseId);
	}

	@Override
	public License updateLicenseById(String licenseId,Map<String, Object> bodyLicense) throws SQLException {
		License  updatedlicenses= new License(bodyLicense);
		
		return LicenseRepository.updateLicense(updatedlicenses);
	}
	
}
