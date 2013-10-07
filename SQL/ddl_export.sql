--------------------------------------------------------
--  File created - Monday-October-07-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ADR_PK_ADDRESS_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_ADR_PK_ADDRESS_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_AUC_PK_AUCTION_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_AUC_PK_AUCTION_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRS_PK_PERSON_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_PRS_PK_PERSON_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USR_PK_USER_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_USR_PK_USER_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
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
--  DDL for Table AUC_AUCTIONS
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" 
   (	"AUC_PK_AUCTION_ID" NUMBER(8,0), 
	"AUC_START_TIME" DATE, 
	"AUC_END_TIME" DATE, 
	"AUC_FK_USER_ID" NUMBER(8,0), 
	"AUC_FK_STATUS_ID" NUMBER(1,0), 
	"AUC_FK_PRODUCT_ID" NUMBER(8,0), 
	"AUC_FK_CATEGORY" VARCHAR2(32 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Table PRD_PRODUCTS
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."PRD_PRODUCTS" 
   (	"PRD_PK_PRODUCT_ID" NUMBER(8,0), 
	"PRD_NAME" VARCHAR2(128 BYTE), 
	"PRD_DESCRIPTION" VARCHAR2(512 BYTE)
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
--  DDL for Table STA_STATUSES
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."STA_STATUSES" 
   (	"STA_PK_STATUS_ID" NUMBER(1,0), 
	"STA_DESCRIPTION" VARCHAR2(32 BYTE), 
	"STA_FK_RIGHT_ID" NUMBER(3,0)
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
--------------------------------------------------------
--  DDL for Index PRD_PK_PRODUCT_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."PRD_PK_PRODUCT_ID" ON "THO5_2013_2A_TEAM5"."PRD_PRODUCTS" ("PRD_PK_PRODUCT_ID") 
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
--  DDL for Index STA_PK_STATUS_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."STA_PK_STATUS_ID" ON "THO5_2013_2A_TEAM5"."STA_STATUSES" ("STA_PK_STATUS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Index AUC_PK_AUCTION_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."AUC_PK_AUCTION_ID" ON "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ("AUC_PK_AUCTION_ID") 
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
--  DDL for Index ADR_PK_ADDRESSES
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."ADR_PK_ADDRESSES" ON "THO5_2013_2A_TEAM5"."ADR_ADDRESSES" ("ADR_PK_ADDRESS_ID") 
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
--  Constraints for Table AUC_AUCTIONS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ADD CONSTRAINT "AUC_PK_AUCTION_ID" PRIMARY KEY ("AUC_PK_AUCTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" MODIFY ("AUC_START_TIME" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" MODIFY ("AUC_END_TIME" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" MODIFY ("AUC_FK_USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" MODIFY ("AUC_FK_STATUS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" MODIFY ("AUC_FK_PRODUCT_ID" NOT NULL ENABLE);
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
--  Constraints for Table PRD_PRODUCTS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."PRD_PRODUCTS" ADD CONSTRAINT "PRD_PK_PRODUCT_ID" PRIMARY KEY ("PRD_PK_PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."PRD_PRODUCTS" MODIFY ("PRD_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STA_STATUSES
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."STA_STATUSES" ADD CONSTRAINT "STA_PK_STATUS_ID" PRIMARY KEY ("STA_PK_STATUS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
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
--  DDL for Trigger TR_PK_AUCTIONS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_AUCTIONS" 
	BEFORE INSERT ON AUC_AUCTIONS
	FOR EACH ROW
	BEGIN
		SELECT seq_auc_pk_auction_id.nextval 
		INTO :new.AUC_PK_AUCTION_ID
		FROM dual;
    
    SELECT seq_auc_pk_auction_id.currval
		INTO :new.auc_fk_product_id
		FROM dual;
	END;
/
ALTER TRIGGER "THO5_2013_2A_TEAM5"."TR_PK_AUCTIONS" ENABLE;
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
--  DDL for Package PKG_AUCTION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "THO5_2013_2A_TEAM5"."PKG_AUCTION" AS
    FUNCTION f_create_auction
    (
      p_auc_end_time date,
      p_auc_fk_category varchar2,
      p_auc_fk_user_id number,
      
      p_prd_name varchar2,
      p_prd_description varchar2
    )
    return number;
END pkg_auction;

/
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
--  DDL for Package Body PKG_AUCTION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "THO5_2013_2A_TEAM5"."PKG_AUCTION" AS

FUNCTION f_create_auction
    (
      p_auc_end_time date,
      p_auc_fk_category varchar2,
      p_auc_fk_user_id number,
      
      p_prd_name varchar2,
      p_prd_description varchar2
    )
    return number
    AS
     v_new_auction_id number := -1;
    BEGIN
    
    
    
      INSERT INTO auc_auctions (auc_start_time, auc_end_time, auc_fk_user_id, auc_fk_status_id, auc_fk_category) VALUES (sysdate, p_auc_end_time, p_auc_fk_user_id, 1, p_auc_fk_category);
      INSERT INTO prd_products (prd_pk_product_id, prd_name, prd_description) VALUES (seq_auc_pk_auction_id.currval, p_prd_name, p_prd_description);
      
      v_new_auction_id := seq_auc_pk_auction_id.currval;
   
    return v_new_auction_id;
  END f_create_auction;
END pkg_auction;

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
  AS
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
  AS
  
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
