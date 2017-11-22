create table companyId (
  id bigserial not null primary key,
  name text not null,
  email VARCHAR (128) not NULL,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
