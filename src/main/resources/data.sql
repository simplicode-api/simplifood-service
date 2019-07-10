DROP TABLE IF EXISTS customer;

create table customer (
customer_id int not null,
gender char(1) not null,
first_name varchar(50) not null,
last_name varchar(50) not null,
mobile_no BIGINT not null,
email varchar(50) not null,
prof_password varchar(15) not null,
customer_status char(1) not null,
create_time Timestamp not null,
last_updated_time Timestamp not null,
last_updated_userid varchar(10) not null,
primary key(customer_id)

);
