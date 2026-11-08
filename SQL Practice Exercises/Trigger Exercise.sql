create or replace trigger emp_test
after insert or update or delete on emp
begin
dbms_output.put_line(user || 'changes emp at ' || systimestamp);
end;
/
set serveroutput on;
update emp set salary = salary + 1000;

create or replace trigger dept_change_trigger
after update on emp
for each row when (new.did != old.did)
begin
dbms_output.put_line(:new.ename || ' has changed department');
end;
/
set serveroutput on;
update emp set did = 2 where eid = 1;

create or replace trigger emp_change_trigger
after update on emp
for each row when (new.did != old.did)
declare
old_dname dept.dname%type;
new_dname dept.dname%type;
begin
select dname into old_dname from dept where dept where dept.did = :old.did;
select dname into old_dname from dept where dept where dept.did = :new.did;
dbms_output.put_line(:new.ename || ' has changed from' || old_dname || 'into ' || :new_dname );
end;
/
set serveroutput on;
update emp set did = 2 where eid = 1;

