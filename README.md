# online-courses

DB Creation scripts:

-- MySQL
--
-- Host: localhost    Database: test1
-- ------------------------------------------------------
-- Server version	5.7.17-log

CREATE DATABASE  IF NOT EXISTS `test1`;
USE `test1`;


--
-- Table structure for table `course`
--
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
--
-- Dumping data for table `course`
--
INSERT INTO `course` VALUES (1,'Java'),(2,'English'),(3,'DotNet');


--
-- Table structure for table `s_tc_xref`
--
DROP TABLE IF EXISTS `s_tc_xref`;
CREATE TABLE `s_tc_xref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) NOT NULL,
  `tc_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tc_id_idx` (`tc_id`),
  KEY `FK_s_id_idx` (`s_id`),
  CONSTRAINT `FK_s_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tc_id` FOREIGN KEY (`tc_id`) REFERENCES `t_c_xref` (`tc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
--
-- Dumping data for table `s_tc_xref`
--
INSERT INTO `s_tc_xref` VALUES (1,1,2),(2,2,4),(4,3,4);


--
-- Table structure for table `student`
--
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
--
-- Dumping data for table `student`
--
INSERT INTO `student` VALUES (1,'Giri'),(2,'Mukul'),(3,'Nikhil');


--
-- Table structure for table `t_c_xref`
--

DROP TABLE IF EXISTS `t_c_xref`;
CREATE TABLE `t_c_xref` (
  `tc_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tc_id`),
  KEY `FK_c_id_idx` (`c_id`),
  KEY `FK_t_id_idx` (`t_id`),
  CONSTRAINT `FK_c_id` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_t_id` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
--
-- Dumping data for table `t_c_xref`
--
INSERT INTO `t_c_xref` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,3);

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `teacher`
--
INSERT INTO `teacher` VALUES (1,'Ruapk'),(2,'Koushik');
