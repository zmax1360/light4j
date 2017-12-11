package com.networknt.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.networknt.licenses.model.License;

public class LicenseServiceImpl implements LicenseService {

	
	static private Map<String, License> licenses = new ConcurrentHashMap<String, License>();
	
	public LicenseServiceImpl(){
		License license = new License("CIBC32030","office","CIBC","CIBC@CIBC.com","office2013","renewable",100,"only for windows10","1021","800",10);
		License license2 = new License("CIBC32031","windows","CIBC","CIBC@CIBC.com","windows","onetime",10,"only for windows10","1022","800",10);
		License license3 = new License("CIBC32032","IIS","CIBC","CIBC@CIBC.com","IIS","renewable",20,"only for windows10","1023","800",10);
		licenses.put(license.getLicenseId(),license);
		licenses.put(license2.getLicenseId(),license2);
		licenses.put(license3.getLicenseId(),license3);
		
	}
	
	@Override
	public ArrayList<License> getall(){
		ArrayList<License> icenseValue = new ArrayList<>(licenses.values());
		ArrayList<License> LicensesList = new ArrayList<>();
		icenseValue.stream().forEach(x->LicensesList.add(licenses.get(x.getLicenseId())));
		return LicensesList;
	}
	@Override
	public void setLicense(Map<String, Object> MapLicense) {
		License l = new License(MapLicense);
		licenses.put(l.getLicenseId(),l);
		
	}

	@Override
	public License getLicense(String licenseId) {
		return licenses.get(licenseId);
	}

	@Override
	public void deleteLicense(String licenseId) {
		
		licenses.remove(licenseId);
		
	}
	
}
