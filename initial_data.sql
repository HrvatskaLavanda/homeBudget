CREATE TABLE public.category (
	category_id serial4 NOT NULL,
	category_name varchar(120) NOT NULL,
	CONSTRAINT category_pkey PRIMARY KEY (category_id)
);

CREATE TABLE public.bought_products (
	bought_product_id serial4 NOT NULL,
	product_price numeric(10, 2) NOT NULL,
	quantity serial4 NOT NULL,
	product_id serial4 NOT NULL,
	expense_id serial4 NOT NULL,
	market_id serial4 NOT NULL,
	CONSTRAINT bought_products_pkey PRIMARY KEY (bought_product_id),
	CONSTRAINT bought_products_expense_id_fkey FOREIGN KEY (expense_id) REFERENCES public.expense(expense_id),
	CONSTRAINT bought_products_market_id_fkey FOREIGN KEY (market_id) REFERENCES public.markets(market_id),
	CONSTRAINT bought_products_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(product_id)
);

CREATE TABLE public.expense (
	expense_id serial4 NOT NULL,
	person_id serial4 NOT NULL,
	total_price numeric(10, 2) NOT NULL,
	expense_date_time date NOT NULL,
	CONSTRAINT expense_pkey PRIMARY KEY (expense_id),
	CONSTRAINT expense_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id)
);

CREATE TABLE public.markets (
	market_id serial4 NOT NULL,
	market_name varchar(120) NOT NULL,
	CONSTRAINT markets_pkey PRIMARY KEY (market_id)
);

CREATE TABLE public.person (
	person_id serial4 NOT NULL,
	person_name varchar(120) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (person_id)
);

CREATE TABLE public.product (
	product_id serial4 NOT NULL,
	product_name varchar(120) NOT NULL,
	category_id serial4 NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id),
	CONSTRAINT product_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.category(category_id)
);



