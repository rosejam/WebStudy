-- 회원 정보(member) 를 표시한 테이블
-- 아이디(id)   비밀번호(password)  이름(name)  이메일(email) 
-- 주소(address) 탈퇴여부(withdraw)
create table member(
  id  				varchar(30)  primary key,	-- 아이디(id) 
  password			varchar(30)  not null,		-- 비밀번호(password)
  name				varchar(30)  not null,		-- 이름(name)
  email				varchar(255),				-- 이메일(email) 
  address			varchar(100),				-- 주소(address)
  withdraw			char(1)      default 'N'	-- 탈퇴여부(withdraw)
);

-- 게시판
create table board(
  no        int  primary key,					-- 게시글 번호
  id        varchar(30),						-- 작성자 id
  title     varchar(100),						-- 제목
  regdate   date,								-- 등록일
  contents  varchar(3000),						-- 내용
  foreign key fk_board_id (id) references member(id)
);



create table boardfile(
  no       		int auto_increment primary key,	-- 파일 번호
  rfilename		varchar(100),					-- 작성자가 올린 파일 이름
  sfilename     varchar(100),					-- 시스템에 저장된 파일 이름
  bno           int,							-- 게시글 번호
  foreign key fk_boardfile_bno (bno) references board(no)   on delete cascade
)


-- member data-----------------------------
insert into member(id ,password	,name,email	,address)
values('ssafy','1111','싸피','admin@ssafy.com')

-- board data ----------------------------- 
insert into board(no, id, title, regdate, contents)
values(1,'ssafy','hello', now(), '처음하는 게시판');
insert into board(no,id, title, regdate, contents)
values(2, 'ssafy','hello', sysdate(), '처음하는 게시판');
insert into board(no,id, title, regdate, contents)
values(3, 'ssafy','mysql이란?', sysdate(), '데이타 베이스의 한 종류이면서 공짜야');
insert into board(no,id, title, regdate, contents)
values(4, 'ssafy','backEnd', sysdate(), '잘되나?');