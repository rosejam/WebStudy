use scott;

-- (table 생성 테스트) -DDL임
create table test(
num int(3) not null,
name varchar(20) not null,
tel varchar(12));
desc test;
-- data insert
insert into test(num, name, tel) values(1, 'willy', '123'); -- insert into 테이블(넣을 컬럼들) values(넣을 내용);
insert into test(num, name) values(2, 'jane');
insert into test values(3, 'june', '789'); -- 컬럼명 생략
select * from test;

-- emp에 INSERT
select *
from emp;

insert into emp values(207,'tommy','lee','tommylee','515.123.4567',sysdate(),'IT_PROG',5000,null,103,60);
-- insert into emp(empid, fname, lname, email, deptid) values(207,'tom','cruise','tomtom',50); -- 사원 번호가 동일 하게 207이면 겹쳐 들어가지 않게 설정해주어야 함

commit;

select count(*) from emp;

select empid, fname, lname, email
from emp
where empid = 207;

-- emp DELETE
delete from emp
where empid = 207;
-- drop table emp; -- table을 통째로 삭제(ddl, not dml)

-- emp UPDATE
update emp
set salary = 6000, email = 'leelee'
where empid =207;

select *
from emp
where empid = 207;