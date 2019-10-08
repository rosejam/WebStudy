-- scott db 사용
use scott;
desc emp;

select *
from emp;

-- alias(컬럼별칭), heading
select empid as 사번, fname as 이름, deptid as 부서코드, salary as "올 연봉", salary*1.1 "새 연봉"
from emp;

-- emp 모든 부서 코드(중복 제거)
select distinct deptid 부서코드
from emp;

--
select empid, fname, salary, hdate, deptid, count(*)
from emp
where deptid > 50
group by deptid
having count(*) > 3 -- 그룹에 대한 조건
order by 4 desc; -- "4번째"인 hdate 내림차순(null은 가장 작은 취급)

-- 사번, 이름(FNAME), 연봉, 보너스(연봉의 30%) : 보너스 많은 순으로 정렬
select empid 사번, fname 이름, salary 연봉, round(salary*0.3,0) 보너스
from emp
order by 보너스 desc;

-- in, between, is null/not null, like
-- 연봉이 15000~ 25000 사이인 레코드
select *
from emp
where salary between 15000 and 25000;
-- 입사일이 '2005-01-01'에서 '2007-12-31'사이의 레코드
select *
from emp
where hdate between '2005-01-01' and '2007-12-31';
-- 사번이 146, 152, 155번 레코드의 모든 정보
select *
from emp
where empid in (146, 152, 155);
-- 이메일이 E로 시작하는 모든 레코드
select *
from emp
where email like 'E%';
-- 커미션을 받지 않는 모든 직원 정보
select *
from emp
where comm is null;
-- 커미션을 받는 모든 직원 정보
select *
from emp
where comm is not null;
-- 10, 20, 30, 40번 부서 이외의 부서 직원들 정보
select *
from emp
where deptid not in (10, 20, 30, 40);

-- 날짜 관련 함수
select now(), sysdate(), curdate(), curtime(); -- now와 sysdate는 동일
select year(now()), month(now()), monthname(now()), dayofmonth(now()), dayofweek(now()); -- 일요일부터 1
-- 사번, 이름, 입사일, 입사연도, 근속년도
select empid, fname, hdate, year(hdate), year(now())-year(hdate) 근속년도
from emp
order by 5 desc, 3 asc; -- 앞에가 같으면 뒤에거로 정렬

-- 집계함수(그룹함수) : count, max, min, avg...
-- 제일 높은 연봉 금액, 평균 연봉
select max(salary), avg(salary)
from emp;
-- 연봉이 높은 사람 순으로 5명
select *
from emp
order by salary desc
limit 5; -- order by 한 것을 위에서부터 5개 컷(mysql전용)

-- group by
-- 부서별 인원 수 출력
select deptid, count(*) cnt
from emp
group by deptid;
-- 부서별 연봉 평균
select avg(salary)
from emp
group by deptid;
-- 부서별 연봉의 총함
select sum(salary)
from emp
group by deptid;

-- 40번 이상의 부서를 대상으로 부서별 인원수가 3명 이상인 부서의 부서 id와 인원 수 출력(부서id가 null인 레코드 제외)
-- group by 절로 그룹을 나눠 작업할 때는 select절에 사용한 모든 일반 컬럼이 group by 절에 나와야 함!!!(그룹(집계)함수를 제외하고)
-- 중요
select deptid, count(*) cnt -- count는 그룹함수
from emp
where deptid is not null and deptid >= 40 -- 일반 조건
group by deptid
having cnt >=3 -- 그룹 조건
order by cnt desc;
-- 업무별(jobid) 인원수가 5명 이상인 레코드의 jobid, 인원수
select jobid, count(*) cnt
from emp
group by jobid
having cnt >=5;


-- 0. emp테이블의 모든 레코드
select *
from emp;
-- 1. empid가 158인 레코드의 fname,lname, phone 검색
select fname, lname, phone
from emp
where empid = 158;
-- 2. fname이 ‘M’로 시작하는 직원의 id와 이름,부서ID 검색
select empid, fname, deptid
from emp
where fname like 'M%';
-- 3. 부서번호가 30인 사원들의 사번과 fname, jobid, salary,deptid 출력
select empid, fname, jobid, salary, deptid
from emp
where deptid = 30;
-- 4. comm이 0.2이상인 사원의 사번과 fname,comm 출력
select empid, fname, comm
from emp
where comm >= 0.2;
-- 5. 입사일이 2005년 12월31일 이후인 직원의 사원의 사번과 fname,입사일 출력(입사일로 오름차순 정렬)
select empid, fname, hdate
from emp
where hdate >= '2005-12-31'
order by hdate;
-- 6. 부서번호가 20에서 50번 사이의 직원이름과 부서ID를 검색(부서id로 오름차순 정렬)
select fname, deptid
from emp
where deptid between 20 and 50
order by deptid;
-- 7. 부서번호가 없는 직원의 id와 email, 이름 검색
select empid, email, fname
from emp
where deptid is null;
-- 8. jobid가 'IT_PROG' ,'SA_MAN','SA_REP'인 직원의 id와 이름, jobid
select empid, fname, jobid
from emp
where jobid in ('IT_PROG','SA_MAN','SA_REP');
-- 9.  전화번호가 011로 시작하는 직원의 id와 이름,부서ID, 전화번호 검색
select empid, fname, deptid, phone
from emp
where phone like '011%';
-- 10. comm이 null이 아닌 직원 중 그 값이 0.2 이상인 레코드(comm으로 정렬)
select *
from emp
where comm is not null and comm >= 0.2
order by comm;
-- 11. 아래와 같이 출력 되도록 Query 작성
--       사번             설명         
--       101   Steven King starts work from 2002-03-24.
select empid 사번, concat(fname, ' ', lname, ' starts work from ', hdate) 설명
from emp;
-- 12. salary가 낮은 순 5명orders
select *
from emp
order by salary
limit 5;
-- 13. 입사일 순으로 사원 정보 정렬(오래된 순)
select *
from emp
order by hdate;
-- 14. 부서 ID가 40번이 아닌 부서에 속한 직원 들 중 SALARY가 12000 이상인 레코드
select *
from emp
where salary >= 12000 and deptid != 40;
-- 15. empid, fname, salary, 10% 증가된 salary(새연봉),  커미션 * 2(커미션이 없으면 'none' 출력)
select empid, fname, salary, 1.1*salary 새연봉, comm, if(comm, 1, 0), ifnull(comm*2, 'none')
from emp;