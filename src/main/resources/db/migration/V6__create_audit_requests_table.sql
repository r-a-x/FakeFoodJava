create table audit_requests (
  id bigserial not null primary key,
  android_id VARCHAR not NULL,
  status VARCHAR (128) not null,
  name VARCHAR (128) not NULL ,
  company_id bigserial not NULL,
  size VARCHAR (128) not NULL ,
  flavour VARCHAR(128) not NULL ,
  purchase_place_type VARCHAR (64) NOT NULL ,
  place_of_purchase VARCHAR (64) NOT NULL ,
  lot_number VARCHAR (64) NOT NULL ,
  expiration_date TIMESTAMP  NOT NULL ,
  barcode VARCHAR (128) NOT NULL ,
  front_canister_image text not NULL ,
  back_canister_image text not NULL,
  logo_image text not NULL,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
