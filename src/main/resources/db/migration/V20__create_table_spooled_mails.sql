create table spooled_mails (
  id bigserial not null primary key,
  audit_id bigserial  not NULL ,
  is_sent boolean not NULL ,
  is_failed boolean not NULL ,
  failure_case text,
  created_on timestamp not null default current_timestamp,
  modified_on timestamp not null default current_timestamp
);
