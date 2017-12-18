DROP TABLE IF EXISTS License;
CREATE TABLE License(
licenseId VARCHAR(255) PRIMARY KEY,
organizationId VARCHAR(255),
organizationName VARCHAR(255),
contactEmail VARCHAR(255),
contactName VARCHAR(255),
license_type VARCHAR(255),
comment VARCHAR(255),
contactPhone VARCHAR(255),
productName VARCHAR(255),
license_max INT,
license_allocated INT
);
INSERT INTO License(LICENSEID ,ORGANIZATIONID ,ORGANIZATIONNAME ,CONTACTEMAIL ,CONTACTNAME ,LICENSE_TYPE ,COMMENT ,CONTACTPHONE ,PRODUCTNAME ,LICENSE_MAX ,LICENSE_ALLOCATED ) VALUES
('CIBC32030', '32030','CIBC','CIBC@CIBC.com','ali','renewable','','777','office',10,2),
('CIBC32032', '32032','CIBC','CIBC@C.com','jo','renewable','','888','windows',100,2),
('CIBC32033', '32033','CIBC2','CIBC@BC.com','peter','onetime','','999','sql server',10,9);