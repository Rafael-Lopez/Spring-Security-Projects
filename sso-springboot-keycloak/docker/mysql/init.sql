DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id bigint NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) NOT NULL,
  username varchar(45) NOT NULL,
  password varchar(300) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id bigint NOT NULL AUTO_INCREMENT,
  role varchar(45) NOT NULL,
  user_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO `user` VALUES (1,'John','Smith','john@gmail.com','john','$2a$10$F8sB/g1Ye6e/bi8ZeYig.OSYyFUDCPjDgo.1lvyiiQ8Fcr8gnbhbG'),(2,'Sachin','Dave','sachin@gmail.com','sachin','$2a$10$ScVCKTI48YezLftvZIyOculWARv/ros/isElYZyqpT1ftVJ4g/zai');

INSERT INTO `role` VALUES (1,'STUDENT',1),(2,'PROFESSOR',2);