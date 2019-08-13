use scott;

create or replace view v_emp1 -- --
as -- -- 이 두줄만 붙이면 view로 만들 수 있다.
select empid, fname, salary, deptid
from emp
where deptid <= 50; -- 내용바꾸고 다시 실행시키면 다시 생성된다. replace

-- 연봉을 제일 많이 받는 사람의 이름
-- Main쿼리 -- sub쿼리가 먼저 실행되고 main쿼리가 실행됨
select fname
from emp
where salary = (select max(salary) from emp); -- (Sub쿼리) : 뷰로 생성가능
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

-- Join(2개 이상의 table을 연결해서 여러개의 data를 추출하는 작업) -> 컬럼이 연결되어 긴 레코드 한줄이 만들어진다!!!!
-- empid, fname, deptid, deptname
select e.empid, e.fname, e.deptid, d.deptname -- 테이블이름.칼럼이름 으로 표시
from emp e, dept d -- 테이블에 별칭을 붙임
where e.deptid = d.deptid -- 조건을 주어 두 테이블을 이어 붙임!!!(보통 fk와 참조하는 pk 연결)
order by 1; 
-- empid, fname, jobtitle
select e.empid, e.fname, j.jobtitle, d.deptname
from emp e, job j, dept d
where e.jobid = j.jobid and e.deptid = d.deptid -- 연결고리는 select하지 않아도 됨
order by 1;

--
select *
from emp
where empid = 998;

select *
from v_emp1
where empid = 998;

insert into v_emp1 values(998,'kim',6000,30); -- emp에 내용이 insert된다.

-- view : member(mid, mname, tel) v_member
create or replace view v_member
as 
select mid, mname, tel
from member;
-- insert into v_member(mid, mname, tel) values(729,'Genie','123'); -- 안됨 not null로 지정한 컬럼이 있다.

-- empid, fname, mgr이름
create or replace view mgrnames
as
select e.empid, e.fname, ee.fname "mgrname"
from emp e, emp ee -- 자기 자신을 2개 join
where e.mgrid = ee.empid;
select * from mgrnames;