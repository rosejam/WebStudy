-- table 삭제
drop table test;

-- 테이블 생성
create table test(id int(3) primary key, name varchar(20) not null); -- primary key, not null등은 제약조건

insert into test values(1, 'harry');
select * from test;

-- tel 컬럼 추가
alter table test add(tel varchar(10)); -- 괄호
-- tel 컬럼 수정
alter table test modify tel varchar(13); -- 괄호X
desc test;
-- tel 컬럼 삭제
alter table test drop tel;
desc test;

-- 제약조건 표기1. inline 방식
create table test2(id int(3) primary key, name varchar(20) not null);
-- 2. outline
create table test3(id int(3), name varchar(20) not null,
constraint test3_pk primary key(id)); -- 컬럼 모두 작성 후 뒤에 constraint "제약조건이름" 제약조건(조건을 걸려는 컬럼이름)	-- 이름은 중복되지 않게~
-- 3.after creation
create table test4(id int(3) primary key, name varchar(20) not null);
alter table test4 add constraint test4_pk primary key(id); -- add constraint

-- add pk
alter table emp add constraint emp_pk primary key(empid);
alter table dept add constraint dept_pk primary key(deptid);
alter table job add constraint job_pk primary key(jobid);
alter table loc add constraint loc_pk primary key(locid);

-- add fk : emp(deptid) --> dept(deptid)
alter table emp
add constraint emp_deptid_fk foreign key(deptid) -- emp 테이블의 deptid가 fk(참조키) 
references dept(deptid); -- dept테이블의 deptid를 참조한다!
-- emp(jobid) --> job(jobid)
alter table emp
add constraint emp_jobid_fk foreign key(jobid) 
references job(jobid); 
-- emp(mgrid) --> emp(empid)
alter table emp
add constraint emp_mgrid_fk foreign key(mgrid) 
references emp(empid); 
-- dept(locid) -->loc(locid)
alter table dept
add constraint dept_locid_fk foreign key(locid) 
references loc(locid); 

insert into dept values(990,'it',107, 999);

-- member table
create table member (mid varchar(10) primary key, mname varchar(10) not null, tel varchar(13) not null, addr varchar(20) not null);
-- orders table
create table orders (oid int(3) primary key, mid varchar(10), odate DATETIME default CURRENT_TIMESTAMP, payment varchar(15) default 'money wire' not null,
constraint paycheck check(payment in('credit card','money wire','point'))); -- inline
-- 또는 alter사용! (in()안에 있는것만 넣을 수 있다는 뜻))
-- alter table orders add constraint paycheck check(payment in('credit card','money wire','point'));

-- foreign key 생성시 on delete cascaded옵션 추가
alter table orders
add constraint orders_mid_fk foreign key(mid)
references member(mid) on delete cascade; -- 부모테이블에서 삭제 시 그 값을 참조하고 있는 자식테이블 레코드까지 모두 삭제되는 옵션!

insert into member values(111,'tim','01023456789','la');
insert into member values(222,'gelly','01023444489','seoul');
insert into member values(333,'queen','01025556789','la');

insert into orders(oid, mid) values(1,111);
insert into orders(oid, mid) values(2,222);
insert into orders(oid, mid) values(2,999); -- error(참조키)

select * from member;
select * from orders;

-- table 생성
create table emp2
select * from emp;
-- emp3
create table emp3
select * from emp
where deptid >= 50;

-- auto_increment
create table member1 (mid int(10) auto_increment primary key, mname varchar(10) not null, tel varchar(13) not null, addr varchar(20) not null);
insert into member1 (mname, tel, addr) values('a','a','a'); -- 여러번하면 자동으로 1부터 매겨지는 mid 번호
select * from member1; 
