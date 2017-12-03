create table file_request (
  id bigserial not null primary key,
  name VARCHAR (128) not null,
  path VARCHAR (128) not NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
