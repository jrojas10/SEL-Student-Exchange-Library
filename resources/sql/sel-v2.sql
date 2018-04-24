-- 
-- Originally created by Anthony ; posted on slack.
-- 
-- SEL DATABASE SQL FILE v2
-- 
 
 CREATE DATABASE SELv1;

 CREATE TABLE users (
 	firstName VARCHAR(20), 
 	lastName VARCHAR(35), 
 	userID int NOT NULL, 
 	userName VARCHAR(8) NOT NULL, 
 	email VARCHAR(35) NOT NULL, 
 	phone VARCHAR (25), 
 	PRIMARY KEY (userID)
 );

CREATE TABLE posts (
	postID INT NOT NULL, 
	bookID INT NOT NULL,
	UserID INT NOT NULL,
	PRIMARY KEY (postID)
);

CREATE TABLE books (
	bookID INT NOT NULL,
	subject VARCHAR(35),
	state VARCHAR(10),
	price INT NOT NULL,
	isbn VARCHAR(13),
	title VARCHAR(35),
	authorFName VARCHAR(20),
	authorLName VARCHAR(35),
	PRIMARY KEY (bookID)
);