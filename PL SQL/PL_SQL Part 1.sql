SET SERVEROUTPUT ON;
declare
sentence varchar(50) := 'This is my first PL/SQL program';
begin
dbms_output.put_line('This is my first PL/SQL program');
End;
/

SET SERVEROUTPUT ON;
declare
current_time timestamp;
next_time TIMESTAMP;
begin
current_time := systimestamp;
next_time := current_time + interval '7' day;
dbms_output.put_line(next_time);
end;
/

-- Create parent table first
create table dept (
    did int primary key,
    dname varchar(30)
);

-- Insert a valid parent row
insert into dept
values (1,'IT');

insert into dept
values (2, 'HR');

insert into dept
values (3, 'IT');

-- Now create the child table
create table emp (
    eid int,
    ename varchar(30),
    did int, -- department id
    hiredate date,
    salary number,
    primary key (eid),
    foreign key (did) references dept(did)
);

-- Insert into emp (now valid because dept.did = 1 exists)
insert into emp
values (1, 'jeff', 1, TO_DATE('2005-01-01', 'YYYY-MM-DD'), 70000);


insert into emp
values(2,'susan',2, TO_DATE('2005-06-01', 'YYYY-MM-DD'),50000);

insert into emp
values(3,'bob',1, TO_DATE('2000-01-01', 'YYYY-MM-DD'),90000);

insert into emp
values(4,'steve',1, TO_DATE('2006-01-01', 'YYYY-MM-DD'),60000);

insert into emp
values(5,'steve',3, TO_DATE('2007-01-01', 'YYYY-MM-DD'),80000);

create table proj (
pid int,
pname varchar(30),
startdate date,
enddate date,
primary key (pid));

insert into proj
values (1,'umbc student db',date '2017-1-1',null);
insert into proj
values (2, 'umbc library',date '2017-2-1', date '2017-7-1');

create table emp_proj (
eid int,
pid int,
primary key (eid,pid),
foreign key (pid) references proj,
foreign key (eid) references emp);

insert into emp_proj
values (1, 2);

insert into emp_proj
values (3, 2);

insert into emp_proj
values (1, 1);

insert into emp_proj
values (4, 1);

insert into emp_proj
values (2, 1);


Declare
dname dept.dname%type;
Begin
dname := 'service';
dbms_output.put_line(dname);
End;
/

Declare
newemp emp%rowtype;
Begin
newemp.ename := 'john';
dbms_output.put_line(newemp.ename);
End;
/

Declare
x date;
Begin
x := sysdate;
if x >= date '2019-9-1' and x < date '2019-10-1' then
dbms_output.put_line( x || ' is in September 2019');
elsif x < date '2019-9-1' then
dbms_output.put_line( x || ' is earlier than September 2019');
else
dbms_output.put_line( x || ' is in September 2019');
End if;
End;
/

SET SERVEROUTPUT ON;
Declare
    num INTEGER;
    i   INTEGER;
Begin
    i := 1;
    num := 1;
    Loop
    num := num * i;
    i := i + 1;          -- increment i
    exit when i > 4;     -- exit condition
    end loop;
    dbms_output.put_line('total is ' || num);
End;
/

SET SERVEROUTPUT ON;
Declare
num integer := 1;
begin
For i In 1..4 Loop
num := num * i;
End Loop;
dbms_output.put_line(num);
End;
/

SET SERVEROUTPUT ON;
Declare
acct dept%rowtype;
Begin
acct.did := 4;
acct.dname := 'accounting';
insert into dept values acct;
End;
/

select * from dept;

SET SERVEROUTPUT ON;
Declare
e_salary number;
e_id int;
Begin
select eid, salary into e_salary, e_id
from emp
Where eid = 1;
Dbms_output.put_line('e_salary is: ' || e_salary || ' e_id is: '
|| e_id);
end;
/

SET SERVEROUTPUT ON;
Declare
e_salary number;
e_id int;
Begin
select eid, salary into e_id, e_salary
from emp
Where eid = 5;
Dbms_output.put_line('e_id is: ' || e_id || ' e_salary is: ' || e_salary);
Exception
when no_data_found then
Dbms_output.put_line('no rows found');
when too_many_rows then
dbms_output.put_line('too many rows');
End;
/

SET SERVEROUTPUT ON;
DECLARE
    CURSOR c1 IS
        SELECT e.ename, d.dname
        FROM emp e
        JOIN dept d ON e.did = d.did
        WHERE d.dname = 'IT';
    e_name  emp.ename%TYPE;
    e_dept  dept.dname%TYPE;
BEGIN
    OPEN c1;
    LOOP
        FETCH c1 INTO e_name, e_dept;
        EXIT WHEN c1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('name = ' || e_name || ', dept = ' || e_dept);
    END LOOP;
    CLOSE c1;
END;
/

SET SERVEROUTPUT ON;
DECLARE
CURSOR c1 IS
SELECT pname
FROM proj
WHERE pid IN (
SELECT pid
FROM emp_proj
WHERE eid = (SELECT eid FROM emp WHERE ename = 'jeff')
);
v_count INT;
BEGIN 
SELECT COUNT(*) INTO v_count
FROM emp
WHERE ename = 'jeff';
IF v_count = 0 THEN
DBMS_OUTPUT.PUT_LINE('No such employee');
ELSE
-- Print Jeff's projects
FOR r IN c1 LOOP
DBMS_OUTPUT.PUT_LINE(r.projname);
END LOOP;
END IF;
END;
/





