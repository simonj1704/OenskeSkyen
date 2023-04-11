DROP DATABASE IF EXISTS oenskeskyen;
CREATE DATABASE oenskeskyen;
USE oenskeskyen;

CREATE TABLE users
(
 user_id 	int 	NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
 username 	VARCHAR(45) NOT NULL,
 passcode VARCHAR(45) NOT NULL,
 first_name VARCHAR(45),
 last_name VARCHAR(45),
 email VARCHAR(45),
 phone_number VARCHAR(45)
);

CREATE TABLE wish
(
wish_id 		INT		NOT NULL 	PRIMARY KEY		AUTO_INCREMENT,
wish_name VARCHAR(45),
wish_link VARCHAR(45),
reserved BOOLEAN
);


CREATE TABLE wishlist
(
wishlist_id		INT		NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
user_id INT,
wishlist_name VARCHAR(45),
wish_id	INT,
FOREIGN KEY (wish_id) REFERENCES wish(wish_id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);



INSERT INTO users (first_name, last_name, email, phone_number, username, passcode) VALUES
("Test", "User", "testUser@gmail.com", "123456", "test Username", "password"),
("test2", "user2", "testUser2@gmail.com", "654321", "username", "hej");

INSERT INTO wish (wish_name, wish_link, reserved) VALUES
("Wish#1", "WishLink", false);

INSERT INTO wishlist (wishlist_name, user_id, wish_id) VALUES 
("wishllist name", 1, 1);


