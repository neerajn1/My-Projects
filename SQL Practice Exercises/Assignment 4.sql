drop table bid_detail cascade constraints;
drop table supplier cascade constraints;
drop table Bid cascade constraints;
drop table project cascade constraints;
drop table contractor cascade constraints;
drop table specialty cascade constraints;
drop table client cascade constraints;

create table client
(clid int,
cname varchar(50),
cemail varchar(50),
primary key(clid));
insert into client values
(1, 'Ella','ella@gmail.com');
insert into client values
(2, 'Eric','eric@gmail.com');
insert into client values
(3, 'Olivia','olivia@gmail.com');
insert into client values
(4, 'Aditya','aditya@gmail.com');

create table specialty
(spid int,
spname varchar(50),
primary key(spid));
insert into specialty values
(1, 'painting');
insert into specialty values
(2, 'flooring');
insert into specialty values
(3, 'general');

create table contractor
(ctid int,
spid int,
ctname varchar(50),
ctemail varchar(50),
primary key(ctid),
foreign key(spid) references specialty);
insert into contractor values
(1, 1, 'David','david@gmail.com');
insert into contractor values
(2, 2, 'Ravi','ravi@gmail.com');
insert into contractor values
(3, 3, 'Kelly','kelly@gmail.com');
insert into contractor values
(4, 1, 'Nancy','nancy@gmail.com');
insert into contractor values
(5, 2, 'John','john@gmail.com');
insert into contractor values
(6, 3, 'Park','park@gmail.com');

create table project
(pid int,
clid int, -- client id
paddress varchar(100), -- project address
pdescription varchar(100), --- project description
pbudget number , --- budget
pstatus int, -- 1 seeking bid, 2, started, 3, finished
pstartdate date,
primary key (pid),
foreign key (clid) references client
);
insert into project
values(1,1, '1234 Hilltop Rd, Cantonsville, MD',
'repaint a 2000 sq ft house internal', 3000, 1, null);
insert into project
values(2,1, '1234 Hilltop Rd, Cantonsville, MD',
'remodel one bathroom', 6000, 1, null);
insert into project
values(3,2, '10010 Baltimore National Pike, Ellicott City, MD',
'install hardwood floor', 10000, 1, null);
insert into project
values(4,2, '10010 Baltimore National Pike, Ellicott City, MD',
'roof replacement', 10000, 1, null);
insert into project
values(5,3, '1224 Main Street, Ellicott City, MD',
'remodel kitchen', 10000, 1, null);

create table bid
( bdid int,
pid int, -- project id
ctid int, -- contract id
total number, --- total cost
bstatus int, --- 1: submitted, 2: accepted, 3: rejected
primary key (bdid),
foreign key(pid) references project,
foreign key(ctid) references contractor
);
-- 2 bids for project 1 (painting), David and Nancy
insert into bid values
(1,1,1,3500,1);
insert into bid values
(2,1,4,3100,1);
-- 2 bids for project 2 (remodel), Kelly and Park
insert into bid values
(3,2,3,6500,1);
insert into bid values
(4,2,6,6000,1);

create table supplier
(sid int,
sname varchar(50),
primary key(sid));
insert into supplier values(1,'Home Depot');
insert into supplier values(2,'Lowes');
insert into supplier values(3,'Ace Hardware');

create table bid_detail
(iid int, --- item id
bdid int, --- bid id
sid int, --- supplier id
itype int, -- 1 material, 2 labor
iname varchar(50),
icost number,
primary key(iid),
foreign key(bdid) references bid,
foreign key(sid) references supplier);
-- item details for bid 1 and 2, materials: paint and labor
insert into bid_detail values
(1, 1, 1, 1, 'Paint', 1000);
insert into bid_detail values
(2, 1, null, 2, 'labor', 2500);
insert into bid_detail values
(3, 2, 2, 1, 'Paint', 1000);
insert into bid_detail values
(4, 2, null, 2, 'labor', 2100);
-- bid 3
insert into bid_detail values
(5, 3, 2, 1, 'new sink', 500);
insert into bid_detail values
(6, 3, 3, 1, 'new tub', 2500);
insert into bid_detail values
(7, 3, null, 2, 'install', 3500);
-- bid 4
insert into bid_detail values
(8, 4, 1, 1, 'new sink', 400);
insert into bid_detail values
(9, 4, 1, 1, 'new tub', 2400);
insert into bid_detail values
(10, 4, null, 2, 'install', 3200);
commit;

--problem 1  create a trigger on bid table when a new bid is inserte
set serveroutput on;
create or replace trigger bid_insert_trigger
after insert on bid --trigger start after insertion into bid is seen
for each row --row level trigger
declare
c_name client.cname%type; --to make it more generic, %type is used to make the system not need to differentiate among varchars
ct_name contractor.ctname%type;
begin
select cname into c_name 
from client 
where clid = (select clid from project where pid = :new.pid); --finds matching client id with new project id via subquery & only new pid due to insert

select ctname into ct_name
from contractor where ctid = :new.ctid; -- getting into contractor table and finding matching names via ID matches & only new ctid due to insert

dbms_output.put_line(c_name || ': a new bid from ' || ct_name || ' has been received, with the total cost of ' || :new.total);
end; --concatenation of provided prompt as given in info provided at question
/

insert into bid values (9,3,4,15000,1); --  test the trigger by inserting a new bid for project id 3 from contractor id 4

-- Problem 2 task 1 For bids submitted for Project 2, return the bid ID, item name, and the running total of the item cost.
-- The running total should be partitioned by bid ID and ordered by item ID.
Select bd.bdid, bd.iname, sum(bd.icost) over (partition by bd.bdid order by bd.iid)
From bid_detail bd
Where bd.bdid IN (Select bdid From bid Where pid = 2); --using in clause to filter out row for only number 2

-- problem 2 task 2 For each project, return the project ID, bid ID, total cost for that project, and the rank based on total cost.
-- The bid with the lowest cost for a project is ranked 1, the second lowest is ranked 2, and so on. Each project is ranked independently.
Select pid, bdid, total, rank() over (partition by pid order by total) --displays in ascending order from low to high
From bid;