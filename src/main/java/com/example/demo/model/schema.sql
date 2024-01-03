create table if not exists category(
	categoryId int primary key Auto_increment,
	name varchar(255)

)
create table if not exists product (
  productid INT  PRIMARY KEY AUTO_INCREMENT,
   productName varchar(255),
   productImg varchar(255),
   productCost int,
   productDiscount int,
   category int,
   foreign key category references category(categoryId)
);


create table if not exists customer_Cart(
	customerId int,
	productId int,
	primary key (customerId,productId),
	foreign key customerId references customer(customerId),
	foreign key productId references product(productId)

)