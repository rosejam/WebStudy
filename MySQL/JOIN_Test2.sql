use scott;

-- <inline view> : from절에서 사용되는 서브쿼리
select fname, salary
from emp
order by salary desc
limit 5; -- 위에서 5개만 잘라냄 다른 db에 없음
-- inline view
select *
from (select empid, fname, salary
		from emp
		order by salary desc) ee -- "서브쿼리의 결과를 테이블 ee"로 삼아서 from문에 사용
limit 5;

-- <일반 서브쿼리>:select에서 서브쿼리 사용 - 자주 사용 안함
select empid, fname, deptid,
(select deptname from dept d where d.deptid = e.deptid) "deptname" -- 서브쿼리 내부에서 join
from emp e;

-- set autocommit = off;
-- update emp
-- set salary = (select salary from emp where deptid = 10); -- 4400