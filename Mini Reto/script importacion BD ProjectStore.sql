-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecstore
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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `idalumno` char(36) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `dni` char(9) NOT NULL,
  `email` text NOT NULL,
  `password_encr` char(32) NOT NULL,
  `telefono` char(9) DEFAULT NULL,
  `genero` enum('M','F','NB') NOT NULL,
  `fechaNac` date DEFAULT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  `ciclo_actual` char(4) NOT NULL,
  PRIMARY KEY (`idalumno`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_alumnos_ciclos1_idx` (`ciclo_actual`),
  CONSTRAINT `fk_alumnos_ciclos1` FOREIGN KEY (`ciclo_actual`) REFERENCES `ciclos` (`codciclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES ('be6b279d-a5ab-11ef-b23d-b00cd1e6ac21','Carlos','Pérez García','12345678A','carlos.perez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600123456','M','2001-03-15',0,'DAM'),('be6c56a7-a5ab-11ef-b23d-b00cd1e6ac21','María','López Fernández','23456789B','maria.lopez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600234567','F','2002-07-22',1,'DAM'),('be6c5ab0-a5ab-11ef-b23d-b00cd1e6ac21','Jorge','Martínez Torres','34567890C','jorge.martinez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600345678','M','2003-12-05',1,'DAM'),('be6c5c0e-a5ab-11ef-b23d-b00cd1e6ac21','Laura','Sánchez Morales','45678901D','laura.sanchez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600456789','F','2000-05-10',0,'DAM'),('be6c5f3a-a5ab-11ef-b23d-b00cd1e6ac21','Luis','González Ruiz','56789012E','luis.gonzalez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600567890','M','2004-09-20',1,'DAM'),('be6c66e6-a5ab-11ef-b23d-b00cd1e6ac21','Carmen','Jiménez Vega','67890123F','carmen.jimenez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600678901','F','2002-11-30',1,'DAM'),('be6c685e-a5ab-11ef-b23d-b00cd1e6ac21','Pablo','Hernández Ortega','78901234G','pablo.hernandez@example.com','81dc9bdb52d04dc20036dbd8313ed055','600789012','M','2001-01-25',1,'DAW'),('be6c6961-a5ab-11ef-b23d-b00cd1e6ac21','Isabel','Ruiz Castro','89012345H','isabel.ruiz@example.com','81dc9bdb52d04dc20036dbd8313ed055','600890123','F','2003-06-18',1,'DAW');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclos`
--

DROP TABLE IF EXISTS `ciclos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclos` (
  `codciclo` char(4) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `etapa` enum('CFGM','CFGS','CE') NOT NULL DEFAULT 'CFGS',
  `titulo` text NOT NULL,
  `curriculo` text NOT NULL,
  `familia` enum('ADG','FME','IFC','TMA') NOT NULL DEFAULT 'IFC',
  PRIMARY KEY (`codciclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclos`
--

LOCK TABLES `ciclos` WRITE;
/*!40000 ALTER TABLE `ciclos` DISABLE KEYS */;
INSERT INTO `ciclos` VALUES ('ASIR','Administración de Sistemas Informáticos en Red','CFGS','RD 1629/2009','Orden ECD/72/2014','IFC'),('DAM','Desarrollo de Aplicaciones Multiplataforma','CFGS','RD 450/2010','Orden ECD/70/2014','IFC'),('DAW','Desarrollo de Aplicaciones Web','CFGS','RD 686/2010','Orden ECD/71/2014','IFC'),('PPFM','Programación de la Producción en Fabricación Mecánica','CFGS','RD 1750/2010','Orden ECD/73/2014','FME');
/*!40000 ALTER TABLE `ciclos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluan`
--

DROP TABLE IF EXISTS `evaluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calificacion_pers` float DEFAULT NULL,
  `comentario` text,
  `proyecto` int(11) NOT NULL,
  `profesor` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_evaluan_proyectos1_idx` (`proyecto`),
  KEY `fk_evaluan_profesores_idx` (`profesor`),
  CONSTRAINT `fk_evaluan_profesores` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`idprofesor`),
  CONSTRAINT `fk_evaluan_proyectos1` FOREIGN KEY (`proyecto`) REFERENCES `proyectos` (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluan`
--

LOCK TABLES `evaluan` WRITE;
/*!40000 ALTER TABLE `evaluan` DISABLE KEYS */;
INSERT INTO `evaluan` VALUES (1,8.5,'Buen uso de tecnologías y excelente presentación.',1,'e06fb832-a5a8-11ef-b23d-b00cd1e6ac21'),(2,9,'Trabajo destacado en diseño y usabilidad.',1,'e070c576-a5a8-11ef-b23d-b00cd1e6ac21'),(3,7.8,'Adecuado, pero con margen de mejora en documentación.',1,'e070cd36-a5a8-11ef-b23d-b00cd1e6ac21'),(4,8,'Buen enfoque y planificación del proyecto.',2,'e06fb832-a5a8-11ef-b23d-b00cd1e6ac21'),(5,8.7,'Trabajo consistente, gran integración de funcionalidades.',2,'e070c576-a5a8-11ef-b23d-b00cd1e6ac21'),(6,7.5,'Aspectos técnicos bien ejecutados, pero mejorar diseño.',2,'e070cd36-a5a8-11ef-b23d-b00cd1e6ac21');
/*!40000 ALTER TABLE `evaluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores` (
  `idprofesor` char(36) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `dni` char(9) NOT NULL,
  `email` text NOT NULL,
  `password_encr` char(32) NOT NULL,
  `telefono` char(9) DEFAULT NULL,
  `genero` enum('M','F','NB') NOT NULL,
  `fechaNac` date DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  `admin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idprofesor`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES ('e06fb832-a5a8-11ef-b23d-b00cd1e6ac21','Juan','Pérez López','39571234A','juan.perez@example.com','81dc9bdb52d04dc20036dbd8313ed055','698341274','M','1980-05-15','Informática',1,1),('e070c576-a5a8-11ef-b23d-b00cd1e6ac21','María','Gómez Fernández','58394172B','maria.gomez@example.com','81dc9bdb52d04dc20036dbd8313ed055','635214789','F','1982-03-22','Sistemas y Aplicaciones Informáticas',1,1),('e070ca6c-a5a8-11ef-b23d-b00cd1e6ac21','Pedro','López García','12857346C','pedro.lopez@example.com','81dc9bdb52d04dc20036dbd8313ed055','642389712','M','1978-07-10','Oficina de proyectos de fabricación mecánica',1,1),('e070cc22-a5a8-11ef-b23d-b00cd1e6ac21','Ana','Martínez Sánchez','84917563D','ana.martinez@example.com','81dc9bdb52d04dc20036dbd8313ed055','659841237','F','1990-09-25','Organización y Proyectos de Fabricación Mecánica',1,1),('e070cd36-a5a8-11ef-b23d-b00cd1e6ac21','Luis','García Torres','21358947E','luis.garcia@example.com','81dc9bdb52d04dc20036dbd8313ed055','637485921','M','1985-11-30','Informática',1,0),('e070ce6f-a5a8-11ef-b23d-b00cd1e6ac21','Carmen','Sánchez Morales','56981347F','carmen.sanchez@example.com','81dc9bdb52d04dc20036dbd8313ed055','628394715','F','1993-08-14','Sistemas y Aplicaciones Informáticas',1,0),('e070cfc6-a5a8-11ef-b23d-b00cd1e6ac21','Miguel','Fernández Ruiz','89543126G','miguel.fernandez@example.com','81dc9bdb52d04dc20036dbd8313ed055','691234875','M','1979-06-12','Oficina de proyectos de fabricación mecánica',1,0),('e070d11a-a5a8-11ef-b23d-b00cd1e6ac21','Sofía','Torres Jiménez','73928514H','sofia.torres@example.com','81dc9bdb52d04dc20036dbd8313ed055','679841253','F','1987-12-05','Organización y Proyectos de Fabricación Mecánica',1,0),('e070d21a-a5a8-11ef-b23d-b00cd1e6ac21','Raúl','Ruiz Castro','45829371I','raul.ruiz@example.com','81dc9bdb52d04dc20036dbd8313ed055','645837219','M','1991-01-20','Informática',1,0),('e070dd58-a5a8-11ef-b23d-b00cd1e6ac21','Isabel','Morales Gómez','39485712J','isabel.morales@example.com','81dc9bdb52d04dc20036dbd8313ed055','678492135','F','1983-03-15','Sistemas y Aplicaciones Informáticas',1,0),('e070deef-a5a8-11ef-b23d-b00cd1e6ac21','Carlos','Ortega Delgado','73958124K','carlos.ortega@example.com','81dc9bdb52d04dc20036dbd8313ed055','652398147','M','1989-05-11','Oficina de proyectos de fabricación mecánica',1,0),('e070dfe4-a5a8-11ef-b23d-b00cd1e6ac21','Laura','Vega Martínez','84325917L','laura.vega@example.com','81dc9bdb52d04dc20036dbd8313ed055','692341587','F','1992-07-30','Organización y Proyectos de Fabricación Mecánica',1,0),('e070e169-a5a8-11ef-b23d-b00cd1e6ac21','Jorge','Castro Ramos','12458397M','jorge.castro@example.com','81dc9bdb52d04dc20036dbd8313ed055','657389241','M','1986-10-17','Informática',0,0),('e070e28f-a5a8-11ef-b23d-b00cd1e6ac21','Beatriz','Navarro Herrera','73912584N','beatriz.navarro@example.com','81dc9bdb52d04dc20036dbd8313ed055','612398475','F','1994-04-09','Sistemas y Aplicaciones Informáticas',1,0),('e070e3ef-a5a8-11ef-b23d-b00cd1e6ac21','Francisco','Díaz Moreno','98543126O','francisco.diaz@example.com','81dc9bdb52d04dc20036dbd8313ed055','692481357','M','1981-02-28','Oficina de proyectos de fabricación mecánica',0,0),('e070e4dd-a5a8-11ef-b23d-b00cd1e6ac21','Marta','Jiménez Romero','84319257P','marta.jimenez@example.com','81dc9bdb52d04dc20036dbd8313ed055','674319258','F','1995-08-22','Organización y Proyectos de Fabricación Mecánica',1,0),('e070e603-a5a8-11ef-b23d-b00cd1e6ac21','Enrique','Aguilar Vargas','59234718Q','enrique.aguilar@example.com','81dc9bdb52d04dc20036dbd8313ed055','698321754','M','1984-09-12','Informática',1,0),('e070e75a-a5a8-11ef-b23d-b00cd1e6ac21','Cristina','Ramírez Ortiz','37592814R','cristina.ramirez@example.com','81dc9bdb52d04dc20036dbd8313ed055','634819257','F','1996-06-30','Sistemas y Aplicaciones Informáticas',1,0),('e070e843-a5a8-11ef-b23d-b00cd1e6ac21','Sergio','Romero Blanco','49385712S','sergio.romero@example.com','81dc9bdb52d04dc20036dbd8313ed055','629347815','M','1988-07-08','Oficina de proyectos de fabricación mecánica',1,0),('e070e96f-a5a8-11ef-b23d-b00cd1e6ac21','Lucía','Hernández Pérez','58123749T','lucia.hernandez@example.com','81dc9bdb52d04dc20036dbd8313ed055','678493215','F','1997-11-19','Organización y Proyectos de Fabricación Mecánica',1,0);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `tipo` enum('fin de ciclo','intermodular') NOT NULL DEFAULT 'fin de ciclo',
  `resumen` text,
  `anno_acad` int(11) NOT NULL,
  `fecha_pres` date DEFAULT NULL,
  `logo` text,
  `memoria` text,
  `archivos` text,
  `comentarios` text,
  `ciclo` char(4) NOT NULL,
  `tutor` char(36) DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  KEY `fk_proyectos_ciclos_idx` (`ciclo`),
  KEY `fk_proyectos_tutores_idx` (`tutor`),
  CONSTRAINT `fk_proyectos_ciclos` FOREIGN KEY (`ciclo`) REFERENCES `ciclos` (`codciclo`),
  CONSTRAINT `fk_proyectos_tutores` FOREIGN KEY (`tutor`) REFERENCES `profesores` (`idprofesor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'Gestión de Reservas Hoteleras','fin de ciclo','Aplicación multiplataforma para gestionar reservas hoteleras, integrando sincronización con servicios en línea y bases de datos locales.',2023,'2024-06-10','https://example.com/logo_reservas.png','https://example.com/memoria_reservas.pdf','https://example.com/archivos_reservas.zip','Excelente integración de funcionalidades, destacada en usabilidad.','DAM','e070e169-a5a8-11ef-b23d-b00cd1e6ac21'),(2,'Control de Inventarios','fin de ciclo','Sistema de control de inventarios desarrollado para pequeñas y medianas empresas, implementando seguimiento en tiempo real.',2023,'2024-06-10','https://example.com/logo_inventarios.png','https://example.com/memoria_inventarios.pdf','https://example.com/archivos_inventarios.zip','Proyecto muy completo, con un enfoque claro hacia la optimización de recursos.','DAM','e070e169-a5a8-11ef-b23d-b00cd1e6ac21'),(3,'Aplicación de Gestión de Tareas','fin de ciclo','Aplicación multiplataforma diseñada para la gestión de tareas y proyectos personales o grupales.',2023,NULL,NULL,NULL,NULL,NULL,'DAM','e070d21a-a5a8-11ef-b23d-b00cd1e6ac21'),(4,'Simulador de Aprendizaje de Idiomas','fin de ciclo','Herramienta educativa para aprender idiomas mediante ejercicios interactivos y gamificación.',2023,NULL,NULL,NULL,NULL,NULL,'DAM','e070d21a-a5a8-11ef-b23d-b00cd1e6ac21'),(5,'Aplicación para Gestión de Finanzas Personales','fin de ciclo','Aplicación enfocada en la organización y control de presupuestos personales, ingresos y gastos.',2023,NULL,NULL,NULL,NULL,NULL,'DAM','e070d21a-a5a8-11ef-b23d-b00cd1e6ac21'),(6,'E-commerce para Pequeñas Empresas','fin de ciclo','Plataforma web diseñada para ofrecer soluciones de comercio electrónico a pequeñas empresas.',2023,NULL,NULL,NULL,NULL,NULL,'DAW','e070e28f-a5a8-11ef-b23d-b00cd1e6ac21'),(7,'Portal de Noticias Personalizable','fin de ciclo','Portal web dinámico que permite a los usuarios personalizar el contenido según sus intereses.',2023,NULL,NULL,NULL,NULL,NULL,'DAW','e070e28f-a5a8-11ef-b23d-b00cd1e6ac21');
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realizan`
--

DROP TABLE IF EXISTS `realizan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `realizan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calificacion` int(11) DEFAULT NULL,
  `alumno` char(36) NOT NULL,
  `proyecto` int(11) NOT NULL,
  `comentario` text,
  PRIMARY KEY (`id`),
  KEY `fk_realizan_proyectos1_idx` (`proyecto`),
  KEY `fk_realizan_alumnos_idx` (`alumno`),
  CONSTRAINT `fk_realizan_alumnos` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`idalumno`),
  CONSTRAINT `fk_realizan_proyectos1` FOREIGN KEY (`proyecto`) REFERENCES `proyectos` (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realizan`
--

LOCK TABLES `realizan` WRITE;
/*!40000 ALTER TABLE `realizan` DISABLE KEYS */;
INSERT INTO `realizan` VALUES (1,6,'be6b279d-a5ab-11ef-b23d-b00cd1e6ac21',1,'Buen trabajo en la implementación y documentación.'),(2,8,'be6c5c0e-a5ab-11ef-b23d-b00cd1e6ac21',2,'Destacado en organización y trabajo en equipo.'),(3,NULL,'be6c685e-a5ab-11ef-b23d-b00cd1e6ac21',6,NULL),(4,NULL,'be6c6961-a5ab-11ef-b23d-b00cd1e6ac21',7,NULL),(5,NULL,'be6c56a7-a5ab-11ef-b23d-b00cd1e6ac21',5,NULL),(6,NULL,'be6c5ab0-a5ab-11ef-b23d-b00cd1e6ac21',4,NULL),(7,NULL,'be6c5f3a-a5ab-11ef-b23d-b00cd1e6ac21',3,NULL),(8,NULL,'be6c66e6-a5ab-11ef-b23d-b00cd1e6ac21',3,NULL);
/*!40000 ALTER TABLE `realizan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-18 15:29:10
