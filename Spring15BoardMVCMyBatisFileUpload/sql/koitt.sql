#DDL(Data Definition Language)

DROP TABLE board;
DROP TABLE users;

CREATE TABLE users (
	no 			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	UNIQUE (email)
);

CREATE TABLE board (
	no INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(30) NOT NULL,
	content VARCHAR(255) NULL,
	user_no INT NOT NULL,
	regdate DATE NOT NULL,
	attachment VARCHAR(255),
	FOREIGN KEY (user_no) REFERENCES users (no)
);

#DML(Data Manipulation Language)
INSERT INTO users (email, password, name)
	VALUES ('dongmin01@naver.com', '1111', '강동민1호');
	
INSERT INTO users (email, password, name)
	VALUES ('dongmin02@naver.com', '2222', '강동민2호');

INSERT INTO users (email, password, name)
	VALUES ('dongmin03@naver.com', '3333', '강동민3호');

INSERT INTO board (title, content, user_no, regdate, attachment)
	VALUES ('제목-1', '내용-1', 1, STR_TO_DATE('2018-02-01', '%Y-%m-%d'), NULL);
	
INSERT INTO board (title, content, user_no, regdate, attachment)
	VALUES ('제목-2', '내용-2', 1, STR_TO_DATE('2018-02-01', '%Y-%m-%d'), NULL);
	
INSERT INTO board (title, content, user_no, regdate, attachment)
	VALUES ('제목-3', '내용-3', 1, STR_TO_DATE('2018-02-01', '%Y-%m-%d'), NULL);
	
#DQL(Data Query Language)
SELECT * FROM board;
SELECT * FROM users;
