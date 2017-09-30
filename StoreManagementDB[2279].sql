drop table if exists Product cascade;
drop table if exists Orders cascade;
drop table if exists Checkout cascade;
drop table if exists Customer cascade;

create table if not exists Product (
	product_ID int unique,
	product_name varchar(30),
	quantity int, 
	price real(9, 2),
	expiration_date datetime,

	primary key (product_ID)
);

create table if not exists Orders (
	order_ID int unique,
	customer_ID int,
	total_price real(9, 2),
	tax real(9,2),
	date_of_purchase datetime,
	
	primary key (order_ID)
);

create table if not exists Checkout (
	order_ID int,
	product_ID int,
	quantity real(9, 3)

);

create table if not exists Customer (
	customer_ID int unique,
	customer_name varchar(30),

	primary key (customer_ID)
);