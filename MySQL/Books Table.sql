create table Books(
bookId int primary key,
bookName varchar(50),
authorName varchar(50),
noOfCopies int
);

create table Customer(
accountId int primary key,
custName varchar(50),
password varchar(50),
custAddress varchar(50),
custNumber int,
bankBalance double
);

create table User(
userName varchar(50) primary key,
password varchar(50)
);

create table DvdLibrary(
dvdId int primary key,
title varchar(50),
releaseDate date,
mpaaRating int,
directorsName varchar(50),
studio varchar(50),
userReview varchar(50)
);

insert into Books
values(100, "To Kill A Mockingbird", "DepartmentsHarper Lee", 15),
(101, "North Child", "Edith Pattou", 10),
(102, "The Seven Husbands Of Evelyn Hugo", "Taylor Jenkins Reid", 5),
(103, "The Sisters Grimm", "Michael Buckley", 4),
(104, "Skin Of The Sea", "Natasha Bowen", 7),
(105, "The Midnight Library", "Matt Haig", 9);

insert into DvdLibrary
values(2, "Christopher Nolan", "R", "2000-10-14","Summit Entertainment", "Memento", "It was very memorable"),
(3, "Mark Waters", "PG-13", "2004-06-18", "Paramount Pictures", "Mean Girls", "So fetch!"),
(4, "John McTiernan", "R", "1989-02-03", "Silver Pictures", "Die Hard", "It was to die for!");

insert into User
values("Vic", "fiveteen"),
("Jen", "hello"),
("Jimmy", "byebye");

insert into ShopCustomers
values(1, 100, "Vic", "fiveteen", 3),
(2, 450, "Jen", "hello", 5),
(3, 600, "Dorcas", "byebye", 8),
(4, 200, "Joel", "password", 6);

insert into ShopProducts
values(10, 10, "JML Speaker", 13),
(20, 40, "Iphone Charger",  15),
(30, 60, "Apple Airpods",  18),
(40, 20, "Portable Speaker", 16);

show tables;

insert into Share
values(101, "Barclays", 158.86),
(102, "Tesla", 85.47),
(103, "BMW", 95.93),
(104, "Barclays", 312.59);

select * from Share;

select * from Detail;

select * from ShopCustomers;
select * from ShopProducts;

select * from Customer;

select * from User;

select * from Employee;

insert into Employee
values(3, 3021, "Finance", 1000, "dorcaseng@email.com", "Dorcas", "English", "079123456765", 20000, "2010-11-10", 300, 3011, "Manager"),
(4, 4021, "HR", 80, "julietri@email.com", "Juliet", "Truimph", "079123456765", 2000, "2022-10-23", 400, 4011, "Admin"),
(5, 5021, "Disciplinary", 500, "jamesk@email.com", "James", "Kempt", "079123456765", 1500, "2019-03-03", 500, 5011, "Manager");