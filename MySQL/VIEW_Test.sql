use scott;

create or replace view v_emp1 -- --
as -- -- 이 두줄만 붙이면 view로 만들 수 있다!!!!
select empid, fname, salary, deptid
from emp
where deptid <= 50; -- 내용바꾸고 다시 실행시키면 다시 생성된다. replace

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

-- INDEX
-- view: member(mid, manme, tel) v_member
create or replace view v_member as select mid, mname, tel from member;
select * from v_member;
insert into v_member values(729, 'Genie', '123'); -- view: 원래 테이블에 영향을 주기 때문에 원래 테이블에 맞는 형식으로 insert 해야됨.

create or replace view v_emp1 as select empid, fname, salary, deptid from emp where deptid<=50;
select * from v_emp1;

drop view v_emp1;

create or replace view v_emp1 as select fname from emp where salary = (select max(salary) from emp); -- 서브 쿼리 사용
select * from v_emp1;
-- from others

--
-- transaction
use scott;

desc test;
select * from test;
delete from test;

-- auto commit 기능을 켬
set autocommit = on;
insert into test values(1,'abc');
insert into test values(2,'abc');
rollback; -- 안먹음 이미 커밋됨

-- transaction의 시작을 알리는 명령어
start transaction;
insert into test values(3,'abc');
insert into test values(4,'abc');
select * from test;
rollback; -- transaction이 끝날 때, rollback;또는 commit;을 해서 끝낸다!!
