-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion_horas_extra_amadeus
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `extra_hours`
--

DROP TABLE IF EXISTS `extra_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_hours` (
  `registry` bigint NOT NULL AUTO_INCREMENT,
  `id` bigint NOT NULL,
  `date` date DEFAULT NULL,
  `diurnal` double DEFAULT NULL,
  `nocturnal` double DEFAULT NULL,
  `observations` varchar(255) DEFAULT NULL,
  `diurnal_holiday` double DEFAULT NULL,
  `end_time` time(6) DEFAULT NULL,
  `extras_hours` double DEFAULT NULL,
  `nocturnal_holiday` double DEFAULT NULL,
  `start_time` time(6) DEFAULT NULL,
  `approved` bit(1) NOT NULL,
  `week` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`registry`),
  KEY `fk_extra_hours_employee_id` (`id`),
  CONSTRAINT `fk_extra_hours_employee_id` FOREIGN KEY (`id`) REFERENCES `employees` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_hours`
--

LOCK TABLES `extra_hours` WRITE;
/*!40000 ALTER TABLE `extra_hours` DISABLE KEYS */;
INSERT INTO `extra_hours` VALUES (6,123458,'2024-10-24',0.25,1.75,'Prueba',0,'22:45:00.000000',2,0,'20:45:00.000000',_binary '',NULL,NULL),(14,123463,'2024-11-17',0,0,'Ajustar conteo',1.18,'07:51:00.000000',1.18,0,'06:40:00.000000',_binary '',NULL,NULL),(15,123463,'2024-11-17',0,0,'Ajustes',0,'04:56:00.000000',2,2,'02:56:00.000000',_binary '\0',NULL,NULL),(22,123463,'2024-11-18',3.22,2.8,'Prueba límite horas',0,'09:13:00.000000',6.02,0,'03:12:00.000000',_binary '',NULL,NULL),(23,123463,'2024-11-20',3.22,2.78,'Prueba límite horas',0,'09:13:00.000000',6,0,'03:13:00.000000',_binary '',NULL,NULL),(24,123463,'2024-11-22',2.22,2.78,'Prueba límite horas',0,'08:13:00.000000',5,0,'03:13:00.000000',_binary '',NULL,NULL),(25,123463,'2024-11-19',2,0,'Trabajo adicional',0,'18:46:00.000000',2,0,'16:46:00.000000',_binary '\0',NULL,NULL),(26,123463,'2024-11-18',3.35,1.8,'Prueba limites',0,'22:48:00.000000',5.15,0,'17:39:00.000000',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `extra_hours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-28  1:28:12
