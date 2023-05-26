-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitals
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `diseases_names`
--

DROP TABLE IF EXISTS `diseases_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseases_names` (
  `ID` varchar(45) NOT NULL,
  `DISEASE_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseases_names`
--

LOCK TABLES `diseases_names` WRITE;
/*!40000 ALTER TABLE `diseases_names` DISABLE KEYS */;
INSERT INTO `diseases_names` VALUES ('1','ANC'),('10','RINGWORM'),('11','OTHER'),('12','ORTHOPEDIC'),('2','DENTAL CHECK UP'),('3','FEVER'),('4','COUGH'),('5','PAIN'),('6','LOOSE MOTIONS,VOMITING'),('7','MLC'),('8','WOUND'),('9','ITCHING');
/*!40000 ALTER TABLE `diseases_names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctordetails`
--

DROP TABLE IF EXISTS `doctordetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctordetails` (
  `doctorid` int NOT NULL AUTO_INCREMENT,
  `doctorname` varchar(45) NOT NULL,
  `mobileNo` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`doctorid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctordetails`
--

LOCK TABLES `doctordetails` WRITE;
/*!40000 ALTER TABLE `doctordetails` DISABLE KEYS */;
INSERT INTO `doctordetails` VALUES (1,'Dr. D.C. Arya','NA','NA'),(2,'Dr. Bhawani Singh','NA','NA'),(3,'Dr. Premlata Kushwah','NA','NA'),(4,'Dr. Dev Dutt Jha','NA','NA'),(5,'Dr.  Ankit Rajpoot ','7898311713','Gayaprashad Rajpoot');
/*!40000 ALTER TABLE `doctordetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_login`
--

DROP TABLE IF EXISTS `hospital_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_login` (
  `LOGINID` varchar(45) NOT NULL,
  `PASSWORD` varchar(120) NOT NULL,
  `MOBILE_NO` varchar(45) NOT NULL,
  `ROLE` varchar(45) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  PRIMARY KEY (`LOGINID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_login`
--

LOCK TABLES `hospital_login` WRITE;
/*!40000 ALTER TABLE `hospital_login` DISABLE KEYS */;
INSERT INTO `hospital_login` VALUES ('hospital@gmail.com','$2a$10$DcLFC6l9o3520cvegJnE9eAkjRLeuBgQaNDgOj9y9N8mnkZ57c2vi','7898311713','ADMIN','0'),('hospital1@gmail.com','$2a$10$0N9DSFNEtfNXL00Q2/.Vf.sefcRIw6W9uey8kve7ikNf7nqry8m4O','8319513178','ADMIN','0'),('superadmin@gmail.com','$2a$10$0N9DSFNEtfNXL00Q2/.Vf.sefcRIw6W9uey8kve7ikNf7nqry8m4O','7898311713','SUPERADMIN','0');
/*!40000 ALTER TABLE `hospital_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newregistration`
--

DROP TABLE IF EXISTS `newregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newregistration` (
  `REGIS_NUMBER` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `FNAME` varchar(45) NOT NULL,
  `REGISRATION_DATE` datetime NOT NULL,
  `MOBILENO` varchar(45) DEFAULT NULL,
  `AGE` varchar(45) DEFAULT NULL,
  `GENDER` varchar(45) NOT NULL,
  `CAST` varchar(45) DEFAULT NULL,
  `SCHEME` varchar(45) DEFAULT NULL,
  `DOCTORS` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `REFER` varchar(45) DEFAULT NULL,
  `ROOMNO` varchar(45) DEFAULT NULL,
  `PATIENTDISEASES` varchar(500) DEFAULT NULL,
  `VALIDTILL` datetime DEFAULT NULL,
  `ENTRYBY` varchar(45) DEFAULT NULL,
  `AADHARNUMBER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`REGIS_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newregistration`
--

LOCK TABLES `newregistration` WRITE;
/*!40000 ALTER TABLE `newregistration` DISABLE KEYS */;
INSERT INTO `newregistration` VALUES ('1','ankit ','gaya','2023-05-07 23:57:07','789831713','27','MALE','OBC','APL ₹ 5.00','Dr. D.C. Arya','asdfa','asdf','Room No.1','ANC','2023-05-14 23:57:07','hospital1@gmail.com',NULL),('10','Harsh','dinesh','2023-05-21 20:31:04','','14','MALE','GENERAL','Below Poverty Line ₹ 0.00','Dr. Bhawani Singh','asdfasf','sadfas','Room No.1','OTHER,ANC','2023-05-28 20:31:04','hospital1@gmail.com','NA'),('2','test','test','2023-05-08 00:00:52','','23','MALE','GENERAL','Below Poverty Line ₹ 0.00','Dr. D.C. Arya','asfafd','','Room No.1','ANC','2023-05-15 00:00:52','hospital1@gmail.com',NULL),('3','test','asdf','2023-05-20 13:46:45','','26','MALE','GENERAL','APL ₹ 5.00','Dr. D.C. Arya','asdfa','fsd','Room No.1','ANC,ORTHOPEDIC,RINGWORM','2023-05-27 13:46:45','hospital1@gmail.com','0'),('4','adsf','asdfasf','2023-05-20 14:06:34','','36','MALE','GENERAL','Disabled >60% ₹ 0.00','Dr. Bhawani Singh','asdf','dasfa','Room No.1','OTHER,FEVER','2023-05-27 14:06:34','hospital1@gmail.com','NA'),('6','fasdd','adsfa','2023-05-20 14:30:55','','323','MALE','GENERAL','ANC ₹ 0.00','Dr. D.C. Arya','asdfas','asdf','Room No.1','RINGWORM','2023-05-27 14:30:55','hospital1@gmail.com','NA'),('7','sadfas','asdfas','2023-05-20 14:41:07','','23','MALE','GENERAL','APL ₹ 5.00','Dr. D.C. Arya','asdfsf','sadfa','Room No.1','ANC,OTHER','2023-05-27 14:41:07','hospital1@gmail.com','457260520263'),('8','sdaf','adsfa','2023-05-21 18:25:45','','23','MALE','GENERAL','ANC ₹ 0.00','Dr. D.C. Arya','adsfasf','asdfa','Room No.1','RINGWORM,ANC','2023-05-28 18:25:45','hospital1@gmail.com','457260520263'),('9','ankit rajpoot','Gayaprashad','2023-05-21 20:27:41','7898311713','26','MALE','GENERAL','FREEDOM FIGHTER ₹ 0.00','Dr. D.C. Arya','Gwalior','Birla Hospital','Room No.1','RINGWORM,OTHER','2023-05-28 20:27:41','hospital1@gmail.com','457260520263');
/*!40000 ALTER TABLE `newregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_revisit`
--

DROP TABLE IF EXISTS `patient_revisit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_revisit` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DISEASES` varchar(500) NOT NULL,
  `REVISITDATE` datetime NOT NULL,
  `REGIS_NUMBER` varchar(45) NOT NULL,
  `DOCTORS` varchar(45) NOT NULL,
  `REFER` varchar(45) DEFAULT NULL,
  `ROOMNO` varchar(45) NOT NULL,
  `ENTRYBY` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_revisit`
--

LOCK TABLES `patient_revisit` WRITE;
/*!40000 ALTER TABLE `patient_revisit` DISABLE KEYS */;
INSERT INTO `patient_revisit` VALUES (1,'ANC,OTHER','2023-05-20 15:13:12','7','Dr. D.C. Arya','sadfa','Room No.1','hospital1@gmail.com'),(2,'ANC,OTHER,ORTHOPEDIC','2023-05-20 15:26:33','7','Dr. D.C. Arya','sadfa','Room No.1','hospital1@gmail.com'),(3,'ANC,OTHER','2023-05-20 16:00:52','7','Dr. D.C. Arya','sadfa','Room No.1','hospital1@gmail.com'),(4,'ANC,OTHER','2023-05-20 16:03:02','7','Dr. D.C. Arya','sadfa','Room No.1','hospital1@gmail.com'),(5,'ANC,OTHER','2023-05-21 16:57:49','7','Dr. D.C. Arya','sadfafadsf','Room No.1','hospital1@gmail.com'),(6,'RINGWORM,OTHER,ANC','2023-05-21 20:29:49','9','Dr. Bhawani Singh','Birla Hospital','Room No.1','hospital1@gmail.com');
/*!40000 ALTER TABLE `patient_revisit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_no_auto`
--

DROP TABLE IF EXISTS `registration_no_auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration_no_auto` (
  `YEAR` varchar(20) NOT NULL,
  `COUNT` varchar(45) NOT NULL,
  PRIMARY KEY (`YEAR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_no_auto`
--

LOCK TABLES `registration_no_auto` WRITE;
/*!40000 ALTER TABLE `registration_no_auto` DISABLE KEYS */;
INSERT INTO `registration_no_auto` VALUES ('2022','22'),('2023','11');
/*!40000 ALTER TABLE `registration_no_auto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  8:33:18
