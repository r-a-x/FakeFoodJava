create table product_sizes_mapping (
  id bigserial not null primary key,
  size VARCHAR (128) not null,
  product_id bigserial  not NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
