DROP DATABASE IF EXISTS wishingworld;
CREATE DATABASE wishingworld;
USE wishingworld;

CREATE TABLE users
(
 user_id 	int 	NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
 username 	VARCHAR(45) NOT NULL,
 passcode VARCHAR(45) NOT NULL,
 first_name VARCHAR(45),
 last_name VARCHAR(45),
 email VARCHAR(45)
);

CREATE TABLE wishlist
(
wishlist_id		INT		NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
user_id INT,
wishlist_name VARCHAR(45),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);



CREATE TABLE wish
(
wish_id 		INT		NOT NULL 	PRIMARY KEY		AUTO_INCREMENT,
wish_name VARCHAR(45),
wish_link VARCHAR(45),
wish_price DOUBLE,
reserved BOOLEAN,
wishlist_id INT,
FOREIGN KEY (wishlist_id) REFERENCES wishlist(wishlist_id)
);



INSERT INTO users (first_name, last_name, email, username, passcode) VALUES
("Test", "User", "testUser@gmail.com", "test Username", "password"),
("test2", "user2", "testUser2@gmail.com", "username", "hej");

INSERT INTO wishlist (wishlist_name, user_id) VALUES 
("wishlist name", 1);

INSERT INTO wish (wish_name, wish_link, reserved, wish_price, wishlist_id) VALUES
("Wish#1", "WishLink", false, 199.99, 1);




