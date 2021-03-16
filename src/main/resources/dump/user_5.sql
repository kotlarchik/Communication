-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 192.168.1.102    Database: user_5
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

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
-- Table structure for table `abonent`
--

DROP TABLE IF EXISTS `abonent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` int NOT NULL,
  `address` varchar(45) NOT NULL,
  `inn` int NOT NULL,
  `cities_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_abonent_cities1_idx` (`cities_id`),
  CONSTRAINT `fk_abonent_cities1` FOREIGN KEY (`cities_id`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonent`
--

LOCK TABLES `abonent` WRITE;
/*!40000 ALTER TABLE `abonent` DISABLE KEYS */;
/*!40000 ALTER TABLE `abonent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abonent_has_phonecall`
--

DROP TABLE IF EXISTS `abonent_has_phonecall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonent_has_phonecall` (
  `abonent_id` int NOT NULL,
  `phonecall_id` int NOT NULL,
  PRIMARY KEY (`abonent_id`,`phonecall_id`),
  KEY `fk_abonent_has_phonecall_phonecall1_idx` (`phonecall_id`),
  KEY `fk_abonent_has_phonecall_abonent_idx` (`abonent_id`),
  CONSTRAINT `fk_abonent_has_phonecall_abonent` FOREIGN KEY (`abonent_id`) REFERENCES `abonent` (`id`),
  CONSTRAINT `fk_abonent_has_phonecall_phonecall1` FOREIGN KEY (`phonecall_id`) REFERENCES `phonecall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonent_has_phonecall`
--

LOCK TABLES `abonent_has_phonecall` WRITE;
/*!40000 ALTER TABLE `abonent_has_phonecall` DISABLE KEYS */;
/*!40000 ALTER TABLE `abonent_has_phonecall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `rate_day` varchar(45) NOT NULL,
  `rate_night` varchar(45) NOT NULL,
  `image_path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Павлово','250','450','image/image1.png'),(2,'Новосибирск','400','650','image/image2.png');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonecall`
--

DROP TABLE IF EXISTS `phonecall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonecall` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `minutes` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonecall`
--

LOCK TABLES `phonecall` WRITE;
/*!40000 ALTER TABLE `phonecall` DISABLE KEYS */;
/*!40000 ALTER TABLE `phonecall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-16 16:09:11
