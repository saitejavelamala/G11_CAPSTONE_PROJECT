-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: DoConnectDB
-- --------------------------------------------------------------------------------------------
-- Server version	8.0.29

-- --------------------------- DATABASE FOR DOCONNECT_SERVICE ---------------------------------

-- --------------------------------------------------------------------------------------------
-- Database DoConnectDB
DROP DATABASE IF EXISTS `DoConnectDB`;
CREATE DATABASE `DoConnectDB`;
-- --------------------------------------------------------------------------------------------



-- --------------------------------------------------------------------------------------------
-- Table structure for table `admin`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_email` varchar(255) DEFAULT NULL,
  `is_email_active` bit(1) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_mobile_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* Admin Table Structure
+---------------------+--------------+------+-----+---------+----------------+
| Field               | Type         | Null | Key | Default | Extra          |
+---------------------+--------------+------+-----+---------+----------------+
| admin_id            | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| admin_email         | varchar(255) | YES  |     | NULL    |                |
| is_email_active     | bit(1)       | YES  |     | NULL    |                |
| admin_name          | varchar(255) | YES  |     | NULL    |                |
| admin_password      | varchar(255) | YES  |     | NULL    |                |
| admin_mobile_number | varchar(10)  | YES  |     | NULL    |                |
+---------------------+--------------+------+-----+---------+----------------+
*/



-- --------------------------------------------------------------------------------------------
-- Table structure for table `user`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) DEFAULT NULL,
  `is_email_active` bit(1) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* User Table Structure
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| user_id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| user_email        | varchar(255) | YES  |     | NULL    |                |
| is_email_active   | bit(1)       | YES  |     | NULL    |                |
| user_name         | varchar(255) | YES  |     | NULL    |                |
| user_password     | varchar(255) | YES  |     | NULL    |                |
| user_phone_number | varchar(10)  | YES  |     | NULL    |                |
+-------------------+--------------+------+-----+---------+----------------+
*/


-- --------------------------------------------------------------------------------------------
-- Table structure for table `answer`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `is_approved` bit(1) DEFAULT NULL,
  `answer_user_user_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* Answer Table Structure
+---------------------+--------------+------+-----+---------+----------------+
| Field               | Type         | Null | Key | Default | Extra          |
+---------------------+--------------+------+-----+---------+----------------+
| id                  | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| answer              | varchar(255) | YES  |     | NULL    |                |
| is_approved         | bit(1)       | YES  |     | NULL    |                |
| answer_user_user_id | bigint(20)   | YES  | MUL | NULL    |                |
| question_id         | bigint(20)   | YES  | MUL | NULL    |                |
+---------------------+--------------+------+-----+---------+----------------+
*/


-- --------------------------------------------------------------------------------------------
-- Table structure for table `question`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_approved` bit(1) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL,
  `user_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* Question Table Structure
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| is_approved  | bit(1)       | YES  |     | NULL    |                |
| question     | varchar(255) | YES  |     | NULL    |                |
| topic        | varchar(255) | YES  |     | NULL    |                |
| user_user_id | bigint(20)   | YES  | MUL | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
*/


-- --------------------------------------------------------------------------------------------
-- Table structure for table `image_model`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `image_model`;
CREATE TABLE `image_model` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pic_byte` blob DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| name     | varchar(255) | YES  | UNI | NULL    |                |
| pic_byte | blob         | YES  |     | NULL    |                |
| type     | varchar(255) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
*/



-- -------------------------- DATABASE FOR CHAT_SERVICE ---------------------------------------

-- --------------------------------------------------------------------------------------------
-- Database DoConnectDB
DROP DATABASE IF EXISTS `DoConnectDB`;
CREATE DATABASE `DoConnectDB`;
-- --------------------------------------------------------------------------------------------


-- --------------------------------------------------------------------------------------------
-- Table structure for table `message`
-- --------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_user` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* Message table structure
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| from_user | varchar(255) | YES  |     | NULL    |                |
| message   | varchar(255) | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
*/