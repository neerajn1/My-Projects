drop table bid_detail cascade constraints; --drop table statements with cascade constraints as required from last to front
drop table supplier cascade constraints;
drop table bid cascade constraints;
drop table project cascade constraints;
drop table contractor cascade constraints;
drop table specialty cascade constraints;
drop table client cascade constraints;

create table client ( --client table
clid    number primary key,
cname   varchar2(100),
cemail  varchar2(100)
);

create table specialty ( --speciality table
spid    number primary key,
spname  varchar2(100)
);

create table contractor ( --contractor table
ctid      number primary key,
spid      number,
ctname    varchar2(100),
specialty varchar2(100),
ctemail   varchar2(100),
constraint fk_contractor_specialty foreign key (spid) references specialty(spid)--unique name given to cosntraints for easier idenfitication if troubleshooting occurs
);

create table project ( --project table
pid          number primary key,
clid         number,
paddress     varchar2(250),
pdescription varchar2(250),
pbudget      number(10,2), --10 digits to the left of the decimal with 2 num to the right
pstatus      number, 
pstartdate   date,
constraint fk_project_client foreign key (clid) references client(clid)
);

create table supplier ( --supplier table
sid   number primary key,
sname varchar2(100)
);

create table bid ( --bid table
bdid    number primary key,
pid     number,
ctid    number,
total   number(10,2),
bstatus number,
constraint fk_bid_project foreign key (pid) references project(pid),
constraint fk_bid_contractor foreign key (ctid) references contractor(ctid)
);

create table bid_detail ( --bid_detail table
iid    number primary key,
bdid   number,
sid    number, 
itype  number, 
iname  varchar2(100),
icost  number(10,2),
constraint fk_biddetail_bid foreign key (bdid) references bid(bdid),
constraint fk_biddetail_supplier foreign key (sid) references supplier(sid)
);

insert into client values (101, 'jane', 'jane@aol.com'); --client values
insert into client values (102, 'dan', 'dan@aol.com');
insert into client values (103, 'ella', 'ella@aol.com');

insert into specialty values (1, 'plumbing'); --speciality values
insert into specialty values (2, 'electrical');
insert into specialty values (3, 'carpentry');

insert into contractor values (501, 1, 'david', 'neighborhood plumber', 'contact@catonswater.com'); --contractor values
insert into contractor values (502, 2, 'trident', 'commercial electrician', 'info@tridentcurrent.com');
insert into contractor values (503, 3, 'donald', 'carpenter', 'sales@screwstrong.com');

insert into project values (2001, 101, '123 halem st', 'kitchen renovation', 15000.00, 1, to_date('2025-07-08', 'yyyy-mm-dd')); --project values
insert into project values (2002, 103, '456 hut ave', 'remodel one bathroom', 8000.00, 2, to_date('2025-10-15', 'yyyy-mm-dd')); --status meaning 1 is seeking bid, 2 is started, 3 is finished
insert into project values (2003, 103, '789 getting ln', 'deck construction', 5000.00, 3, to_date('2025-06-22', 'yyyy-mm-dd'));
insert into project values (2004, 101, '999 new st', 'garage addition', 20000.00, 1, to_date('2024-01-01', 'yyyy-mm-dd'));
insert into project values (2005, 101, '888 haw st', 'ceiling fan', 500.00, 1, to_date('2024-01-01', 'yyyy-mm-dd'));

insert into supplier values (901, 'home depot'); --supplier values
insert into supplier values (902, 'lowes');
insert into supplier values (903, 'ace hardware');

insert into bid values (3001, 2001, 501, 14500.00, 1); --bids values
insert into bid values (3002, 2002, 501, 7500.00, 2); --1 means submitted, 2 means accepted, and 3 means rejected
insert into bid values (3003, 2003, 503, 4800.00, 3);
insert into bid values (3004, 2002, 502, 7200.00, 1); 

insert into bid_detail values (4001, 3001, 901, 1, 'ceramic pipes', 500.00); --bid_detail 3001 for kitchen work
insert into bid_detail values (4002, 3001, null, 2, 'pipe installation workers', 2000.00);-- supplier id if itype is material, for labor can leave the sid null
insert into bid_detail values (4006, 3001, 902, 1, 'kitchen pull-out spray faucet', 250.00);

insert into bid_detail values (4003, 3002, 902, 1, 'quartz sink', 300.00); --bid_detail 3002 for shower work
insert into bid_detail values (4004, 3002, null, 2, 'sink installation', 400.00); 
insert into bid_detail values (4007, 3002, 901, 1, 'shower valve', 150.00);

insert into bid_detail values (4005, 3003, 903, 1, 'treated lumber', 1500.00); --bid_detail 3003 for deck work
insert into bid_detail values (4008, 3003, 903, 1, 'deck screws and fasteners', 200.00);
insert into bid_detail values (4009, 3003, null, 2, 'construction labor', 3100.00);

select ct.ctname, s.spname, p.pdescription -- Return the names of contractors and their specialties as well as project description
from client c, project p, bid b, contractor ct, specialty s -- if they have bid for projects submitted by ella
where c.cname = 'ella'
and c.clid = p.clid
and p.pid = b.pid
and b.ctid = ct.ctid
and ct.spid = s.spid;
  
select c.cname -- return names of clients who have submitted at least two projects
from client c, project p
where c.clid = p.clid
group by c.cname
having count(*) >= 2; --count all rows for at least two

select c2.ctname -- Find names of contractors who have submitted bids for the same project as david
from contractor c1, contractor c2, bid b1, bid b2
where c1.ctname = 'david'
and c1.ctid = b1.ctid --join david to bids, contractors,
and b1.pid = b2.pid
and b2.ctid = c2.ctid
and c1.ctid != c2.ctid;

update project -- update the project start date to February 6th, 2026 for all projects submitted by ella
set pstartdate = to_date('2026-02-06', 'yyyy-mm-dd')
where clid in (
select c.clid
from client c
where c.cname like '%ella%'
);

select b.bdid -- return the bid id with the lowest total cost for the project submitted by ella and with the description 'remodel one bathroom'
from bid b, project p, client c
where b.pid = p.pid
and p.clid = c.clid
and c.cname = 'ella'
and p.pdescription = 'remodel one bathroom'
and b.total = (
select min(b2.total) --selecting the minimum value from the bid price
from bid b2
where b2.pid = p.pid
);