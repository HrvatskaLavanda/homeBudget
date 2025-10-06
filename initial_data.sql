create table category (
category_id serial not null,
category_name varchar(120),
primary key (category_id)
);
create table product (
product_id serial not null,
product_name varchar(120),
category_id integer not null,
primary key(product_id),
foreign key(category_id) references category(category_id)
);
create table markets (
market_id serial not null,
market_name varchar(120),
primary key(market_id)
);
create table person(
person_id serial not null,
person_name varchar(120),
primary key(person_id)
);
create table expense(
expense_id serial not null,
person_id integer not null,
total_price decimal(10, 2) not null,
expense_date_time timestamp not null,
primary key(expense_id),
foreign key(person_id) references person(person_id)
);
create table bought_products (
bought_product_id serial not null,
product_price decimal(10, 2) not null,
quantity integer not null,
product_id integer not null,
expense_id integer not null,
market_id integer not null,
primary key (bought_product_id),
foreign key (product_id) references product(product_id),
foreign key (expense_id) references expense(expense_id),
foreign key (market_id) references markets(market_id)
);
INSERT INTO category(category_name) VALUES ('Food');
INSERT INTO product(product_name, category_id) VALUES('Banana', 1);
INSERT INTO markets(market_name) VALUES('Plodine');
INSERT INTO person(person_name) VALUES('Ivana');
INSERT INTO expense(person_id, total_price, expense_date_time) VALUES (1, 10, '2025-01-08 04:05:06');
INSERT INTO bought_products(product_price, quantity, product_id, expense_id, market_id) VALUES (2, 1, 1, 1, 1);
