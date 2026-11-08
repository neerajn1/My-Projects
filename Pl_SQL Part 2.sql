create or replace procedure PrintMessage(m varchar) --procedurename (parameter mode datatype)
as
begin
dbms_output.put_line(m); --program statement
end;
/
set serveroutput on;
exec PrintMessage('this is my first PL/SQL procedure');

Create or replace
PROCEDURE get_salary (e_id in int) IS
Cursor c1 is select salary from emp where eid = e_id;
E_sal number;
BEGIN
Open c1;
Loop
fetch c1 into e_sal;
exit when c1%notfound;
dbms_output.put_line(e_sal);
End loop;
END;
/
set serveroutput on;
Exec get_salary(1);
Exec get_salary(3);

Create or replace
PROCEDURE get_salary (e_id in int, sal out real) IS
Cursor c1 is select salary from emp where eid = e_id;
BEGIN
Open c1;
Loop
fetch c1 into sal;
exit when c1%notfound;
dbms_output.put_line(sal);
End loop;
END;
/
Declare
sal real;
Begin
get_salary(1,sal);
get_salary(3,sal);
End;
/

Create or replace function get_salary_byname (e_name in varchar)
return number
IS
e_salary number;
BEGIN
select salary into e_salary from emp where ename = e_name;
return e_salary;
exception
when no_data_found then
dbms_output.put_line('no such employee');
return -1;
End;
/

declare
e_salary number;
Begin
e_salary:= get_salary_byname('jeff');
if e_salary > 0 then dbms_output.put_line(e_salary);
else dbms_output.put_line('no data found');
end if;
End;
/

set serveroutput on;
Exec get_salary_byname('jeff');


Create sequence did_seq start with 5;

