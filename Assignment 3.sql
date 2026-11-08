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
create or replace function return_lowest_bid (v_pid in int) return int --project ID is input and returning only one int
IS
v_project_count int; --number of count project ID spawns in Project table
v_bid_count int; --count of bids in project
v_low_bdid int; --  bid id of the lowest bid
v_low_total number; -- lowest total cost
begin

select count(*) into v_project_count from project where pid = v_pid; -- checks whether the project ID is valid (an existing project has that ID
if v_project_count = 0 then                                          --  If that's not the case, print a message 'Invalid PID' and return -1
dbms_output.put_line('Invalid PID');
return -1;
end if;

select count(*) into v_bid_count from bid where pid = v_pid; -- checks whether there is any bid received. If there is no bid,
if v_bid_count = 0 then                                      -- print 'No bid received' and return -2
dbms_output.put_line('No bid received');
return -2;
end if;
                                                                       
for bid_pri in (select bdid, total from bid where pid = v_pid) loop                   -- implicit cursor loop to get all bids for project
dbms_output.put_line('Bid ID: ' || bid_pri.bdid || ' Total: $' || bid_pri.total);   -- If there are some bids, print out the bid and return the
if v_low_total is null or bid_pri.total < v_low_total then                            --  bid id of the lowest bid (with lowest cost).
v_low_total := bid_pri.total;
v_low_bdid := bid_pri.bdid;
end if;
end loop;
return v_low_bdid;
end;
/

declare
v_give_val int; -- calling functions to test conditions
begin
dbms_output.put_line(' Case a: Invalid project id');
v_give_val := return_lowest_bid(101);
dbms_output.put_line('Returned Value: ' || v_give_val);
    
dbms_output.put_line(' Case b: No bid exists');
v_give_val := return_lowest_bid(3);
dbms_output.put_line('Returned Value: ' || v_give_val);
    
dbms_output.put_line(' Case c: A bid exists');
v_give_val := return_lowest_bid(1);
dbms_output.put_line('Returned Value: ' || v_give_val);
end;
/
                     -- procedure to accept the lowest bid with taking input of Project ID
set serveroutput on; 
create or replace procedure accept_lowest_bid(v_pid in int)
is 
cursor c1 is select bdid from bid where pid = v_pid; --cursor for looping through bids
v_count int; --keep count of projects
v_bid_total number; -- total cost of bid
v_lowest_bdid int; --  id of the lowest bid's ID
begin

select count(*) into v_count from project where pid = v_pid; -- checks whether the project ID is valid (an existing project has that ID). If
if v_count = 0 then                                          -- that's not the case, print a message 'Invalid PID' and stop.
dbms_output.put_line('Invalid PID');
else

for pres_bid in c1 loop -- open cursor via loop to look at each bid
select sum(icost) into v_bid_total from bid_detail where bdid = pres_bid.bdid;  -- For each bid received for that project, it then computes
                                                                                -- total cost, which is the sum of cost of each bid_detail item 
if v_bid_total is null then                                                     -- for that bid.
v_bid_total := 0;
end if; -- if no info in bid, set to null and end if
            
update bid set total = v_bid_total where bdid = pres_bid.bdid; -- updating bid's total cost column
end loop; 
v_lowest_bdid := return_lowest_bid(v_pid); -- It calls the function created in problem 1 to get the id of the lowest bid.
        
if v_lowest_bdid > 0 then -- If the returned bid is greater than 0, it updates the status of the returned bid to 2
for pres_bid in c1 loop   -- (accepted), and print a message 'bid x accepted' where x is the bid.
                          -- call in loop from c1 cursor to set in place conditions of acception and rejection
if pres_bid.bdid = v_lowest_bdid then --lowest bid acception equation
update bid set bstatus = 2 where bdid = pres_bid.bdid; --update to 2 and print bid x accepted
dbms_output.put_line('bid ' || pres_bid.bdid || ' accepted');
else
update bid set bstatus = 3 where bdid = pres_bid.bdid; -- Set the other bids for the same project's status to 3 (rejected). Print a message 'bid
dbms_output.put_line('bid ' || pres_bid.bdid || ' rejected'); -- y rejected' where y is the other bids for the project.
end if; --end of accept/reject loop
end loop; -- end pres_bid loop at beginning when cursor opened
commit; --save changes just to make sure everything's right
end if; -- end v_lowest_bdid > 0 loop
end if; -- ending overall if v_count = 0 loop
end; --final conclusion of procedure
/

begin  -- calling functions to test conditions
    dbms_output.put_line(' Case 1: Invalid project ID');
    accept_lowest_bid(101);
    
    dbms_output.put_line(' Case 2: No bid received');
    accept_lowest_bid(3);
    
    dbms_output.put_line(' Case 3: Regular case where there are some bids');
    accept_lowest_bid(1);
end;
/