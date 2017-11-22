ALTER TABLE product_sizes_mapping add COLUMN unit VARCHAR not null;
alter table product_company_mapping drop COLUMN  unit;