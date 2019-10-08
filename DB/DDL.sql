-- table creation(ddl)
-- 회원 정보 저장을 위한 테이블 : mymember
-- 주문 정보 저장을 위한 테이블 : myorder

-- mymember
-- 제약조건(primary key, not null, foreign key,
create table mymember(mid varchar(10) primary key,
name varchar(10) not null,
address varchar(20) not null);
-- myorder
create table myorder(oid int(3) primary key,
mid varchar(10),
odate timestamp default current_timestamp,
payment varchar(15) default 'money_wire' not null,
constraint pcheck check(payment in('credit card','money_wire','point')));

-- foreign key 지정(myorder 테이블의 mid 컬럼에 지정) : 옵션 지정
alter table myorder
add constraint myorder_fk foreign key(mid)
references mymember(mid) on delete cascade; -- 부모 테이블에서 레코드 삭제 시 자식 테이블 레코드까지 같이 삭제되는 옵션

insert into mymember values(100, 'jane', 'seoul');

-- 주소 -> paris
update mymember
set address = 'paris'
where mid = 100;
select * from mymember;

insert into myorder values(1,100,null,'point');
select * from myorder;
insert into myorder(oid, mid, payment) values(2,100,'point');
select * from myorder;

delete
from mymember
where mid = 100;

drop table mymember, myorder;