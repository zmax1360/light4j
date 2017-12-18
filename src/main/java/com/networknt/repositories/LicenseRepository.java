package com.networknt.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.networknt.Contaners.ContainerManger;
import com.networknt.licenses.model.License;

public class LicenseRepository {

	public static ArrayList<License> getAll() throws SQLException {
		ArrayList<License> listLicense = new ArrayList<>();
		try (Connection dbConnection = ContainerManger.ds.getConnection()) {
			String sql = "select * from License";
			Statement st = dbConnection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				License l = new License(rs.getString("licenseId"), rs.getString("productName"),
						rs.getString("organizationName"), rs.getString("contactEmail"), rs.getString("contactName"),
						rs.getString("license_type"), rs.getInt("license_max"), rs.getString("comment"),
						rs.getString("licenseId"), rs.getString("contactPhone"), rs.getInt("license_allocated"));
				listLicense.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return listLicense.size() > 0 ? listLicense : null;
	}

	public static License getById(String Id) throws SQLException {
		ArrayList<License> listLicense = new ArrayList<>();
		String sql = "select * FROM License where licenseId = ?";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {
			query.setString(1, Id);

			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				License l = new License(rs.getString("licenseId"), rs.getString("productName"),
						rs.getString("organizationName"), rs.getString("contactEmail"), rs.getString("contactName"),
						rs.getString("license_type"), rs.getInt("license_max"), rs.getString("comment"),
						rs.getString("licenseId"), rs.getString("contactPhone"), rs.getInt("license_allocated"));
				listLicense.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return listLicense.size() > 0 ? listLicense.get(0) : null;
	}

	public static void deleteById(String Id) throws SQLException {
		String sql = "DELETE FROM License where licenseId = ?";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {

			query.setString(1, Id);

			query.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static License createLicense(License license) throws SQLException {
		String sql = "INSERT INTO License(LICENSEID ,ORGANIZATIONID ,ORGANIZATIONNAME ,CONTACTEMAIL ,CONTACTNAME ,LICENSE_TYPE ,COMMENT ,CONTACTPHONE ,PRODUCTNAME ,LICENSE_MAX ,LICENSE_ALLOCATED ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {

			query.setString(1, license.getLicenseId());
			query.setString(2, license.getOrganizationId());
			query.setString(3, license.getOrganizationName());
			query.setString(4, license.getContactEmail());
			query.setString(5, license.getContactName());
			query.setString(6, license.getLicense_type());
			query.setString(7, license.getComment());
			query.setString(8, license.getContactPhone());
			query.setString(9, license.getProductName());
			query.setInt(10, license.getLicense_max());
			query.setInt(11, license.getLicense_allocated());

			query.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return getById(license.getLicenseId());

	}

	public static License updateLicense(License license) throws SQLException {
		String sql = "update License set ORGANIZATIONID = ? and ORGANIZATIONNAME =? and CONTACTEMAIL = ? and CONTACTNAME = ? and LICENSE_TYPE = ? and COMMENT =? and CONTACTPHONE =? and PRODUCTNAME  =? and LICENSE_MAX  =? and LICENSE_ALLOCATED  =? where LICENSEID =? ";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement update = dbConnection.prepareStatement(sql)) {

			update.setString(1, license.getOrganizationId());
			update.setString(2, license.getOrganizationName());
			update.setString(3, license.getContactEmail());
			update.setString(4, license.getContactName());
			update.setString(5, license.getLicense_type());
			update.setString(6, license.getComment());
			update.setString(7, license.getContactPhone());
			update.setString(8, license.getProductName());
			update.setInt(9, license.getLicense_max());
			update.setInt(10, license.getLicense_allocated());
			update.setString(11, license.getLicenseId());
			update.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return getById(license.getLicenseId());

	}

}
