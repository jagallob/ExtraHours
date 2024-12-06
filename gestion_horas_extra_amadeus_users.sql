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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT 'empleado',
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role` (`role`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`id`) REFERENCES `employees` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_employee` FOREIGN KEY (`id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (123458,'maria.lopez@example.com','María Isabel López González','$2a$10$7pZKe7MXgwv35GPk7Jxc3etQ/EsS6Ao2cNNkBE.TfIcCmFeGO5KIS','superusuario','milgonzalez'),(123463,'laura.ortiz@example.com','Laura Marcela Ortiz Mejía','$2a$10$taE2aWyRLDkZ4/e3hwKyJ.NCENsvzii61cx7VVdCvG6NYN90wwvI2','empleado','lmortiz'),(123495,'antonio.salcedo.lópez@empresa.com','Antonio Salcedo López','$2a$10$QvT4ATwHMBvNLCDi9r2GGOlhFdu73xeAFAdevSf6jAxfo8YuRMWHq','empleado','antonio.salcedo.lópez'),(123744,'javier.gómez.quintero@empresa.com','Javier Gómez Quintero','$2a$10$1aGZyx5idc8rANlv/pNf7eVM1uTOTRUOTsWQZEheZ8zDjhufTbdH2','empleado','javier.gómez.quintero'),(123788,'camila.ruiz.hernández@empresa.com','Camila Ruiz Hernández','$2a$10$q13Tm3LWY/32c099jDtjZ.HRN8HwBbNH729.3PPPjJ83xoCKRvM/C','manager','camila.ruiz.hernández');
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

-- Dump completed on 2024-11-28  1:28:12
