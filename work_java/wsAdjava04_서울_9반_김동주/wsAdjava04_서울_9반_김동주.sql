use tommy;

create table author (authorno int(2) primary key, name varchar(50), phone varchar(30));

insert into author values(1, '서민규', '01021234567');
insert into author values(2, '김태희', '01066234511');
insert into author values(3, '조용준', '01098669022');
insert into author values(4, '김동근', '01092649032');
insert into author values(5, '박상진', '01045779083');
insert into author values(6, 'diana', '01045779773');

update author set name = '김현주' where authorno = 3;
update author set name = '자앤 기술연구소' where authorno = 4;
update author set name = '이세준' where authorno = 5;


alter table book
add (authorno int(2));

alter table book
drop author;

alter table book
add constraint book_authorno_fk foreign key(authorno)
references author(authorno);

update book set authorno = 2 where title = 'Java와 놀기';
update book set authorno = 1 where title = 'Java와 알고리즘';
update book set authorno = 5 where title = 'IoT세상';
update book set authorno = 3 where title = 'AI와 미래';
update book set authorno = 4 where title = 'JAVA 기본';
update book set authorno = 4 where title = 'JAVA 중급';
update book set authorno = 4 where title = 'JAVA 심화';

-- 
select b.title, b.price, a.name
from book b, author a
where b.authorno = a.authorno;
--
select b.title, b.isbn, b.publisher
from book b, author a
where b.authorno = a.authorno
and a.name = '김태희';
--
select b.title, b.publisher, b.price, a.name
from book b, author a
where b.authorno = a.authorno
order by a.name;
--
select title, publisher
from book;