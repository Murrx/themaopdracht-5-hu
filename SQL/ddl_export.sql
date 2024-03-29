--------------------------------------------------------
--  File created - Wednesday-November-06-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ADR_PK_ADDRESS_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_ADR_PK_ADDRESS_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_AUC_PK_AUCTION_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_AUC_PK_AUCTION_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 421 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BID_PK_BID_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_BID_PK_BID_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 521 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_GEN_IDENTITY
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_GEN_IDENTITY"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRS_PK_PERSON_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_PRS_PK_PERSON_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 341 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USR_PK_USER_ID
--------------------------------------------------------

   CREATE SEQUENCE  "THO5_2013_2A_TEAM5"."SEQ_USR_PK_USER_ID"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 341 CACHE 20 NOORDER  NOCYCLE ;
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
	"AUC_START_TIME" TIMESTAMP (1), 
	"AUC_END_TIME" TIMESTAMP (1), 
	"AUC_FK_USER_ID" NUMBER(8,0), 
	"AUC_FK_STATUS_ID" NUMBER(1,0), 
	"AUC_FK_PRODUCT_ID" NUMBER(8,0), 
	"AUC_FK_CATEGORY" VARCHAR2(32 BYTE), 
	"AUC_START_BID" NUMBER(8,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Table BID_BIDS
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" 
   (	"BID_PK_BID_ID" NUMBER(8,0), 
	"BID_FK_AUCTION_ID" NUMBER(8,0), 
	"BID_FK_USER_ID" NUMBER(8,0), 
	"BID_TIMESTAMP" TIMESTAMP (6), 
	"BID_AMOUNT" NUMBER(8,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Table CAT_CATEGORIES
--------------------------------------------------------

  CREATE TABLE "THO5_2013_2A_TEAM5"."CAT_CATEGORIES" 
   (	"CAT_CATEGORY" VARCHAR2(32 BYTE)
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
	"USR_FK_PERSON_ID" NUMBER(8,0), 
	"USR_BIDCOINS" NUMBER(*,0) DEFAULT 0
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
--  DDL for Index BID_PK_BID_ID_DESC
--------------------------------------------------------

  CREATE INDEX "THO5_2013_2A_TEAM5"."BID_PK_BID_ID_DESC" ON "THO5_2013_2A_TEAM5"."BID_BIDS" ("BID_PK_BID_ID" DESC) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314" ;
--------------------------------------------------------
--  DDL for Index BID_PK_BID_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "THO5_2013_2A_TEAM5"."BID_PK_BID_ID" ON "THO5_2013_2A_TEAM5"."BID_BIDS" ("BID_PK_BID_ID") 
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
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."USR_USERS" MODIFY ("USR_BIDCOINS" NOT NULL ENABLE);
 
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
--  Constraints for Table BID_BIDS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" ADD CONSTRAINT "BID_PK_BID_ID" PRIMARY KEY ("BID_PK_BID_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" MODIFY ("BID_TIMESTAMP" NOT NULL ENABLE);
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" MODIFY ("BID_AMOUNT" NOT NULL ENABLE);
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
--  Constraints for Table CAT_CATEGORIES
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."CAT_CATEGORIES" ADD PRIMARY KEY ("CAT_CATEGORY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STA_STATUSES
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."STA_STATUSES" ADD CONSTRAINT "STA_PK_STATUS_ID" PRIMARY KEY ("STA_PK_STATUS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS1314"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table AUC_AUCTIONS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ADD CONSTRAINT "FK_AUC_CATEGORY" FOREIGN KEY ("AUC_FK_CATEGORY")
	  REFERENCES "THO5_2013_2A_TEAM5"."CAT_CATEGORIES" ("CAT_CATEGORY") ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ADD CONSTRAINT "FK_AUC_PRODUCT_ID" FOREIGN KEY ("AUC_FK_PRODUCT_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."PRD_PRODUCTS" ("PRD_PK_PRODUCT_ID") DEFERRABLE INITIALLY DEFERRED ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ADD CONSTRAINT "FK_AUC_STATUS_ID" FOREIGN KEY ("AUC_FK_STATUS_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."STA_STATUSES" ("STA_PK_STATUS_ID") DEFERRABLE INITIALLY DEFERRED ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ADD CONSTRAINT "FK_AUC_USER_ID" FOREIGN KEY ("AUC_FK_USER_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."USR_USERS" ("USR_PK_USER_ID") DEFERRABLE INITIALLY DEFERRED ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BID_BIDS
--------------------------------------------------------

  ALTER TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" ADD CONSTRAINT "FK_AUCTION_ID" FOREIGN KEY ("BID_FK_AUCTION_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."AUC_AUCTIONS" ("AUC_PK_AUCTION_ID") ENABLE;
 
  ALTER TABLE "THO5_2013_2A_TEAM5"."BID_BIDS" ADD CONSTRAINT "FK_USER_ID" FOREIGN KEY ("BID_FK_USER_ID")
	  REFERENCES "THO5_2013_2A_TEAM5"."USR_USERS" ("USR_PK_USER_ID") ENABLE;
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
--  DDL for Package PKG_AUCTION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "THO5_2013_2A_TEAM5"."PKG_AUCTION" AS

    PROCEDURE pr_delete_auction
    (
      p_auc_id number
    );
    
    PROCEDURE p_create_auction
    (
      p_auc_pk_auction_id number,
      p_auc_start_time date,
      p_auc_end_time date,
      p_auc_fk_category varchar2,
      p_auc_fk_user_id number,
      p_auc_start_bid number,
      
      p_prd_name varchar2,
      p_prd_description varchar2
    );
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
    
     PROCEDURE pr_update_user
    (
      p_usr_id number,
      p_usr_email varchar2,
      p_usr_password varchar2,
      p_usr_display varchar2,
      p_usr_bidcoins number,

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
      p_usr_bidcoins number,

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

PROCEDURE pr_delete_auction
    (
      p_auc_id number
    )
  AS
  BEGIN
    delete
      from bid_bids
      where p_auc_id = bid_fk_auction_id;
    delete
      from auc_auctions 
      where p_auc_id = auc_pk_auction_id;  
    delete 
      from prd_products
      where p_auc_id = prd_pk_product_id;
  END pr_delete_auction;
  
PROCEDURE p_create_auction
    (
      p_auc_pk_auction_id number,
      p_auc_start_time date,
      p_auc_end_time date,
      p_auc_fk_category varchar2,
      p_auc_fk_user_id number,
      p_auc_start_bid number,
      
      p_prd_name varchar2,
      p_prd_description varchar2
    )
    AS
    BEGIN

      INSERT INTO auc_auctions (auc_pk_auction_id, auc_start_time, auc_end_time, auc_fk_user_id, auc_fk_status_id, auc_fk_category,auc_start_bid, auc_fk_product_id) VALUES (p_auc_pk_auction_id, p_auc_start_time, p_auc_end_time, p_auc_fk_user_id, 5, p_auc_fk_category,p_auc_start_bid, p_auc_pk_auction_id);
      INSERT INTO prd_products (prd_pk_product_id, prd_name, prd_description) VALUES (p_auc_pk_auction_id, p_prd_name, p_prd_description);
  END p_create_auction;
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
  PROCEDURE pr_update_user
  (
      p_usr_id number,
      p_usr_email varchar2,
      p_usr_password varchar2,
      p_usr_display varchar2,
      p_usr_bidcoins number,

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
  v_person_id number := null;
  v_address_id number := null;
  BEGIN
    select usr_users.usr_fk_person_id
    into v_person_id
    from usr_users
    where usr_users.usr_pk_user_id = p_usr_id;
    
    select prs_persons.prs_fk_address_id
    into v_address_id
    from prs_persons
    where prs_persons.prs_pk_person_id = v_person_id;
  
    update usr_users
      set usr_users.usr_email = p_usr_email,
          usr_users.usr_password = p_usr_password,
          usr_users.usr_display_name = p_usr_display,
          usr_users.usr_bidcoins = p_usr_bidcoins
      where usr_users.usr_pk_user_id = p_usr_id;
      
    update prs_persons
      set prs_persons.prs_first_name = p_prs_first_name,
          prs_persons.prs_last_name = p_prs_last_name,
          prs_persons.prs_gender = p_prs_gender,
          prs_persons.prs_birthdate = p_prs_birthdate
      where prs_persons.prs_pk_person_id = v_person_id;
      
    update adr_addresses
      set adr_addresses.adr_postal_code = p_adr_postal_code,
          adr_addresses.adr_house_number = p_adr_house_number,
          adr_addresses.adr_street = p_adr_street,
          adr_addresses.adr_city = p_adr_city
      where adr_addresses.adr_pk_address_id = v_address_id;
      
    
  END pr_update_user;
--------------------------------------------------------------------------------
 FUNCTION f_register_user
  (
    p_usr_email varchar2,
    p_usr_password varchar2,
    p_usr_display varchar2,
    p_usr_bidcoins number,
      
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
    
    Insert into USR_USERS (USR_EMAIL,USR_PASSWORD,USR_DISPLAY_NAME,USR_FK_RIGHT_ID,USR_FK_PERSON_ID,USR_BIDCOINS) values (p_usr_email,p_usr_password,p_usr_display,5,seq_prs_pk_person_id.currval, p_usr_bidcoins);
    v_new_user_id := seq_usr_pk_user_id.currval;
    return v_new_user_id;
  END f_register_user;
--------------------------------------------------------------------------------
END pkg_user_modification;

/
--------------------------------------------------------
--  DDL for Procedure REMOVEALLAUCTIONS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "THO5_2013_2A_TEAM5"."REMOVEALLAUCTIONS" AS
BEGIN
  execute immediate 'TRUNCATE TABLE AUC_AUCTIONS';
  execute immediate 'TRUNCATE TABLE PRD_PRODUCTS';
END REMOVEALLAUCTIONS;

/
