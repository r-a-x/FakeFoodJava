create table product_flavours_mapping (
  id bigserial not null primary key,
  flavour VARCHAR (128) not null,
  product_id bigserial  not NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
