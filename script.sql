

create database stores;


create table store (
    id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	address varchar(200) NOT NULL,
);

create table order (
    id INT PRIMARY KEY AUTO_INCREMENT,	
	address varchar(200) NOT NULL,
	confirmation_date DATE NOT NULL
	status INT NOT NULL,
	store_id INT NOT NULL,
	CONSTRAINT fk_StoreOrder FOREIGN KEY (store_id) REFERENCES store(id)	
);

create table product (
    id INT PRIMARY KEY AUTO_INCREMENT,	
	unit_price DECIMAL(6,2) NOT NULL,
	description varchar(200) NOT NULL,
	store_id INT NOT NULL,
	CONSTRAINT fk_StoreProduct FOREIGN KEY (store_id) REFERENCES store(id)
);

create table orderItem (
    id INT PRIMARY KEY AUTO_INCREMENT,	
	unit_price DECIMAL(6,2) NOT NULL,
	quantity INT NOT NULL,
	product_id INT NOT NULL,
    order_id INT NOT NULL,
	CONSTRAINT fk_OrderOrderItem FOREIGN KEY order_id) REFERENCES order(id)
    CONSTRAINT fk_ProductOrderItem FOREIGN KEY (product_id) REFERENCES product(id)	
);

create table payment  (
    id INT PRIMARY KEY AUTO_INCREMENT,	
	payment_date DATE NOT NULL,
	credit_card_number varchar(200) NOT NULL,
	status INT NOT NULL,
	order_id INT NOT NULL,
	CONSTRAINT fk_OrderPayment FOREIGN KEY (order_id) REFERENCES orders(id)	
);

