-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: nsms
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `nsms`
--

/*!40000 DROP DATABASE IF EXISTS `nsms`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `nsms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nsms`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_code` varchar(100) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminpermision`
--

DROP TABLE IF EXISTS `adminpermision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminpermision` (
  `accept_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminpermision`
--

LOCK TABLES `adminpermision` WRITE;
/*!40000 ALTER TABLE `adminpermision` DISABLE KEYS */;
INSERT INTO `adminpermision` VALUES ('1');
/*!40000 ALTER TABLE `adminpermision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `class_number` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `start_date` varchar(100) DEFAULT NULL,
  `end_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`class_number`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `exam_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `exam_name` varchar(100) DEFAULT NULL,
  `exam_degree` double DEFAULT NULL,
  `exam_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`exam_code`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expired_date`
--

DROP TABLE IF EXISTS `expired_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expired_date` (
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expired_date`
--

LOCK TABLES `expired_date` WRITE;
/*!40000 ALTER TABLE `expired_date` DISABLE KEYS */;
INSERT INTO `expired_date` VALUES ('2019-08-01','2020-08-01');
/*!40000 ALTER TABLE `expired_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_money`
--

DROP TABLE IF EXISTS `external_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_money` (
  `person_name` varchar(100) DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `paid_date` varchar(100) DEFAULT NULL,
  `month` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_money`
--

LOCK TABLES `external_money` WRITE;
/*!40000 ALTER TABLE `external_money` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footer`
--

DROP TABLE IF EXISTS `footer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `footer` (
  `footer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footer`
--

LOCK TABLES `footer` WRITE;
/*!40000 ALTER TABLE `footer` DISABLE KEYS */;
INSERT INTO `footer` VALUES ('مع تحياتي');
/*!40000 ALTER TABLE `footer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holder`
--

DROP TABLE IF EXISTS `holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holder` (
  `user_code` varchar(100) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holder`
--

LOCK TABLES `holder` WRITE;
/*!40000 ALTER TABLE `holder` DISABLE KEYS */;
INSERT INTO `holder` VALUES ('1','1','1');
/*!40000 ALTER TABLE `holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `path`
--

DROP TABLE IF EXISTS `path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `path` (
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `path`
--

LOCK TABLES `path` WRITE;
/*!40000 ALTER TABLE `path` DISABLE KEYS */;
INSERT INTO `path` VALUES (' ');
/*!40000 ALTER TABLE `path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_for_book`
--

DROP TABLE IF EXISTS `pay_for_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_for_book` (
  `student_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `rest` int(11) DEFAULT NULL,
  `paid_date` varchar(100) DEFAULT NULL,
  `paid_time` varchar(100) DEFAULT NULL,
  `recieve` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`student_code`,`book_name`),
  CONSTRAINT `pay_for_book_ibfk_1` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_for_book`
--

LOCK TABLES `pay_for_book` WRITE;
/*!40000 ALTER TABLE `pay_for_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_for_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_for_month`
--

DROP TABLE IF EXISTS `pay_for_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_for_month` (
  `student_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `month_name` varchar(100) NOT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `rest` int(11) DEFAULT NULL,
  `paid_date` varchar(100) DEFAULT NULL,
  `paid_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`student_code`,`month_name`),
  CONSTRAINT `pay_for_month_ibfk_1` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_for_month`
--

LOCK TABLES `pay_for_month` WRITE;
/*!40000 ALTER TABLE `pay_for_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_for_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz` (
  `quiz_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `quiz_name` varchar(100) DEFAULT NULL,
  `quiz_degree` double DEFAULT NULL,
  `quiz_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`quiz_code`),
  CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretary`
--

DROP TABLE IF EXISTS `secretary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretary` (
  `secretary_code` varchar(100) NOT NULL,
  `secretary_name` varchar(255) DEFAULT NULL,
  `secretary_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`secretary_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretary`
--

LOCK TABLES `secretary` WRITE;
/*!40000 ALTER TABLE `secretary` DISABLE KEYS */;
INSERT INTO `secretary` VALUES ('1','1','1');
/*!40000 ALTER TABLE `secretary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sortall`
--

DROP TABLE IF EXISTS `sortall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sortall` (
  `student_code` int(11) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `attendance_number` int(11) DEFAULT NULL,
  `attendance_ratio` double DEFAULT NULL,
  `studentQuizDegree` double DEFAULT NULL,
  `quiz_degree_ratio` double DEFAULT NULL,
  `student_exam_degree` double DEFAULT NULL,
  `exam_degree_ratio` double DEFAULT NULL,
  `total_ratio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sortall`
--

LOCK TABLES `sortall` WRITE;
/*!40000 ALTER TABLE `sortall` DISABLE KEYS */;
/*!40000 ALTER TABLE `sortall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_code` int(11) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `student_phone` int(11) DEFAULT NULL,
  `student_address` varchar(500) DEFAULT NULL,
  `parent_name` varchar(100) DEFAULT NULL,
  `parent_phone` int(11) NOT NULL,
  `parent_job` varchar(100) DEFAULT NULL,
  `relativity` varchar(100) DEFAULT NULL,
  `level_name` varchar(100) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `student_status` varchar(100) DEFAULT NULL,
  `stop_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`student_code`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_book`
--

DROP TABLE IF EXISTS `student_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_book` (
  `book_name` varchar(100) NOT NULL,
  `maxNumber` varchar(500) NOT NULL,
  `book_cost` double NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `sold` int(11) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`book_name`),
  CONSTRAINT `student_book_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_book`
--

LOCK TABLES `student_book` WRITE;
/*!40000 ALTER TABLE `student_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class_connection`
--

DROP TABLE IF EXISTS `student_class_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_class_connection` (
  `level_name` varchar(100) NOT NULL,
  `class_number` int(11) NOT NULL,
  `student_code` int(11) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `group_name` varchar(100) NOT NULL,
  `student_status` varchar(100) DEFAULT NULL,
  `attendance_date` varchar(100) DEFAULT NULL,
  `attendance_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`group_name`,`class_number`,`student_code`),
  KEY `level_name` (`level_name`,`student_code`),
  KEY `level_name_2` (`level_name`,`class_number`),
  CONSTRAINT `student_class_connection_ibfk_1` FOREIGN KEY (`level_name`, `group_name`) REFERENCES `student_group` (`level_name`, `group_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_class_connection_ibfk_2` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_class_connection_ibfk_3` FOREIGN KEY (`level_name`, `class_number`) REFERENCES `class` (`level_name`, `class_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class_connection`
--

LOCK TABLES `student_class_connection` WRITE;
/*!40000 ALTER TABLE `student_class_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_class_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_exam_connection`
--

DROP TABLE IF EXISTS `student_exam_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_exam_connection` (
  `exam_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `student_code` int(11) NOT NULL,
  `exam_name` varchar(255) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `exam_degree` double DEFAULT NULL,
  `student_degree` double DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`exam_code`,`student_code`),
  KEY `level_name` (`level_name`,`student_code`),
  CONSTRAINT `student_exam_connection_ibfk_1` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_exam_connection_ibfk_2` FOREIGN KEY (`level_name`, `exam_code`) REFERENCES `exam` (`level_name`, `exam_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_exam_connection`
--

LOCK TABLES `student_exam_connection` WRITE;
/*!40000 ALTER TABLE `student_exam_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_exam_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_group`
--

DROP TABLE IF EXISTS `student_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_group` (
  `group_name` varchar(100) NOT NULL,
  `maxNumber` varchar(500) DEFAULT NULL,
  `group_time` varchar(100) DEFAULT NULL,
  `level_name` varchar(100) NOT NULL,
  PRIMARY KEY (`level_name`,`group_name`),
  CONSTRAINT `student_group_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_group`
--

LOCK TABLES `student_group` WRITE;
/*!40000 ALTER TABLE `student_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_group_connection`
--

DROP TABLE IF EXISTS `student_group_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_group_connection` (
  `student_code` int(11) NOT NULL,
  `group_name` varchar(100) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  PRIMARY KEY (`level_name`,`student_code`,`group_name`),
  KEY `level_name` (`level_name`,`group_name`),
  CONSTRAINT `student_group_connection_ibfk_1` FOREIGN KEY (`level_name`) REFERENCES `student_level` (`level_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_group_connection_ibfk_2` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_group_connection_ibfk_3` FOREIGN KEY (`level_name`, `group_name`) REFERENCES `student_group` (`level_name`, `group_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_group_connection`
--

LOCK TABLES `student_group_connection` WRITE;
/*!40000 ALTER TABLE `student_group_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_group_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_level`
--

DROP TABLE IF EXISTS `student_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_level` (
  `level_name` varchar(500) NOT NULL,
  `month_cost` double DEFAULT NULL,
  `max_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`level_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_level`
--

LOCK TABLES `student_level` WRITE;
/*!40000 ALTER TABLE `student_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_notes`
--

DROP TABLE IF EXISTS `student_notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_notes` (
  `student_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `notes` varchar(1000) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `written_by` varchar(100) DEFAULT NULL,
  `written_date` varchar(100) DEFAULT NULL,
  KEY `level_name` (`level_name`,`student_code`),
  CONSTRAINT `student_notes_ibfk_1` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_notes`
--

LOCK TABLES `student_notes` WRITE;
/*!40000 ALTER TABLE `student_notes` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_quiz_connection`
--

DROP TABLE IF EXISTS `student_quiz_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_quiz_connection` (
  `quiz_code` int(11) NOT NULL,
  `level_name` varchar(100) NOT NULL,
  `student_code` int(11) NOT NULL,
  `quiz_name` varchar(255) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `quiz_degree` double DEFAULT NULL,
  `student_degree` double DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`level_name`,`quiz_code`,`student_code`),
  KEY `level_name` (`level_name`,`student_code`),
  CONSTRAINT `student_quiz_connection_ibfk_1` FOREIGN KEY (`level_name`, `student_code`) REFERENCES `student` (`level_name`, `student_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_quiz_connection_ibfk_2` FOREIGN KEY (`level_name`, `quiz_code`) REFERENCES `quiz` (`level_name`, `quiz_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_quiz_connection`
--

LOCK TABLES `student_quiz_connection` WRITE;
/*!40000 ALTER TABLE `student_quiz_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_quiz_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_monitoring`
--

DROP TABLE IF EXISTS `system_monitoring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_monitoring` (
  `secretary_code` varchar(255) DEFAULT NULL,
  `secretary_name` varchar(255) DEFAULT NULL,
  `event_kind` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `theEvent` varchar(1000) DEFAULT NULL,
  `event_date` varchar(255) DEFAULT NULL,
  `event_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_monitoring`
--

LOCK TABLES `system_monitoring` WRITE;
/*!40000 ALTER TABLE `system_monitoring` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_monitoring` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-07 20:07:39
