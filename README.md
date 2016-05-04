CREATE DATABASE  IF NOT EXISTS `blooddonationsystemdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blooddonationsystemdb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: blooddonationsystemdb
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `bloodbank`
--

DROP TABLE IF EXISTS `bloodbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloodbank` (
  `BloodBank_Name` varchar(20) NOT NULL,
  `BloodBank_AP` int(40) DEFAULT '0',
  `BloodBank_AN` int(40) DEFAULT '0',
  `BloodBank_BP` int(40) DEFAULT '0',
  `BloodBank_BN` int(40) DEFAULT '0',
  `BloodBank_ABP` int(40) DEFAULT '0',
  `BloodBank_ABN` int(40) DEFAULT '0',
  `BloodBank_OP` int(40) DEFAULT '0',
  `BloodBank_ON` int(40) DEFAULT '0',
  PRIMARY KEY (`BloodBank_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloodbank`
--

LOCK TABLES `bloodbank` WRITE;
/*!40000 ALTER TABLE `bloodbank` DISABLE KEYS */;
INSERT INTO `bloodbank` VALUES ('AUB',89,0,15,0,0,0,50,0),('HotelDieu',377,0,0,0,0,0,0,0),('LAU',1,0,0,0,100,0,10,0),('LCU',0,0,122,0,0,500,1100,955),('Tony',0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `bloodbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donor` (
  `Donor_ID` int(100) NOT NULL AUTO_INCREMENT,
  `Donor_Name` varchar(45) DEFAULT NULL,
  `Donor_Amount` int(100) DEFAULT '0',
  `Donor_BloodBank` varchar(20) DEFAULT NULL,
  `Donor_Number` int(12) DEFAULT NULL,
  `Donor_BType` varchar(45) DEFAULT 'A+',
  PRIMARY KEY (`Donor_ID`),
  KEY `Donor_BloodBank_idx` (`Donor_BloodBank`),
  CONSTRAINT `bloodbank` FOREIGN KEY (`Donor_BloodBank`) REFERENCES `bloodbank` (`BloodBank_Name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (2,'Elie',74,'AUB',250,'A+'),(3,'elie',50,'LAU',45353,'A+'),(4,'df',5,'AUB',324234,'A+'),(5,'dfwefew',50,'AUB',4534535,'O+'),(6,'jtyutyu',500,'LCU',4643563,'AB-'),(7,'test ',50,'LAU',56356356,'AB+'),(8,'test now 2',1000,'LCU',123456,'O-'),(123,'tony jabbour',1200,'LCU',159,'O+'),(124,'Elie Saad N',15,'AUB',65355656,'B+'),(125,'eddy',122,'LCU',999999,'B+');
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `Patient_ID` int(50) NOT NULL AUTO_INCREMENT,
  `Patient_FullName` varchar(45) DEFAULT NULL,
  `Patient_Info` varchar(100) DEFAULT NULL,
  `Patient_BloodBank` varchar(20) DEFAULT NULL,
  `Patient_Amount` int(100) DEFAULT '0',
  `Patient_BType` varchar(45) DEFAULT 'A+',
  PRIMARY KEY (`Patient_ID`),
  KEY `bank_idx` (`Patient_BloodBank`),
  CONSTRAINT `bank` FOREIGN KEY (`Patient_BloodBank`) REFERENCES `bloodbank` (`BloodBank_Name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (123,'tony jabbour','test		','HotelDieu',44,'A+'),(135,'Elio Jabbour','help','HotelDieu',70,'A+');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-04 18:47:21
