-- 뷰 생성
create or replace view v_emp2
as 	(select e.empid, e.fname, d.deptname, e.salary
	from emp e, dept d
	where d.deptid in (20,40,50)
	and e.deptid = d.deptid);
select *
from v_emp2;