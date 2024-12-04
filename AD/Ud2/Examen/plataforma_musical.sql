-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: plat_mus_examen
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `descarga_totales`
--

DROP TABLE IF EXISTS `descarga_totales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descarga_totales` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `num_usuario` int(11) NOT NULL,
  `num_audio` int(11) NOT NULL,
  `total` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`num`),
  KEY `FK_video_descargas_totales_idx` (`num_audio`),
  KEY `FK_Usuario_descargas_totales_idx` (`num_usuario`),
  CONSTRAINT `FK_video_descargas_totales` FOREIGN KEY (`num_audio`) REFERENCES `tracks` (`num_track`),
  CONSTRAINT `fk_descargas_usuario` FOREIGN KEY (`num_usuario`) REFERENCES `usuarios` (`num_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descarga_totales`
--

LOCK TABLES `descarga_totales` WRITE;
/*!40000 ALTER TABLE `descarga_totales` DISABLE KEYS */;
INSERT INTO `descarga_totales` VALUES (1,1,5,6),(2,1,12,3),(3,1,11,1),(4,1,14,4),(5,1,7,2),(6,2,6,2),(7,8,2,5),(8,8,4,1),(9,8,7,1),(10,8,9,3),(11,4,3,1),(12,4,5,2),(13,4,8,4),(14,4,12,5),(15,6,9,1),(16,6,19,3),(17,6,1,5),(18,6,2,4),(19,6,7,1),(20,7,5,1),(21,9,18,2);
/*!40000 ALTER TABLE `descarga_totales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `audio` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `finalizada` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`num`),
  KEY `fk_solicitudes_audio_idx` (`audio`),
  KEY `fk_solicitudes_usuario_idx` (`usuario`),
  CONSTRAINT `fk_solicitudes_audio` FOREIGN KEY (`audio`) REFERENCES `tracks` (`num_track`),
  CONSTRAINT `fk_solicitudes_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`num_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=7680 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (7667,8,2,'2024-12-03','15:00:00',0),(7668,8,5,'2024-12-03','15:00:00',1),(7669,8,7,'2024-12-03','15:00:01',0),(7670,6,9,'2024-12-03','15:00:01',1),(7671,6,19,'2024-12-03','15:00:01',0),(7672,8,13,'2024-12-03','15:00:02',0),(7673,8,19,'2024-12-03','15:00:06',0),(7674,3,2,'2024-12-03','15:00:06',0),(7675,3,6,'2024-12-03','15:00:08',0),(7676,8,12,'2024-12-03','15:00:12',0),(7677,7,4,'2024-12-03','15:00:12',0),(7678,7,13,'2024-12-03','15:00:13',0),(7679,7,19,'2024-12-03','15:00:15',0);
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracks` (
  `num_track` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(70) DEFAULT NULL,
  `interprete` varchar(50) DEFAULT NULL,
  `dur_seg` int(11) DEFAULT '0',
  `anno` smallint(6) DEFAULT NULL,
  `num_descargas` smallint(6) DEFAULT '0',
  `disponible` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`num_track`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracks`
--

LOCK TABLES `tracks` WRITE;
/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
INSERT INTO `tracks` VALUES (1,'Thriller','Michael Jackson',823,1986,88,1),(2,'Another Brick on the Wall','Pink Floyd',361,1974,626,1),(3,'Money For Nothing','Dire Straits',300,1983,493,1),(4,'Take On Me','A-Ha',228,1992,590,0),(5,'Sledgehammer','Peter Gabriel',336,1997,468,1),(6,'Land of Confusion','Genesis',329,1991,572,1),(7,'Remember the Time','Michael Jackson',557,1995,457,1),(8,'November Rain','Guns N\'Roses',557,1991,571,1),(9,'Amazing','Aerosmith',410,1993,483,1),(10,'Heart Shaped Box','Nirvana',285,1992,701,1),(11,'Crazy','Aerosmith',376,1994,59,1),(12,'Love is Strong','The Rolling Stones',227,1986,190,1),(13,'Always','Bon Jovi',363,1996,776,0),(14,'Black Hole Sun','Soundgarden',321,2002,310,1),(15,'Tonight','The Smashing Pumpkins',260,1998,222,1),(16,'Where Are U Now','Skrillex and Diplo',252,2018,182,1),(17,'Chearleader (Felix Jaehn Remix)','OMI',199,2018,243,1),(18,'IDGAF','Dua Lipa',256,2018,670,1),(19,'Filthy','Justin Timberlake',303,2018,620,1),(20,'For You','Rita Ora & Liam Payne',275,2018,92,1);
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `num_usu` int(11) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `contra` varchar(18) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fechanac` date DEFAULT NULL,
  `num_descargas` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`num_usu`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'JenBalbon23','?sonaAdul509','Jennifer','Balbontin Diego','2004-09-18',4),(2,'IreRodr28','(arios118','Irene','Rodriguez Cavia','1999-06-16',0),(3,'DSeno25','&rson286','Daniel','Senosiain Hoyos','1992-12-19',19),(4,'PaSanz C85','|eInt60','Pablo','Sanz Campo','1995-09-21',16),(5,'LSerra96','¬atric415','Luis Manuel','Serrano Ceballos','1997-02-11',0),(6,'AleCarre06','#ers123','Alejandro','Carrera Ruiz','1995-12-04',30),(7,'RaReigad67','&esDe427','Raul','Reigadas Fonfria','2006-04-25',23),(8,'DaBenit74','&emaDeF51','David','Benito Almeida','2000-10-16',23),(9,'MGuti04','¬doAPe871','Maria','Gutierrez Castañeda','1994-07-02',9),(10,'MaPlaz50','/atricul492','Maria Carmen','Plaza Briz','1997-01-07',5),(11,'SArce07',')rigidoAP208','Samuel','Arce Samoila','1994-03-09',7),(12,'AGonzal26','/Adultas.913','Asier','Gonzalez Solana','1996-12-05',9),(13,'FrMarti15','|rma130','Francisco Jose','Martinez Gandarillas','1992-01-25',0),(14,'JuUria56','+laMent744','Juan Manuel','Uria Calvo','1996-09-07',0),(15,'MDel A26','!ularse183','Marta','Del Amo Herrero','2001-03-31',19);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-02 12:17:15
