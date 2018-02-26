DROP TABLE book;
DROP TABLE users_authority;
DROP TABLE authority;
DROP TABLE users;

CREATE TABLE users (
	no 			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	attachment  VARCHAR(255),
	UNIQUE (email)
);

#사용자 권한 정의한 테이블
CREATE TABLE authority(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(30) NOT NULL
);

# 사용자 번호와 사용자 권한 아이디값을 연결하는 테이블
CREATE TABLE users_authority(
	users_no INT NOT NULL,
	authority_id INT NOT NULL,
	FOREIGN KEY (users_no) REFERENCES users(no),
	FOREIGN KEY (authority_id) REFERENCES authority(id)
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
 
 INSERT INTO authority (id, name)
 	VALUES(10, 'ADMIN');
 	
 INSERT INTO authority (id, name)
 	VALUES(20, 'USER');
 
 # 사용자 입력 (비밀번호는 1234)
INSERT INTO users (email, password, name, attachment)
	VALUES ('admin@gmail.com', 
	'$2a$10$AF6PNoVqwj56NmOCuWz.1u8YO/km7XCA77ztKxbqIF3FVyQI1iYny', '관리자', NULL);
	
INSERT INTO users (email, password, name, attachment)
	VALUES ('user1@gmail.com',
	'$2a$10$AF6PNoVqwj56NmOCuWz.1u8YO/km7XCA77ztKxbqIF3FVyQI1iYny', '김일반', NULL);
	
INSERT INTO users (email, password, name, attachment)
	VALUES ('user2@gmail.com',
	'$2a$10$AF6PNoVqwj56NmOCuWz.1u8YO/km7XCA77ztKxbqIF3FVyQI1iYny', '김관사', NULL);
	
	INSERT INTO users_authority VALUES (1, 10);	#관리자 사용자에게 관리자 권한 부여
INSERT INTO users_authority VALUES (2, 20);	#김일반 사용자에게 사용자 권한 부여
INSERT INTO users_authority VALUES (3, 10);	#김관사 사용자에게 관리자 권한 부여
INSERT INTO users_authority VALUES (3, 20);	#김관사 사용자에게 사용자 권한 부여
 
INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-1', '저자-1', '출판사-1', 10000, '책설명-1', null);

INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-2', '저자-2', '출판사-2', 20000, '책설명-2', null);
	
INSERT INTO book (title, author, publisher, price, description, attachment)
	VALUES ('제목-3', '저자-3', '출판사-3', 10000, '책설명-3', null);
	
	
	
SELECT * FROM book;
SELECT * FROM users;