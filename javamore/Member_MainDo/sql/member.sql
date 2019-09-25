create table member(
	 id 		varchar(30) primary key
	,password	varchar(30) not null
    ,name		varchar(30) not null
    ,email		varchar(50) 
    ,address	varchar(200)
    ,phone		varchar(15)
);

-- 테이블 구조    desc 테이블이름;
desc member;

insert into member(id, password, name, email, address, phone)
values('jaen','1111','자앤','jaen@andoridjava.com','서울시 서초구','02');

insert into member(id, password, name, email, address, phone)
values('ssafy','1111','싸피','ssafy@andoridjava.com','서울시 강남구','02');

insert into member(id, password, name, email, address, phone)
values('kdg','1111','김동근','kdg@andoridjava.com','서울시 성북구','010');

