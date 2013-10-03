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
         USR_PASSWORD			VARCHAR2(128) NOT NULL,
		 USR_DISPLAY_NAME		VARCHAR2(64) NOT NULL,
         USR_FK_RIGHT_ID		NUMBER(8) NOT NULL,			-- FK of User Rights
		 USR_FK_PERSON_ID		NUMBER(8) NOT NULL,			-- FK of Persons
		 
		CONSTRAINT USR_PK_USERS 
			PRIMARY KEY (USR_PK_USER_ID)					-- PK of USER
);
/	
		
CREATE TABLE PRS_PERSONS (
		PRS_PK_PERSON_ID NUMBER(8) NOT NULL,
		PRS_FIRST_NAME VARCHAR2(64) NOT NULL,
		PRS_LAST_NAME VARCHAR2(64) NOT NULL,
		PRS_GENDER NUMBER(1) NOT NULL,
		PRS_BIRTHDATE DATE NOT NULL,
		PRS_FK_ADDRESS_ID NUMBER(8) NOT NULL,				-- FK of Addresses
		
		CONSTRAINT PRS_PK_PERSONS 
			PRIMARY KEY (PRS_PK_PERSON_ID)					-- PK of Persons
);
	/	
CREATE TABLE ADR_ADDRESSES (
		ADR_PK_ADDRESS_ID NUMBER(8),
		ADR_POSTAL_CODE VARCHAR(8),
		ADR_HOUSE_NUMBER VARCHAR(16),
		ADR_STREET VARCHAR2(64) NOT NULL,
		ADR_CITY VARCHAR2(64) NOT NULL,
		
		CONSTRAINT ADR_PK_ADDRESSES 
			PRIMARY KEY (ADR_PK_ADDRESS_ID))	;					-- PK of Addresses
			
);
		
/* --- FOREIGN KEYS CONSTRAINTS --- */
		 
/* CONSTRAINT FK_USR_RIGHT_ID
	FOREIGN KEY (USR_FK_RIGHT_ID)
	REFERENCES USR_RIGHTS (USR_PK_RIGHT_ID), */
	
ALTER TABLE USR_USERS 
add constraint FK_USR_PERSON_ID
foreign key (USR_FK_PERSON_ID) 
references PRS_PERSONS(PRS_PK_PERSON_ID) 
deferrable initially deferred;

ALTER TABLE PRS_PERSONS
add constraint FK_PRS_ADDRESS_ID
foreign key (PRS_FK_ADDRESS_ID) 
references ADR_ADDRESSES(ADR_PK_ADDRESS_ID) 
deferrable initially deferred;

/* --- COMMENTS ON TABLES --- */

COMMENT ON TABLE USR_USERS IS 'Contains information about a User Object';

---------------------------------------------------

/* --- SEQUENCES --- */
CREATE SEQUENCE seq_usr_pk_user_id
	start with 1
	increment by 1
	NOMAXVALUE;
	
CREATE SEQUENCE seq_prs_pk_person_id
	start with 1
	increment by 1
	NOMAXVALUE;
	
CREATE SEQUENCE seq_adr_pk_address_id
	start with 1
	increment by 1
	NOMAXVALUE;
	
/* --- TRIGGERS --- */

CREATE TRIGGER tr_pk_users
	BEFORE INSERT ON USR_USERS
	FOR EACH ROW
	BEGIN
		SELECT seq_usr_.nextval 
		INTO :new.USR_PK_USER_ID
		FROM dual;
	END;
	
CREATE TRIGGER tr_pk_persons
	BEFORE INSERT ON PRS_PERSONS
	FOR EACH ROW
	BEGIN
		SELECT seq_prs_pk_person_id.nextval 
		INTO :new.PRS_PK_PERSON_ID
		FROM dual;
	END;
	

CREATE TRIGGER tr_pk_address
	BEFORE INSERT ON ADR_ADDRESSES
	FOR EACH ROW
	BEGIN
		SELECT seq_adr_pk_address_id.nextval 
		INTO :new.ADR_PK_ADDRESS_ID
		FROM dual;
	END;
	
----------------Packages------------------------	
create or replace 
PACKAGE pkg_user_modification AS
    PROCEDURE pr_delete_user
    (
      p_usr_email varchar2,
      p_usr_password varchar2,
      p_usr_display varchar2,
      
      p_prs_first_name varchar2,
      p_prs_last_name varchar2,
      p_prs_gender number,
      p_prs_birthdate date,
      
      p_adr_postal_code varchar2,
      p_adr_house_number varchar2,
      p_adr_street varchar2,
      p_adr_city varchar2
    );
    
    FUNCTION f_register_user
    (
      p_usr_email varchar2,
      p_usr_password varchar2,
      p_usr_display varchar2,
      
      p_prs_first_name varchar2,
      p_prs_last_name varchar2,
      p_prs_gender number,
      p_prs_birthdate date,
      
      p_adr_postal_code varchar2,
      p_adr_house_number varchar2,
      p_adr_street varchar2,
      p_adr_city varchar2
    )
    return number;
END pkg_user_modification;

create or replace 
PACKAGE BODY pkg_user_modification AS
--------------------------------------------------------------------------------
  PROCEDURE pr_delete_user
  (
    p_usr_email varchar2,
    p_usr_password varchar2,
    p_usr_display varchar2,
      
    p_prs_first_name varchar2,
    p_prs_last_name varchar2,
    p_prs_gender number,
    p_prs_birthdate date,
      
    p_adr_postal_code varchar2,
    p_adr_house_number varchar2,
    p_adr_street varchar2,
    p_adr_city varchar2
  )
  IS
  BEGIN
    delete
      from usr_users 
      where usr_users.usr_email = p_usr_email;
    
    delete 
      from prs_persons
      where prs_first_name = p_prs_first_name
      and prs_last_name = p_prs_last_name;
  END pr_delete_user;
--------------------------------------------------------------------------------
 FUNCTION f_register_user
  (
    p_usr_email varchar2,
    p_usr_password varchar2,
    p_usr_display varchar2,
      
    p_prs_first_name varchar2,
    p_prs_last_name varchar2,
    p_prs_gender number,
    p_prs_birthdate date,
      
    p_adr_postal_code varchar2,
    p_adr_house_number varchar2,
    p_adr_street varchar2,
    p_adr_city varchar2
  )
  return number
  IS
  
  v_address_id number := null;
  v_address_excists boolean := true;
  v_new_user_id number;
  
  BEGIN
    begin
        select adr_pk_address_id 
        into v_address_id 
        from adr_addresses 
        where adr_postal_code = p_adr_postal_code 
        and adr_house_number = p_adr_house_number;
      exception
        when no_data_found then
          v_address_excists := false;
    end;
    
    IF v_address_excists = false THEN
      Insert into ADR_ADDRESSES (ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (p_adr_postal_code,p_adr_house_number,p_adr_street,p_adr_city);
      Insert into PRS_PERSONS (PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (p_prs_first_name,p_prs_last_name,p_prs_gender,p_prs_birthdate,seq_adr_pk_address_id.currval);
    ELSE
      Insert into PRS_PERSONS (PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (p_prs_first_name,p_prs_last_name,p_prs_gender,p_prs_birthdate,v_address_id);
    END IF;
    
    Insert into USR_USERS (USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (p_usr_email,p_usr_password,p_usr_display,5,seq_prs_pk_person_id.currval);
    v_new_user_id := seq_usr_pk_user_id.currval;
    return v_new_user_id;
  END f_register_user;
--------------------------------------------------------------------------------
END pkg_user_modification;
	
---------------Default users----------------------
  
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_RIGHT_ID) values (29,'testaccount@auctify.com','0efeb7097c048beaf84526394e44dfe9125882bb938945deff496fae2bad73a19417e3a52956fe1164af990b5b49647f72badb48b57c3616a8687673d8801654','DO_NOT_DELETE',5);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_RIGHT_ID) values (28,'admin','c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec','Admin',256);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_RIGHT_ID) values (30,'test@test.nl','c806480919151f94a038ebb3fb548b03006ceee9e7d504149b01b583a54343b60cc2d6acf46774a2cfbdf2425dbb78970c26ad0e2dd7820ef1a41cd3afa5f5ac','test',5);
  
 ---------------------------------------------------
  
  ALTER TABLE USR_USERS
    MODIFY
    (
    USR_PASSWORD varchar2(128)
    )
    ;

    ---------------------
    
  BEGIN

pkg_user_modification.pr_register_user
   (
      'smartlapus@gmail.com',
      '0efeb7097c048beaf84526394e44dfe9125882bb938945deff496fae2bad73a19417e3a52956fe1164af990b5b49647f72badb48b57c3616a8687673d8801654',
      'smartlapus',
      
      'Martin',
     'Bakker',
     1,
      '12-JUN-88',
      
      '3584 LG',
     '118',
      'Leuvenplein',
      'Utrecht'
    );
    
END;

