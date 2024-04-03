create database if not exists AgriconnectDB;

use AgriConnectDB;

create table if not exists  tbl_vendor(
VendorID int primary key auto_increment,
 FirstName varchar(50) not null,
MiddelName varchar(50),
LastName varchar(50),
UserName varchar(50) not null unique,
Password varchar(255) not null,
Email varchar(100),
Mobile varchar(15),
role Enum('OWNER','PARTNER'),
CreaedAt timestamp default current_timestamp,
UpdatedAt timestamp default current_timestamp on update current_timestamp
 );

create table if not exists tbl_user(
UserID int auto_increment primary key,
 FirstName varchar(50) not null,
MiddelName varchar(50),
LastName varchar(50) ,
Address varchar(255),
UserName varchar(50) not null unique,
Password varchar(255) not null,
Email varchar(100),
Mobile varchar(15),
CreaedAt timestamp default current_timestamp,
UpdatedAt timestamp default current_timestamp on update current_timestamp,
VendorID int, foreign key (VendorID) references tbl_vendor(VendorID)
 );
 
 create table if not exists tbl_category(
CategoryID int auto_increment primary key,
CategoryName varchar(50),
CategoryDescreption varchar(255),
CategoryImg varchar(250),
VendorID int,
foreign key (VendorID) references tbl_vendor(VendorID)
 );
 
 
 create table if not exists tbl_product(
ProductID int auto_increment primary key,
ProductName varchar(50),
ProductDescreption varchar(255),
ProductImg varchar(250),
CategoryID int,
ProductPrice decimal(10,2),
ProductUnit enum('BIGHA','MINUT'),
foreign key (CategoryID) references tbl_category(CategoryID)
 ); 

create table if not exists tbl_price_histry(
PriceHistryID int auto_increment primary key,
Price decimal(10,2),
ApplyAt date,
RevertAt date,
ProductID int,
foreign key (ProductID) references tbl_product(ProductID)
);


create table if not exists tbl_work(
WorkID int auto_increment primary key,
WorkQuantity int,
WorkFrequency int,
WorkLocation varchar(250),
UserID int,
ProductID int,
foreign key (UserID) references tbl_user(UserID),
foreign key (ProductID) references tbl_product(ProductID)
);


create table if not exists tbl_payment_details(
PaymentID int primary key auto_increment,
WorkID int,
PaymentStatus enum('SUCCESS','PENDING','DUE','FAILD'),
TotalAmount decimal (10,2),
ReceivedAmount decimal (10,2),
Discount decimal(10,2),
DueAmount decimal (10,2),
foreign key (WorkID) references tbl_work(WorkID)
);


create table if not exists tbl_tranction_histry(
TranctionHistryID int auto_increment primary key,
TranctionID varchar(64),
PayeeID varchar(64),
TranctionDate date,
PaymentMethod enum('UPI','CASH','CARD','NETBANKING','OTHER'),
TranctionAmount decimal(10,2),
PaymentID int,
foreign key(PaymentID) references tbl_payment_details(PaymentID)
);
