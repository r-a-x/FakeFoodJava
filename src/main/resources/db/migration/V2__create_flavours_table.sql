create table flavours (
  id bigserial not null primary key,
  flavour text not null,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
