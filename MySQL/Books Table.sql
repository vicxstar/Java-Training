create table Books(
bookId int primary key,
bookName varchar(50),
authorName varchar(50),
noOfCopies int
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

show tables;

select * from DvdLibrary;

select * from Student;

select * from Employees;