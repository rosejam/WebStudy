-- join(inner, outer, self)
-- empid, fname, deptid, deptname
select e.empid, e.fname, e.deptid, d.deptname
from emp e, dept d
where e.deptid = d.deptid;

-- ansi (inner) join
select e.empid, e.fname, e.deptid, d.deptname
from emp e inner join dept d
on e.deptid = d.deptid;

-- empid, fname, deptname, jobtitle, 연봉이 15000~20000 사이
select e.empid, e.fname, d.deptname, j.jobtitle
from emp e, dept d, job j
where e.salary between 15000 and 20000 -- join이전에 먼저 연봉 기준으로 추린다.
and e.deptid = d.deptid
and e.jobid = j.jobid;
--
select e.empid, e.fname, d.deptname, j.jobtitle
from emp e join dept d
on e.deptid = d.deptid
join job j
on e.jobid = j.jobid
where e.salary between 15000 and 20000;

-- fname이 'Adam'인 직원의 사번, 부서명, 업무명
select e.empid, d.deptname, j.jobtitle
from emp e, dept d, job j
where e.fname = 'Adam'
and e.deptid = d.deptid
and e.jobid = j.jobid;

-- deptid, deptname, city, countryid
select d.deptid, d.deptname, l.city, l.countryid
from dept d, loc l
where d.locid = l.locid;

-- 부서별 부서id, 부서명, 관리직원 이름
select d.deptid, d.deptname, concat(e.fname, ' ', e.lname) name
from emp e, dept d
where d.mgrid = e.empid;
-- outer join(중요)
select d.deptid, d.deptname, concat(e.fname, ' ', e.lname) name
from emp e right join dept d
on d.mgrid = e.empid;

-- outer join
select e.empid, e.fname, e.deptid, d.deptname
from emp e left outer join dept d -- data가 많은 쪽(null을 가진 쪽)을 가르킨다. -- emp의 킴벌리는 deptid가 null
on e.deptid = d.deptid;

-- self join
-- 자신의 매니저 이름(empid, fname, 관리자 fname)
select e1.empid, e1.fname, e2.fname
from emp e1, emp e2
where e1.mgrid = e2.empid;

-- subquery
-- 연봉이 제일 낮은 직원의 사번, 이름, 연봉
select empid, fname, salary
from emp
where salary = (select min(salary) from emp);
-- 116번 사원과 동일한 업무를 하는 직원의 사번, 이름
select empid, fname
from emp
where jobid = (select jobid from emp where empid = 116);
-- state 정보가 없는 부서의 부서id, 부서명, locid
select deptid, deptname, locid
from dept
where locid in (select locid from loc where state is null);
-- 회사 전체 평균 급여보다 많이 받는 직원 정보
select *
from emp
where salary > (select avg(salary) from emp);
-- Ontario에 있는 부서 id, 부서이름
select deptid, deptname
from dept
where locid in (select locid from loc where state = 'Ontario');
-- Southlake에 있는 부서 id, 부서이름
select deptid, deptname
from dept
where locid in (select locid from loc where city = 'Southlake');