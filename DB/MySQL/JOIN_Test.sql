use scott;

-- <INNER Join>(2개 이상의 table을 연결해서 여러개의 data를 추출하는 작업) -> 컬럼이 연결되어 "긴 레코드 한줄"이 만들어진다!!!!
-- empid, fname, deptid, deptname
select e.empid, e.fname, e.deptid, d.deptname -- 테이블이름.칼럼이름 으로 표시
from emp e, dept d -- 테이블에 별칭을 붙임
where e.deptid = d.deptid -- 조건을 주어 두 테이블을 이어 붙임!!!(보통 fk와 참조하는 pk 연결)
order by 1; 
-- empid, fname, jobtitle, jobid
select e.empid, e.fname, j.jobtitle, j.jobid
from emp e, job j
where e.jobid = j.jobid
order by 1;
-- empid, fname, jobtitle, deptname
select e.empid, e.fname, j.jobtitle, d.deptname
from emp e, job j, dept d
where e.jobid = j.jobid 
and e.deptid = d.deptid -- 연결고리는 select하지 않아도 됨
order by 1;

-- ansi 표준(join~using)
select e.empid, e.fname, d.deptname
from emp e join dept d -- ,대신 join
using(deptid) -- where 대신 using
order by 1;
-- 테이블 간 컬럼명이 다르거나 테이블 별칭 사용할 경우 (join~on)
select e.empid, e.fname, e.deptid, d.deptname
from emp e join dept d 
on(e.deptid = d.deptid) -- where대신 on사용
order by 1; 

-- <OUTER join>
select count(*) from emp; -- emp테이블 레코드 수
-- inner join에서는 emp 테이블에서 deptid 가 null인 킴벌리가 누락
-- select e.empid, e.fname, d.deptname
-- from emp e , dept d
-- where e.deptid = d.deptid(+) -- e에는 null이 있는데 d에는 null이 없음(데이터모자람), 데이터가 모자란 쪽에 (+)하면 모든 컬럼이 null인 가상의 레코드가 하나 추가됨 --> OUTER join
-- order by 1;
-- ansi 표준
select e.empid, e.fname, d.deptname
from emp e left outer join dept d -- 데이터가 많은쪽(여기서는 left!)를 써주어야한다. 데이터가 모자란 쪽에 모든 컬럼이 null인 가상의 레코드가 하나 추가됨
on e.deptid = d.deptid
order by 1;
-- 3테이블 outer join
select e.empid, e.fname, d.deptname, l.city
from emp e 	left outer join dept d on e.deptid = d.deptid -- emp e쪽에 있는 데이터가 다 나오게 하겠다 -- dept d에 null 레코드를 추가 했으므로 
			left outer join loc l on d.locid = l.locid; -- dept쪽에 있는 null을 포함해서 나오게 해야함(여기도 outer join)
            
-- <SELF join>
-- empid, fname, mgr이름 같은 테이블에 2번 접근해서 join 
create or replace view mgrnames
as
select e1.empid, e1.fname, e2.fname "mgrname"
from emp e1, emp e2 -- 자기 자신을 2개 join!!
where e1.mgrid = e2.empid; -- 컬럼명은 다르지만 동일한 의미
select * from mgrnames;
-- 사장의 상사가 나오게 self + outer join
select e1.empid, e1.fname, e2.fname "mgrname"
from emp e1 left outer join emp e2 
on e1.mgrid = e2.empid
order by 1;
-- 부서별 관리(매니저) 직원의 이름 - mgrid가 null인 부서 포함(outer join)
select d.deptid, d.deptname, e.fname "mgrname"
from emp e right outer join dept d -- 매니저가 없는 부서도 있으므로 dept가 더 큰쪽(null이 포함된 쪽)
on d.mgrid = e.empid;
-- 부서별 관리(매니저) 직원의 이름 - mgrid가 null인 부서 포함X(inner join)
select d.deptid, d.deptname, e.fname "mgrname"
from emp e, dept d
where d.mgrid = e.empid;
-- 부서별 도시 이름 -- deptid, deptname, city
select d.deptid, d.deptname, l.city
from dept d, loc l
where d.locid = l.locid;

-- Main쿼리 -- sub쿼리가 먼저 실행되고 main쿼리가 실행됨
-- 연봉을 제일 많이 받는 사람의 이름
select fname
from emp
where salary = (select max(salary) from emp); -- <Sub쿼리> : 뷰로 생성가능
-- sub쿼리
-- 평균 연봉보다 많이 받는 사람들의 모든 정보를 담은 뷰
create or replace view aversal
as 
select *
from emp
where salary > (select avg(salary) from emp);
-- 미국 부서 뷰
create or replace view usdept
as 
select deptid, deptname
from dept
where locid in (select locid
				from loc
				where countryid = 'US'); -- 여러개이므로 =이 아니고 in을 사용
select * from aversal;

-- <단일 행> 서브 쿼리(하나의 컬럼, 하나의 행을 리턴. 비교 연산자가 사용된다.)
-- 사번이118인 사원의 업무(PU_CLERK 서브쿼리 결과)와 동일한 업무를 가진 모든 직원 정보
select *
from emp
where jobid = 	(select jobid
				from emp
				where empid = 118);
-- 128보다 많이받는 사원들
select *
from emp
where salary > (select salary
				from emp
				where empid = 128);
-- 평균 연봉보다 많이 받는 사원 정보
select *
from emp
where salary > (select round(avg(salary))
				from emp);
-- Seattle에 있는 부서 id, 부서명
select deptid, deptname
from dept
where locid = (select locid from loc where city='Seattle');
-- state값이 null인 부서의 모든 정보
select *
from dept
where locid in (select locid
from loc
where state is null); -- subquery의 값이 여러개 이므로 in으로 확인!!!!
-- 최소 급여를 받는 사람의 모든 정보
select *
from emp
where salary = (select min(salary) from emp);
-- 30번 부서 사람들의 평균 연봉 보다 많이 받는 직원 정보
select *
from emp
where salary > (select avg(salary)
				from emp
				where deptid = 30);
-- 최고 급여를 받는 직원의 fname, jobtitle, deptname
select e.fname, j.jobtitle, d.deptname
from emp e, job j, dept d
where e.salary = (select max(salary) from emp)
and e.jobid=j.jobid and e.deptid=d.deptid; -- join을 뒤에 해야지 필요없는 레코드전부를 조인하고 그 다음에 찾을 필요가 없다.

-- <복수 행> 서브 쿼리(여러개의 행을 리턴. IN 연산자가 사용된다.) = 잘 모를땐 그냥 in
-- 50번 부서 사원들과 다른 일을 하는 사원 정보 IN
select *
from emp 
where jobid not in (select jobid from emp where deptid = 50);
-- ANY : ()안의 아무 한 값보다만 크면 된다. (최소값보다 크거나 최대값보다 작은)
select *
from emp
where salary > any ((select salary from emp where deptid =30));
-- ALL : ()안의 모든 값보다만 크면 된다. (최대값보다 크거나 최소값보다 작은)
select *
from emp
where salary > all ((select salary from emp where deptid =30));

-- <복수 컬럼> 여러개의 컬럼과 행을 리턴
-- 부서별 최소 샐러리 정보 IN
select *
from emp
where (deptid, salary) in 	(select deptid, min(salary) -- 여러 컬럼
							from emp
							group by deptid);
-- EXISTS 서브쿼리의 결과가 존재하는 지의 여부로 실행 결정
select deptid, deptname
from dept
where exists (select * from emp where deptid = 10000); -- 존재 안하면 main쿼리 실행 안함