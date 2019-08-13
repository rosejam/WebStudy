use scott;

-- table의 description 확인 : 테이블 구조
desc emp;
-- -----------------------------------
-- DATA 검색
select empid, fname
from emp;
-- *(전체)보다 이름을 모두 적는게 빠르다.
select *
from emp;

-- distict는 중복 컬럼 제거 (여러개가 나오면 "컬럼 조합"이 중복되지 않게 검색됨)
select distinct deptid, jobid
from emp;
-- all은 디폴트(중복)
select all jobid
from emp;

-- 정렬 by salary(디폴트 : asc 오름차순) 
select empid, fname, salary
from emp
order by salary desc; -- desc 내림차순
-- 입사날짜 빠른 순 우선으로(같으면 연봉이 많은 순서)
select empid, fname, hdate, salary -- 1234
from emp
order by 3 asc, salary desc; -- 인덱스로 정렬 가능

-- alias(띄어쓰고 별명)
select empid "사원 번호", fname 이름, phone as 전화
from emp;

-- 연산자
select empid 사번, fname 이름, salary 연봉, salary * 1.2 새연봉
from emp;
-- 보너스, 커미션, 보너스 많은 순서
select empid 사번, fname 이름, salary 연봉, salary * 0.1 보너스, salary * comm 커미션
from emp
order by 보너스 desc; -- alias로 정렬 가능 

-- where : 조건 검색
select empid, fname, lname, deptid
from emp 
where deptid > 50
order by deptid;
-- 비교
select *
from emp
where salary >= 8000 and salary <= 12000;
-- and
select *
from emp
where jobid = 'IT_PROG' and salary >= 5000;
-- or
select *
from emp
where deptid =10 or deptid =20;

-- null값과 비교 할 때는 is!!!!사용
select *
from emp
where comm is not null; -- 또는 not null
-- 부서배정 못받은 사람
select *
from emp
where deptid is null;

-- between
select *
from emp
where hdate between '2003-01-01' and '2003-12-31'; -- 문자에는 꼭 ''따옴표, 숫자는 상관없음!!
select *
from emp
where deptid between '10' and '30';

-- in(=여러개 or과 같다~!)
select *
from emp
where empid in (129,139,149);

-- *like %(아무 글자~ 아무개수~), _(딱 한글자)
select *
from emp
where fname like 'A%'; -- A로 시작하고 뒤에 는 아무거나 오는 fname!!!! -- 게시판 제목검색 등
-- 전화번호가 515로 시작
select *
from emp
where phone like '515%';
-- 영업부사람들 SA파트 사람들은 COMM정보가 있다.
select *
from emp
where jobid like 'SA%';
-- 이름에 a가 들어가는 사람!
select *
from emp
where fname like '%a%';
-- _
select *
from emp
where fname like 'Ada_';
-- _개수만큼 글자가 오는 것
select *
from emp
where fname like 'Nee__';

-- 부서번호 30아닌
select *
from emp
where deptid not in (30);
-- 부서번호 30아닌
select *
from emp
where deptid <> 30; -- <> not

-- 함수
-- 집계함수(count,sum,min,max,avg)
select count(empid) 사원수, count(deptid) 부서수 from emp; -- (컬럼)에 들어있는 개수 세기 -- null은 빼고 센다~
select count(*) from emp; -- 아무 컬럼 잡아서 값이 있는거로 치고 센다.

select max(salary), min(salary), round(avg(salary),1), sum(salary)
from emp;

-- 숫자 관련 함수
select ceil(8.9); -- 올림
select floor(2.3); -- 내림
select round(4.6677, 2); -- 반올림, 소수점 몇까지
select greatest(100, 78, 999);
select least(23,56,11);

-- 문자열 관련 함수
select empid, concat(fname, " ", lname) 이름 -- 이름을 공백하나 끼우고 "붙였다."
from emp;
select fname, replace(fname, 'a', 'x') name 
from emp;
select fname, left(fname, 2) -- 왼쪽에서 2글자만 짜름
from emp;
select fname, right(fname, 2) -- 오른쪽에서 2글자만 짜름
from emp;
select fname, substr(fname,2,3), substring(fname,2,3) -- 동일 "2번째부터 3글자"
from emp;
select fname, reverse(fname), ucase(fname), lcase(fname) -- 순서뒤집기, 대문자로, 소문자로
from emp;
select fname, lpad(fname, 10, '*') -- 왼쪽을 *로 채워서(pad) 10글자를 채운다!!
from emp;
select fname, rpad(fname, 10, '#') -- 오른쪽을 #로 채워서(pad) 10글자를 채운다!!
from emp;

-- 날짜 관련 함수
select now(), sysdate(), curdate(), curtime(); -- 현재 날짜+시간 2가지표현, 날짜, 시간
select now(), date_add(now(), interval 1 second); -- now에 1초를 더한 것
select year(now()), month(now()), monthname(now()), dayofweek(now()); -- now() : 이 쿼리문 실행순간의 시스템의 시간을 가져다씀, 1번째 날 일요일
select fname, hdate, dayofmonth(hdate) -- 몇 일인지
from emp;
select fname, hdate, date_format(hdate, '%Y'), date_format(hdate, '%y'), -- ,뒤의 형식으로 날짜를 뽑아준다.
date_format(hdate, '%M'), date_format(hdate, '%m'), -- 영어 월, 2자리 월
date_format(hdate, '%c'), -- 1자리 월
date_format(hdate, '%D'), date_format(hdate, '%W') -- 며칠(서수), 요일
from emp;
-- select empid, fname, to_char(hdate, 'yyyy-mm-dd')
-- from emp;

-- case~when
select empid, fname, salary,
case when salary > 15000 then 'high'
     when salary > 8000 then 'mid'
     else 'low'
end grade -- (alias) end를 꼭 붙여주어야 함 
from emp;

select comm, if(comm, 1, 0), ifnull(comm, 'none'), coalesce(comm, 'nope') -- if는 삼항연산자처럼 null아니면 앞, null이면 뒤 --ifnull은 null아니면 자기값, null이면 뒤 --coalesce는 null아니면 자기값, null이면 뒤
from emp;
-- coalesce(a,b,c...) : a,b,c 중 null이 아닌 최초의 값 리턴
select coalesce(comm, fname) 
from emp;

select salary, format(salary, 2)
from emp;

select avg(salary), deptid -- 평균 샐러리(1개), 직무번호(107개) "갯수가 다르므로 잘못된 문장"
from emp;
-- group by
select avg(salary), deptid
from emp
group by deptid; -- deptid가 같은것 끼리 그룹지었다!!!! 따라서 값1개, 1개 
-- 부서 별 오름차순 정렬, 소수점 2자리, 별칭 -> 평균연봉, 부서
select round(avg(salary),2) 평균연봉, deptid
from emp
where deptid >= 50
group by deptid asc;
-- 부서dept,직무job 
select round(avg(salary),2) 연봉평균, sum(salary) 연봉합계, deptid, jobid -- 집계함수가 있을 경우 "집계함수빼고 일반 column들은 group by로 적어주어야" 한다!!!!
from emp
where deptid >= 50
group by deptid, jobid; -- deptid가 같은 것 끼리 그룹지은 후, 그 안에서 jobid가 같은 것끼리 또 그룹짓는다!!!!
-- group by로 그룹을 나눠 작업할 때는 select절에 그룹함수를 제외한 모든 컬럼이 group by절에 나타나야 함.
-- 직무별 연봉 평균
select round(avg(salary),2) 연봉평균, jobid
from emp
group by jobid;
-- 부서별 인원 수!
select deptid, count(*) cnt
from emp
where deptid is not null and deptid >= 50 -- null인 킴벌리 제외!! -- 이건 <일반조건>!!!!(여기서 걸러낼 그룹은 모두 걸러낸다!!!!)
group by deptid -- 그룹은 부서
having count(*) >= 6 -- having은 <그룹 조건>!!!! 집계함수로 조건을 보통체크
order by cnt desc; -- 인원수로 정렬
-- 부서별 제일 높은 연봉(이 1만 이상인 부서만)
select max(salary), deptid
from emp
group by deptid -- 그룹은 부서
having max(salary) >= 10000;

-- --------------------------------- 
