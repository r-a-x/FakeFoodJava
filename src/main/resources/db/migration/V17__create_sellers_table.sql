create table sellers(
  id bigserial not null primary key,
  name text not null,
  ecom VARCHAR (128) not NULL,
  url text not NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
