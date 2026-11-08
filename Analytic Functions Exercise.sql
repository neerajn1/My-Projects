drop table orders cascade constraints;
drop table product cascade constraints;
drop table customer cascade constraints;

create table customer
(cid int,
cname varchar(50),
primary key(cid));
insert into customer values(1,'Susan');
insert into customer values(2,'Jeff');

create table product
(pid int,
pname varchar(50),
price number,
primary key(pid));
insert into product values(1,'Laptop',800);
insert into product values(2,'Smart phone',600);

create table orders
(oid int,
cid int,
pid int,
quantity number,
odate date,
total number,
primary key(oid),
foreign key(cid) references customer,
foreign key(pid) references product);
insert into orders values(1,1,1,2,date '2024-10-1',1600);
insert into orders values(2,2,2,1,date '2024-10-2',600);
insert into orders values(3,1,2,1,date '2024-10-3',600);
insert into orders values(4,2,1,1,date '2024-10-4',800);

Select pid, oid, odate, sum(quantity) over (partition by pid order by odate)
From orders;

Select pid, oid, odate, sum(quantity) over (partition by pid order by odate range between interval '1' day preceding and interval '1' day following)
From orders;

Select pid, oid, quantity, rank() over (partition by pid order by quantity
desc)
From orders;