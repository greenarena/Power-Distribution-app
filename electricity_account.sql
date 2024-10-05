CREATE DATABASE  IF NOT EXISTS `electricity` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `electricity`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: electricity
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `meterNumber` varchar(45) NOT NULL,
  `grid` varchar(45) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `access` int(10) NOT NULL,
  `billing` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','Orita','admin','admin','admin','admin123',1,0,0,'2017-09-20 11:38:18'),(7,'234455','Felele','sola','adewale','sole','sole',1,5996,100,'2017-09-21 16:50:26'),(9,'343red','Orita','John','Smith','tgtgt','gtgtgt',1,5481,0,'2017-09-22 15:33:00'),(10,'rfcerc45t45','Orita','Hala','Gorani','rfefe','gergrgr',1,0,0,'2017-09-22 15:37:28'),(11,'6yyyy56757','Oluyole','Anderson','Cooper','hhh','hhhjj',1,53832,0,'2017-09-22 15:39:16'),(12,'6768DF','Challenge','Olusola','Olawale','Walexo','Hello',1,0,0,'2017-09-24 09:43:04'),(13,'0805848','Adeoyo','ade','adeiyi','sola','wake',1,37608,0,'2017-09-24 20:12:54'),(14,'080584852','Adeoyo','Williams','Serena','hello','123',1,400,32,'2017-09-24 18:00:26'),(15,'9346778564DF','Orita','Hong ','Kong','hong','kong',1,0,0,'2017-09-24 21:01:57');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-26 16:14:05
