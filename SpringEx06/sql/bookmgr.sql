DROP table book;
DROP TABLE users;

CREATE TABLE users (
	no 			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	attachment  VARCHAR(255),
	UNIQUE (email)
);

CREATE table book (
 	isbn INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 	title VARCHAR(30) NOT NULL,
 	author VARCHAR(10) NOT NULL,
 	publisher VARCHAR(30) NOT NULL,
 	price	INT NOT NULL,
 	attachment VARCHAR(255),
 	description VARCHAR(255)
 );
 
 INSERT INTO users (email, password, name, attachment)
	VALUES ('dongmin01@naver.com', '1111', '강동민1호', null);
	
INSERT INTO users (email, password, name, attachment)
	VALUES ('dongmin02@naver.com', '2222', '강동민2호', null);

INSERT INTO users (email, password, name, attachment)
	VALUES ('dongmin03@naver.com', '3333', '강동민3호', null);
 
INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-1', '저자-1', '출판사-1', 10000, '책설명-1', null);

INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-2', '저자-2', '출판사-2', 20000, '책설명-2', null);
	
INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-3', '저자-3', '출판사-3', 10000, '책설명-3', null);
	
	
	
SELECT * FROM book;
SELECT * FROM users;