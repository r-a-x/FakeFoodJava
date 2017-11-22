create table product_company_mapping (
  id bigserial not null primary key,
  product_id bigserial  not NULL ,
  company_id bigserial not NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
