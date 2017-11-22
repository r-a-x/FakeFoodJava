create table products (
  id bigserial not null primary key,
  flavours VARCHAR (128) not null,
  type VARCHAR (128) not NULL ,
  description text not NULL ,
  food_type VARCHAR(32) NOT NULL ,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
