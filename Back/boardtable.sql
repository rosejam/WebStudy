use scott;

CREATE TABLE BOARD (
	NUM INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, -- null로 써놓으면 자동으로 숫자가 매겨진다.
	PASS VARCHAR(20) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	WDATE DATE NOT NULL,
	TITLE VARCHAR(40) NOT NULL,
	CONTENT VARCHAR(100) NOT NULL,
	COUNT INT DEFAULT 0 NOT NULL)	; -- 조회수

 

COMMIT WORK ;

INSERT INTO BOARD VALUES (1, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습1', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (2, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습2', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (3, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습3', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (4, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습4', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (5, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습5', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (6, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습6', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (7, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습7', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (8, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습8', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (9, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습9', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (10, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습10', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (11, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습11', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (12, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습12', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (13, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습13', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (14, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습14', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (15, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습15', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (16, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습16', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (17, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습17', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (18, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습18', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (19, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습19', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (20, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습20', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (21, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습21', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (22, 'guest', 'Mel Gibson', SYSDATE(), '게시판 연습22', '게시판연습입니다.', 0);

commit work;
