set serveroutput on;
declare
var_a number := 2468; --set the initial variable values where a is 2468 and b is 3702
var_b number := 3702;
begin
while var_a != var_b loop --making loop start with initially making variable a and variable b not equal to each other
                  --where while this occurs, other conditions can be applied to see if this conditions becomes void at the end
                  
while var_a > var_b loop --now, nested loop starts where this allows us to have one loop inside another loop to fulfill both conditions given to us
var_a := var_a - var_b; --if var_a > var_b, var_a = var_a - var_b
end loop;

while var_b > var_a loop --  if var_a < var_b, replace var_b with var_ b- var_a.
var_b := var_b - var_a;
end loop;
        
end loop; --this concludes the overall loops being performed once the a not equal to b becomes false
    
dbms_output.put_line('The greatest common divisor of 2468 and 3702 is: ' || var_b);
end;
/

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


set serveroutput on;
declare
var_projlist number; -- check whether there is a project with pid = 1.
var_pid      number := 1;
begin
select count(*) --checking every value *
into var_projlist
from project
where pid = var_pid ;  
if var_projlist = 0 then
dbms_output.put_line('no such project');
return; 
end if; --to end if statements, end if is necessary

for my_bid in (
select b.bdid, c.ctname, b.total  -- prints out all bids received for this project, including the bid id,
                                  -- the name of the contractor who sends the bid, and the total cost of the bid.
from bid b
join contractor c on b.ctid = c.ctid 
where b.pid = var_pid  ) loop
dbms_output.put_line('bid id: ' || my_bid.bdid || ', contractor: ' || my_bid.ctname || ', total cost: ' || my_bid.total);
        
                     
for my_item in ( 
select bt.iname, bt.itype, s.sname, bt.icost   --  print out each item in the bid, including the item
                                               -- name, item type, supplier name, and item cost including items without a supplier too
from bid_detail bt                             -- using left outer join to obtain the labor row to at least get an null value
left outer join supplier s on bt.sid = s.sid 
where bt.bdid = my_bid.bdid ) loop 
dbms_output.put_line('  item: ' || my_item.iname || ', type: ' || my_item.itype || ', supplier: ' || my_item.sname || ', cost: ' || my_item.icost);
end loop; --ends step 3 loop for printing out each specific items
end loop; --ends step 2 loop of printing out all bids
end;
/
