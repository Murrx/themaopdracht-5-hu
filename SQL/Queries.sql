/* 

-- @author(MartinBakker)

GarbageCollectors 2.0 Naming conventions:


### -- ORACLE TABLE AND COLUMNS -- ###

	## Table names: prefix(1)_plural(2)
		Ex. " USR_USERS "
		
		-- (1): The prefix gives an abbreviation of the table name, to be used in the column names.
		-- (2): Ex. USERS, RIGHTS, AUCTIONS, etc.
		
	## Column names: table-prefix_singular(1)
		Ex. " USR_PK(2)_USER_ID
		
		-- (1): Ex. USER_ID, EMAIL, PASSWORD, ADDRESS
		-- (2): Primary_Keys and Foreign_Keys get the prefix _PK and _FK. Note: This prefix is noted behind the table-prefix.


### -- CONSTRAINTS -- ###


	## Primary Keys: CONSTRAINT USR_PK_USERS(1) PRIMARY KEY (USR_PK_USER_ID)
		
		-- (1): Naming the Constraint by specifying the table-refix_PK_<table_name>


### -- PL / SQL -- ###

	## 

TODO: 

	o find out how to make variable names for procedures and table names and whatever.
	o CREATE TABLESPACE USR_USERS SIZE 100M AUTOEXTEND ON MAXSIZE 500M;

*/

---------------------------------------------------

CREATE TABLE USR_USERS (
         USR_PK_USER_ID			NUMBER(8) NOT NULL,
         USR_EMAIL				VARCHAR2(64) NOT NULL,
         USR_PASSWORD			VARCHAR2(64) NOT NULL,
		 USR_DISPLAY_NAME		VARCHAR2(64) NOT NULL,
         USR_FK_RIGHT_ID		NUMBER(8) NOT NULL,			-- FK of User Rights
		 USR_FK_PERSON_ID		NUMBER(8) NOT NULL,			-- FK of Persons
		 
		CONSTRAINT USR_PK_USERS 
			PRIMARY KEY (USR_PK_USER_ID)					-- PK of USER
);
		
		
CREATE TABLE PRS_PERSONS (
		PRS_PK_PERSON_ID NUMBER(8) NOT NULL,
		PRS_FIRST_NAME VARCHAR2(64) NOT NULL,
		PRS_LAST NAME VARCHAR2(64) NOT NULL,
		PRS_GENDER NUMBER(1) NOT NULL,
		PRS_BIRTHDATE DATE NOT NULL,
		PRS_FK_ADDRESS_ID NUMBER(8) NOT NULL,				-- FK of Addresses
		
		CONSTRAINT PRS_PK_PERSONS 
			PRIMARY KEY (PRS_PK_PERSON_ID)					-- PK of Persons
);
		
CREATE TABLE ADR_ADDRESSES (
		ADR_PK_ADDRESS_ID NUMBER(8),
		ADR_POSTAL_CODE VARCHAR(8),
		ADR_HOUSE_NUMBER VARCHAR(16),
		ADR_STREET VARCHAR2(64) NOT NULL,
		ADR_CITY VARCHAR2(64) NOT NULL,
		
		CONSTRAINT ADR_PK_ADDRESSES 
			PRIMARY KEY (ADR_PK_ADDRESS_ID)						-- PK of Addresses
			
);
		
/* --- FOREIGN KEYS CONSTRAINTS --- */
		 
/* CONSTRAINT FK_USR_RIGHT_ID
	FOREIGN KEY (USR_FK_RIGHT_ID)
	REFERENCES USR_RIGHTS (USR_PK_RIGHT_ID), */
	
CONSTRAINT FK_USR_PERSON_ID
	FOREIGN KEY (USR_FK_PERSON_ID)
	REFERENCES (PRS_PK_PERSON_ID)
/* --- COMMENTS ON TABLES --- */

COMMENT ON TABLE USR_USERS IS 'Contains information about a User Object';

---------------------------------------------------

CREATE SEQUENCE auto_increment_start
	start with 1
	increment by 1
	NOMAXVALUE;
	
CREATE TRIGGER tr_pk_users
	BEFORE INSERT ON USR_USERS
	FOR EACH ROW
	BEGIN
		SELECT auto_increment_start.nextval 
		INTO :new.USR_PK_USER_ID
		FROM dual;
	END;
	
---------------------------------------------------
  
  INSERT INTO usr_users (USR_EMAIL, USR_PASSWORD)
    VALUES ('altenarobin@gmail.com', 'admin');
  
 ---------------------------------------------------
  
  ALTER TABLE USR_USERS
    MODIFY
    (
    USR_EMAIL varchar2(50)
    )
    ;


