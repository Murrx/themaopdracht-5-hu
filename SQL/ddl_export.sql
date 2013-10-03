--------------------------------------------------------
--  File created - Thursday-October-03-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ADR_PK_ADDRESS_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_ADR_PK_ADDRESS_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRS_PK_PERSON_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_PRS_PK_PERSON_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USR_PK_USER_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_USR_PK_USER_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ADR_ADDRESSES
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" 
   (	"ADR_PK_ADDRESS_ID" NUMBER(8,0), 
	"ADR_POSTAL_CODE" VARCHAR2(8 BYTE), 
	"ADR_HOUSE_NUMBER" VARCHAR2(16 BYTE), 
	"ADR_STREET" VARCHAR2(64 BYTE), 
	"ADR_CITY" VARCHAR2(64 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Table PRS_PERSONS
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" 
   (	"PRS_PK_PERSON_ID" NUMBER(8,0), 
	"PRS_FIRST_NAME" VARCHAR2(64 BYTE), 
	"PRS_LAST_NAME" VARCHAR2(64 BYTE), 
	"PRS_GENDER" NUMBER(1,0), 
	"PRS_BIRTHDATE" DATE, 
	"PRS_FK_ADDRESS_ID" NUMBER(8,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Table USR_USERS
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."USR_USERS" 
   (	"USR_PK_USER_ID" NUMBER(8,0), 
	"USR_EMAIL" VARCHAR2(64 BYTE), 
	"USR_PASSWORD" VARCHAR2(128 BYTE), 
	"USR_DISPLAY_NAME" VARCHAR2(64 BYTE), 
	"USR_FK_RIGHT_ID" NUMBER(8,0), 
	"USR_FK_PERSON_ID" NUMBER(8,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
REM INSERTING into THO5_2013_2A_TEAM5.ADR_ADDRESSES
SET DEFINE OFF;
Insert into THO5_2013_2A_TEAM5.ADR_ADDRESSES (ADR_PK_ADDRESS_ID,ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (22,'3766MC','74','Insingerstraat','Soest');
Insert into THO5_2013_2A_TEAM5.ADR_ADDRESSES (ADR_PK_ADDRESS_ID,ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (25,'1111TT','2','Test','Test');
Insert into THO5_2013_2A_TEAM5.ADR_ADDRESSES (ADR_PK_ADDRESS_ID,ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (24,'1111TT','1','Test','Test');
Insert into THO5_2013_2A_TEAM5.ADR_ADDRESSES (ADR_PK_ADDRESS_ID,ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (26,'3551EH','183','2e Daalsedijk','Utrecht');
Insert into THO5_2013_2A_TEAM5.ADR_ADDRESSES (ADR_PK_ADDRESS_ID,ADR_POSTAL_CODE,ADR_HOUSE_NUMBER,ADR_STREET,ADR_CITY) values (23,'1234 QA','1','AdminStreet','AdminCity');
REM INSERTING into THO5_2013_2A_TEAM5.PRS_PERSONS
SET DEFINE OFF;
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (15,'Robin','Altena',1,to_date('01-JAN-80','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (11,'robin','altena',0,to_date('01-JAN-80','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (12,'robin','altena',0,to_date('01-JAN-80','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (16,'Robin','Altena',1,to_date('25-SEP-86','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (19,'Test','Test',1,to_date('01-JAN-70','DD-MON-RR'),25);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (33,'TEST ACCOUNT','TEST ACCOUNT',0,to_date('19-AUG-80','DD-MON-RR'),24);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (18,'TEST','TEST',1,to_date('01-JAN-80','DD-MON-RR'),24);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (13,'Robin','Altena',1,to_date('01-JAN-80','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (14,'Robin','Altena',1,to_date('30-JAN-80','DD-MON-RR'),22);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (31,'Mark','van Lagen',1,to_date('01-JAN-80','DD-MON-RR'),26);
Insert into THO5_2013_2A_TEAM5.PRS_PERSONS (PRS_PK_PERSON_ID,PRS_FIRST_NAME,PRS_LAST_NAME,PRS_GENDER,PRS_BIRTHDATE,PRS_FK_ADDRESS_ID) values (17,'Admin','Istrator',1,to_date('12-JUN-88','DD-MON-RR'),23);
REM INSERTING into THO5_2013_2A_TEAM5.USR_USERS
SET DEFINE OFF;
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (12,'11altenarobin@gmail.nls','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','murrx',5,15);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (8,'altenarobin@gmail.com','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','robin',5,11);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (9,'altenarobin2@gmail.com','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','robin',5,12);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (13,'11a2ltenarobin@gmail.nls','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','murrx',5,16);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (31,'testaccount@auctify.com','0efeb7097c048beaf84526394e44dfe9125882bb938945deff496fae2bad73a19417e3a52956fe1164af990b5b49647f72badb48b57c3616a8687673d8801654','TEST ACCOUNT',5,33);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (10,'altenarobin@gmail.nl','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','murrx',5,13);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (11,'altenarobin@gmail.nls','60397ab83ee37cfb2d59c6f5d9641c4334d7ac3738d0c059fe3df9c83af39d539315c0605bb78a568fde5bfb3243ea670d76ad953db27af2a72f4be0986a3190','murrx',5,14);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (29,'markvlagen@gmail.com','811f7d16d1b93dcb52fbc511b8ae9a1ed280d3a4cf5c8207765602e4ea9f83d4b9a850efb960f17f213c8676b7f665f2eb1fd94da7b582f7badecc5f3bfc3b3e','Murk',5,31);
Insert into THO5_2013_2A_TEAM5.USR_USERS (USR_PK_USER_ID,USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID) values (15,'admin','c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec','admin',5,17);
--------------------------------------------------------
--  DDL for Index ADR_PK_ADDRESSES
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."ADR_PK_ADDRESSES" ON "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" ("ADR_PK_ADDRESS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Index PRS_PK_PERSONS
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."PRS_PK_PERSONS" ON "THO5_2013_2A_TEAM5"."PRS_PERSONS" ("PRS_PK_PERSON_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Index UN_USR_EMAIL
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."UN_USR_EMAIL" ON "THO5_2013_2A_TEAM5"."USR_USERS" ("USR_EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Index USR_PK_USERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."USR_PK_USERS" ON "THO5_2013_2A_TEAM5"."USR_USERS" ("USR_PK_USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  Constraints for Table USR_USERS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_PK_USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_EMAIL" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_DISPLAY_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_FK_RIGHT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_FK_PERSON_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" ADD CONSTRAINT "UN_USR_EMAIL" UNIQUE ("USR_EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" ADD CONSTRAINT "USR_PK_USERS" PRIMARY KEY ("USR_PK_USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRS_PERSONS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" ADD CONSTRAINT "PRS_PK_PERSONS" PRIMARY KEY ("PRS_PK_PERSON_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_PK_PERSON_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_FIRST_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_LAST_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_GENDER" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_BIRTHDATE" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" MODIFY ("PRS_FK_ADDRESS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ADR_ADDRESSES
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" ADD CONSTRAINT "ADR_PK_ADDRESSES" PRIMARY KEY ("ADR_PK_ADDRESS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" MODIFY ("ADR_STREET" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" MODIFY ("ADR_CITY" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PRS_PERSONS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."PRS_PERSONS" ADD CONSTRAINT "FK_PRS_ADDRESS_ID" FOREIGN KEY ("PRS_FK_ADDRESS_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" ("ADR_PK_ADDRESS_ID") DEFERRABLE INITIALLY DEFERRED ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USR_USERS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" ADD CONSTRAINT "FK_USR_PERSON_ID" FOREIGN KEY ("USR_FK_PERSON_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."PRS_PERSONS" ("PRS_PK_PERSON_ID") DEFERRABLE INITIALLY DEFERRED ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PK_ADDRESS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_ADDRESS" 
	BEFORE INSERT ON ADR_ADDRESSES
	FOR EACH ROW
	BEGIN
		SELECT seq_adr_pk_address_id.nextval 
		INTO :new.ADR_PK_ADDRESS_ID
		FROM dual;
	END;
/
ALTER TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_ADDRESS" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PK_PERSONS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_PERSONS" 
	BEFORE INSERT ON PRS_PERSONS
	FOR EACH ROW
	BEGIN
		SELECT seq_prs_pk_person_id.nextval 
		INTO :new.PRS_PK_PERSON_ID
		FROM dual;
	END;
/
ALTER TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_PERSONS" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PK_USERS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_USERS" 
	BEFORE INSERT ON USR_USERS
	FOR EACH ROW
	BEGIN
		SELECT seq_usr_pk_user_id.nextval 
		INTO :new.USR_PK_USER_ID
		FROM dual;
	END;
/
ALTER TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_USERS" ENABLE;
--------------------------------------------------------
--  DDL for Package PKG_USER_MODIFICATION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "THO5_2013_2A_TEAM5"."PKG_USER_MODIFICATION" AS
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

/
--------------------------------------------------------
--  DDL for Package Body PKG_USER_MODIFICATION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "THO5_2013_2A_TEAM5"."PKG_USER_MODIFICATION" AS
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

/
