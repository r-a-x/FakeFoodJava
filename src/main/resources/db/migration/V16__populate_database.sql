insert into flavours (flavour,created_on,modified_on) values ('Double Rich Chocolate',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Extreme Milk Chocolate',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Chocolate Peanut Butter',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Mocha Cappuccino',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Cinnamon Graham Cracker',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Strawberry',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Cookie n Cream',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Vanilla',now(),now());
insert into flavours (flavour,created_on,modified_on) values('Choclate Peanut Butter',now(),now());


insert into products (flavours,type,description,food_type,created_on,modified_on) values ('','Whey Protein','A fast digestive protein with double choclate flavour','VEG' ,now(),now());

insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Double Rich Chocolate',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Extreme Milk Chocolate',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Chocolate Peanut Butter',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Mocha Cappuccino',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Cinnamon Graham Cracker',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Strawberry',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Cookie n Cream',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Vanilla',1,now(),now());
insert into product_flavours_mapping (flavour,product_id,created_on,modified_on) values ('Choclate Peanut Butter',1,now(),now());


insert into company (name,email,created_on,modified_on ) values ( 'Optimum Nutrition (ON)','Consumer@optimumnutrition.com',now(),now());

insert into company (name,email,created_on,modified_on) values ( 'MuscleTech ','counterfeits@iovate.com',now(),now());

insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('1',1,now(),now(),'lbs');
insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('1.81',1,now(),now(),'lbs');
insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('2',1,now(),now(),'lbs');
insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('3.31',1,now(),now(),'lbs');
insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('5',1,now(),now(),'lbs');
insert into product_sizes_mapping (size,product_id,created_on,modified_on,unit) values ('8',1,now(),now(),'lbs');

insert into file_request (name,path,created_on,modified_on) values('muscletech','/root/FakeFoodFiles/muscletech.jpeg',now(),now());
insert into file_request (name,path,created_on,modified_on) values('optimum','/root/FakeFoodFiles/optimum.jpeg',now(),now());

insert into product_company_mapping (product_id,company_id,created_on,modified_on,image,name) values ( 1,1,now(),now(),'optimum','Optimum Nutrition (ON) 100% Whey Gold Standard ');
insert into product_company_mapping (product_id,company_id,created_on,modified_on,image,name) values ( 1,2,now(),now(),'muscletech','Muscletech Nitrotech Whey Gold');
