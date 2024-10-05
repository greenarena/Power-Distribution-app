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
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `challenge` (
  `idintochallenge` int(11) NOT NULL AUTO_INCREMENT,
  `txtDate` varchar(45) NOT NULL,
  `grid` varchar(45) NOT NULL,
  `schedule1` varchar(45) NOT NULL,
  `schedule2` varchar(45) NOT NULL,
  `schedule3` varchar(45) NOT NULL,
  `schedule4` varchar(45) NOT NULL,
  `schedule5` varchar(45) NOT NULL,
  `schedule6` varchar(45) NOT NULL,
  `schedule7` varchar(45) NOT NULL,
  `schedule8` varchar(45) NOT NULL,
  `hours` int(11) NOT NULL,
  `dateScheduled` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idintochallenge`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (1,'13-09-2017','Challenge','Blackout','LightUp','LightUp','Blackout','LightUp','LightUp','Blackout','LightUp',0,'2017-09-24 20:32:32'),(2,'22-09-2017','Challenge','LightUp','LightUp','LightUp','LightUp','LightUp','LightUp','LightUp','LightUp',24,'2017-09-24 20:32:32'),(3,'24-09-2017','Challenge','LightUp','LightUp','LightUp','LightUp','Blackout','Blackout','LightUp','LightUp',18,'2017-09-24 21:06:33');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-26 16:14:06
