-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: concursomusica
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canciones` (
  `numCancion` int(11) NOT NULL AUTO_INCREMENT,
  `grupo` int(11) NOT NULL,
  `duracion` time NOT NULL,
  `titulo` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `total_votos` int(11) DEFAULT '0',
  PRIMARY KEY (`numCancion`),
  KEY `fk_cancion_grupo` (`grupo`),
  CONSTRAINT `fk_cancion_grupo` FOREIGN KEY (`grupo`) REFERENCES `grupos` (`codgrupo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (1,1,'00:03:56','Cancion de cuna',8),(2,1,'00:02:57','Cientos y cientos',6),(3,1,'00:02:28','Un sueño',7),(4,1,'00:03:32','Jovenes',4),(5,2,'00:02:44','No gires',6),(6,2,'00:03:42','Calor',1),(7,2,'00:03:37','Ritual',3),(8,2,'00:02:39','Radioactivo',3),(9,5,'00:05:07','La mujer de verde',3),(10,5,'00:04:01','Qué bien',6),(11,5,'00:03:53','Copacabana',1),(12,5,'00:04:47','Pequeña Gran Revolución',4),(13,3,'00:04:06','Distintos',2),(14,3,'00:04:21','Mejor opción',4),(15,3,'00:03:55','Atraco',8),(16,3,'00:04:27','Un espectro más',2),(17,9,'00:03:10','Accederas',1),(18,7,'00:03:58','Qué electricidad',4),(19,7,'00:03:29','Perseide',2),(20,7,'00:03:42','Groenlandia',10),(21,7,'00:03:47','Monteperdido',0),(22,4,'00:04:06','Ballet Mental',5),(23,4,'00:04:23','Aquitania',3),(24,4,'00:03:34','Te deslizas',4),(25,4,'00:03:53','Turistas Heridos',10),(26,10,'00:04:30','Rincón exquisito',3),(27,10,'00:04:53','Primera Vez',2),(28,10,'00:05:02','Nivel Inexperto',2),(29,10,'00:06:03','Más Suerte',1),(30,6,'00:05:40','Zona vip',4),(31,6,'00:06:20','Diferentes',4),(32,6,'00:07:30','Tu primero',1),(33,11,'00:02:47','Oso Panda',2),(34,13,'00:03:29','Emborracharme',3),(35,13,'00:03:34','Mi Realidad',1),(36,15,'00:03:32','Palos y piedras',3),(37,15,'00:06:45','Bien por ti',4),(38,14,'00:02:27','Cigarettes',3),(39,14,'00:05:08','Just Like A Wall',1),(40,18,'00:03:12','Autocritica',1),(41,18,'00:03:22','Salvese quien Pueda',1),(42,18,'00:04:01','Copenhague',3),(43,18,'00:02:36','Al Respirar',3),(44,12,'00:04:23','El hombre bolígrafo',2),(45,12,'00:04:36','Polaroid',3),(46,12,'00:03:52','Aspiradora Espacial',0),(47,11,'00:02:46','La chica Vampira',1),(48,17,'00:04:40','Deli',1),(49,17,'00:03:50','Real Love',0),(50,17,'00:04:33','Stay Close',2),(51,17,'00:04:27','Seasun',1),(52,13,'00:05:12','Evolucion',1),(53,13,'00:04:01','El Tiempo Pasará',3),(54,16,'00:02:23','Bailando',3),(55,16,'00:03:41','Todo nos parece una mierda',1),(56,19,'00:04:17','Luz Artificial',4),(57,19,'00:06:33','Melodrama',2),(58,19,'00:03:11','Que Vienen',0),(59,20,'00:04:18','How to Turn Rivers into Alluminium Foil',1),(60,20,'00:04:01','8:24',0),(61,20,'00:05:23','Clouds Factory',4),(62,21,'00:03:15','Hallo',2),(63,21,'00:03:25','Con mi voz',2),(64,22,'00:03:42','El mundo se va a acabar',1),(65,22,'00:03:21','Titubeas',0),(66,23,'00:02:54','Las flores',2),(67,23,'00:04:21','Martes',5),(68,23,'00:05:25','La Divina Señal',2);
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentes` (
  `idComp` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `alias` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `funcion` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `grupo` int(11) NOT NULL,
  PRIMARY KEY (`idComp`),
  KEY `fk_componente_grupo` (`grupo`),
  CONSTRAINT `fk_componente_grupo` FOREIGN KEY (`grupo`) REFERENCES `grupos` (`codgrupo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES (1,'Javi','Fernandez',NULL,'Voz, piano, guitarra',4),(2,'Jordi ','Navarro',NULL,'Guitarra y electrónica',4),(3,'Guille','Mostaza',NULL,'Voz y guitarra',6),(4,'Santi ','Capote',NULL,'Bajo',6),(5,'Gorka ','Dresbaj',NULL,'Guitarra y electrónica',4),(6,'José ','Tejedor ',NULL,'Bajo',4),(7,'Sel ',' Lee',NULL,'Bateria',4),(8,'Javier','Valencia',NULL,'Vocalista',3),(9,'Jesús','Gutiérrez',NULL,'Bajo',3),(10,'Jaime','Gutiérrez',NULL,'Bateria',3),(11,'Manu','Jurado',NULL,'Teclado',3),(12,'Enrique','Sanchís','Bubby','Guitarra',3),(14,'Fran','Gomez',NULL,'Vocalista',9),(33,'Alejandro ','Méndez',NULL,'Guitarra',13),(39,'Sean','Frutos',NULL,'Vocalista',10),(40,'Jorge','Guirao',NULL,'Guitarra',10),(41,'Javier','Vox','Javi','Guitarra y teclado',10),(42,'Fernando','Robles','Nando','Bajo',10),(43,'Francisco','Guirao','Fran','Batería',10),(44,'Óscar','Ferrer',NULL,'Vocalista',2),(45,'Aarön','Sáez',NULL,'Guitarra y teclados',2),(46,'Vicente','Llescas',NULL,'Guitarra',2),(52,'Antonio','Lomas',NULL,'Percusión',13),(53,'Miguel ','López',NULL,'Bajo Electrico',13),(54,'Alfredo','Nuñez',NULL,'Batería',13),(55,'Mikel','Izal',NULL,'Vocalista',5),(56,'Alejandro','Jordá',NULL,'Bateria',5),(57,'Emanuel','Perez',NULL,'Bajo eléctrico',5),(58,'Alberto','Perez',NULL,'Guitarra',5),(59,'Ivan','Mella',NULL,'Teclado',5),(60,'Amancay','Gaztañaga',NULL,'Vocalista',12),(61,'Eñaut','Gaztañaga',NULL,'Voz y guitarra',12),(62,'Raúl','Olaizola',NULL,'Bajo',12),(64,'Antonio','Diniz',NULL,'Batería',12),(65,'Alejandro','Orbegozo',NULL,'Sintetizadores',12),(66,'Michael','Martin',NULL,'Guitarra',13),(67,'Antonio','Lopez',NULL,'Guitarra',13),(70,'Arbona','Orero','Adria','Vocalista',11),(71,'Fandos','Berenguer','Julia','Vocalista',11),(72,'Huerta','Plaza','Oscar','Guitarra',11),(73,'Montoya','Barbera','Sonia','Bajo',11),(80,'Chuso','Ruiz','Chusi','Guitarra y coros',9),(81,'Rafa','Val',NULL,'Vocalista',15),(82,'Jess ','Fabric',NULL,'Bajo',15),(83,'Alberto ','Cantúa',NULL,'Guitarra',15),(84,'Fernando ','Campillo',NULL,'Bateria',15),(88,'Oliver','Ruiz',NULL,'Bateria',9),(89,'Lourdes','Hernandez','Russian Red','Voz y guitarra',14),(90,'Juan Pedro','Marti','pucho','Vocalista',18),(91,'Igor ','Escudero',NULL,'Guitarra',17),(92,'Guillermo','Astrain',NULL,'Bateria',17),(93,'Unai','Lazcano',NULL,'Bajo',17),(94,'Ekhi','Lopetegui',NULL,'Vocalista',17),(95,'David','Garcia','El Indio','Bateria Coros',18),(96,'Alvaro','Baglietto',NULL,'Bajo',18),(97,'Jorge','Gonzalez',NULL,'Percusion',18),(98,'Guillermo','Galvan',NULL,'Guitarra',18),(99,'Carlos ','Sadness',NULL,'Voz y guitarra',7),(101,'Manolo','Martínez','Lolo','Voz, guitarra y teclados',16),(102,'Genís','Segarra','Sega','Teclados, sintetizadores ',16),(103,'Victor','Cabezuelo',NULL,'Vocalista',20),(104,'Carlos ','Campos',NULL,'Guitarra',20),(105,'Julia','Martín',NULL,'Batería ',20),(106,'Sara','Oliveira',NULL,'Bajo',20),(107,'Alexander','Rusev',NULL,'Vocalista',19),(108,'Fab','Diaz',NULL,'Bajista',19),(109,'Edu','Argumosa',NULL,'Guitarrista',19),(110,'Deiv','Karanets',NULL,'Bateria',19),(111,'María','Blanco',NULL,'Voz y guitarra',21),(112,'Txarlie','Solano',NULL,'Bajo, teclados, coros',21),(113,'César','Uña',NULL,'Batería',21),(114,'Mar','Álvarez',NULL,'Vocalista',22),(115,'Alicia','Álvarez',NULL,'Bateria',22),(116,'Marina','Iñesta',NULL,'Voz y guitarra',23),(117,'Teresa','Iñesta',NULL,'Batería',23),(118,'Diego','García',NULL,'Bajo eléctrico',23);
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `codgrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `localidad` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `estilo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `esgrupo` tinyint(1) NOT NULL DEFAULT '1',
  `annoGrab` int(4) DEFAULT NULL,
  `fechaEstreno` date DEFAULT NULL,
  `compania` varchar(35) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codgrupo`),
  KEY `indice_localidad_grupo` (`localidad`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'Correos','San Sebastián','Indie',1,2009,'2009-01-01','Neo Music Box'),(2,'Varry Brava','Murcia','Pop',1,2005,'2009-02-21','Hook Management'),(3,'FULL','Sevilla','Indie',1,2003,'2009-11-28','Warner Music Spain'),(4,'Cyan','Barcelona','Pop Rock',1,2008,'2008-12-01','BMG'),(5,'IZAL','Madrid','Indie',1,2010,'2015-03-26','Hook Ediciones Musicales'),(6,'Ellos','Madrid','Indie',1,2002,'2002-04-27','Subterfuge records'),(7,'Carlos Sadness','Barcelona','Pop',0,2011,'2011-03-05','Sony Music'),(9,'The noises','Madrid','Pop Rock',1,2010,'2010-02-14','Warner Music'),(10,'Second','Murcia','Indie rock',1,2000,'1997-01-27','DRO Atlantic'),(11,'Papa topo','Mallorca','Indie rock',1,2008,'2008-06-23','Elefant records'),(12,'Grises','Cestona','Indie',1,2009,'2009-10-15','Origami Records'),(13,'Lori Meyers','Loja','Indie',1,2004,'2004-02-15','Fernando Vacas'),(14,'Russian Red','Madrid','Indie Pop',0,2008,'2008-06-20',' Fernando Vacas'),(15,'Viva Suecia','Murcia','Indie',1,2014,'2013-01-01','Paco Román '),(16,'Astrud','Barcelona','Pop',1,1999,'1999-11-20',NULL),(17,'Delorean','Zarauz','Indie pop',1,2000,'2001-09-27','Sony Music'),(18,'Vetusta Morla','Madrid','Indie-Rock',1,2000,'2000-03-02','Pequeño Salto Mortal'),(19,'Kitai','Madrid','Indie',1,2011,'2011-12-02','Remnant Light Studio'),(20,'Rufus T. Firefly','Madrid','Rock alternativo',1,2006,'2006-05-07','Lago naranja records'),(21,'Mäbu','Bilbao','Pop-Rock-Indie-Folk',1,2009,'2010-06-01','Warner Music Group'),(22,'Pauline en la Playa','Gijón','Pop',1,1997,'1997-08-05','Subterfuge Records'),(23,'Repion','Camargo','pop-rock alternativo',1,2014,'2013-11-20',NULL),(24,'Annie B Sweet','Málaga','Indie-Pop-Folk',0,2009,'2008-02-21','Subterfuge Records'),(25,'La Casa Azul','Barcelona','Indie-Pop Electr.',0,2000,'1999-08-29','Elefant Records');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `user` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(32) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fechanac` date DEFAULT NULL,
  `numvotos` int(11) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('02Ana','f547f0213884e47059f0532cfb7b487a','Ana','García Herrero','1999-02-06',13),('02Elsa','843b683bf1595acbec44625fa9ddae8a','Elsa','Frutos Núñez','1989-02-23',11),('02Eva','4a8ae230f04a9a2654c23d44ab735e5f','Eva','Alvarez Martinez','1991-08-04',3),('02Pedro','39ff4c11837a042e9ae9643b32effffd','Pedro','Pancorvo Hidalgo','1996-03-03',0),('03ez','cdaee254fb7b83270a4b9d685a98b721','Francisco','Freire Alonso','1993-07-25',2),('03lemon','7352ff5b4fec51fb68a6396441dcfb56','Arturo','Abrines salas','1993-07-25',2),('03pz','44ff4701208b0fcf888962d67f6d3b7f','Sean','Matthews','1993-07-25',2),('03squeezy','8f18a704b30d520ea4aa5fd0c659b4c4','Sonia','Rey Ortega','1993-07-25',1),('04CarlosLa','cc01164c660a136bcc638004d8ad2e4b','Carlos','Labra Mora','1996-02-10',0),('05User2','841bcdd84b26f32c507e12b74b6c28fa','Carla','Anton Martinez','1996-12-09',2),('05User3','b54ec2d5736bada5fca61b35fc5be640','Jonathan','Leon Suárez','1996-03-05',1),('05User4','294f236f3e522a908c525372ac0d6830','Alfredo','Marco Roura','1993-08-30',0),('10agallas','13fcf26f52485e878b24c213b2e64c90','Ágata','Cortés Valverde','1997-01-08',0),('10asdffgh','b5467fe2156ee823cad4284d2e540178','Asumta','Serra Muntaner','1992-12-12',0),('10elchupacabras','7af0b590a0c557963f68b3afa813ae1b','Yolanda','Martínez Fernández','1992-12-12',0),('10messy10','b8914b921d6b3821a75457a658a49236','Laura','Gómez Cuenca','1990-01-15',0),('10qwert','63eeaa4ca6e20fec38f80853d944148f','Esteban','Rodríguez Santiago','1990-12-12',0),('11Epami','48db4ac24cbbd9bb614086b0a37cafbc','María','Labrador Revuelta','2016-01-12',4),('11Eustaquio','4b72f236238c195bab0576b4c92df3c1','Eustaquio','García García','1990-01-08',3),('11Fernando','ff54f1f60f352d05af42caa8f4bfabf3','Fernando','Fernández Huidobro','1997-01-09',0),('11Jorge','acfe7abc161a46c7a7f4ad27863509db','Jorge','Diez Gil','1996-01-07',0),('13Antonio','e8cb202890f5be032b34d3e3df8efeaf','Antonio','Fernandez Montes','1992-05-05',0),('13Carlota','5947ad0cacd25041544def391c39e209','Carlota','Revuelta Herrero','1994-05-05',1),('13Concepcion','6c8c1aa897fbc804ad30c8cd12571cb0','Concepcion','Cano Higuera','1980-05-18',2),('13LourHerna','d9fc71a911eeabbbcc000542dbb55ab4','Lourdes ','Hernández González','1995-11-20',3),('13Lucia','3c656b9550c332524b827172a47c333b','Lucia','Calderón García','1993-05-25',3),('16Ana','e0d4ca35f46d3382df7a8e0a41b93a6c','Ana Patricia','Fernandez González','1999-05-12',1),('16Carlos','0938aa921713474782108ab9c06ef214','Carlos','Labrador Amieva','1996-07-08',3),('16Victor','57c5af8bd99f6bcac8d3cc53c5dee829','Victor','Bolado Suárez','1996-01-09',2),('16Yeray','5c0f1d73ca1cd51c238bee7cb7b0583f','Yeray','Peña Sisniega','1996-09-11',0),('17Campillo','8f04d51704e3f4795436b1f6976e3963','Fernando ','Campillo Jiménez','1990-07-25',0),('17Cantua','424410672d762d92eb380cf308d34386','Alberto ','Cantúa Vitienes','1990-12-12',1),('17Fabric','f8fe3d5c5028f1e35c7dd6f00ce191ac','Joshua','Benítez Díaz','1990-03-11',2),('17Val','597ac7f72042dc70afb11e45bef72a83','Rafael','Val Mora','1990-05-03',4),('18Dana','dc1abaa9273a13843858ceec7d052d51','Diana','Marín Lavín','1996-02-01',1),('18Gama','b2a3210dded5e51a9ac57dea9d6931f0','Gema','López Villegas','1982-09-09',1),('18Rana','1ca3f755f1213865bc97d5b55b0345de','Raquel','Martín Alba','1988-04-04',1),('18Wala','83ca9bff4b8c0357966e0903792f9937','Guillermo','Ruíz Antolín','1992-03-03',1),('19Carls','24aa140fea23bad3554989a87143b862','Carla','Bueno Martinez','1996-09-12',1),('19Fresh','3403141a2675eb261272167d8beedb83','Alfredo','Ortega Fernández','1993-08-28',3),('19Joni','5e0023b1492915f4fee5415d10a8406b','Jonathan','Moreno Lorenzo','1996-03-05',0),('19Toñin','a56fdca29f5be52d73af7e80587af30e','Antonio','Gracia Saiz','1992-04-05',2),('20Alberto','2a97cb9ae40c655f416f895c5222ea58','Alberto','Martínez Crespo','1997-07-16',3),('20Ana','c9baaf75f712566d45d6378d2dc2ab15','Ana','Ruiz Abascal','1989-01-02',2),('20Juan','f376256ba0f63b7251ca994d08306711','Juan','Rodríguez Ortiz','1995-08-28',0),('20Luis','e74db70f1a47132075143d3c1f99c63a','Luis','López Cobo','1990-12-08',1),('21Arm','90d60f1a743649502bc7e730f1dc0fc0','Armando','Blanco Diego','1968-02-26',0),('21booom','cab3089229992a3109e38e514d739613','Blanca','Morales Alonso','1980-02-01',0),('21Byron','231ad5da994fb710a82b478b875f9bb6','Byron','Ortiz Martín','1995-07-16',5),('21meko','70a5c224e7d8f4ad20a5a66fcae73d02','Marta','Saiz Álvarez','1990-02-03',1),('22Adolf','497c33e9484d4146ad2c8f2e10c689c0','Adolfo','Dìez Cobo','1975-07-19',3),('22Eustaquio','490fa372b57a1391c9cf7e43b62b022d','Sara','Sainz Hernández','1995-02-18',2),('22Hans','0a26fecd3f9fb4a61b71391441fad073','Andrea','Jiménez Blanco','1982-10-02',1),('22Santa','9278a7371a04c2a1bd863d2a16459cd2','Santiago','Peña Diego','1990-04-02',0),('24Boom','8c56459214e2386626bc6888bf3a9913','Elena','Crespo Abascal','1989-02-14',2),('24Leia','18726e221adfbaa9e1cb72841461f0e5','Maria','Lavín Herrero','1999-05-12',1),('24Mary','51d4b432d681e44a2c61df0f07a16954','Marta','Herrera Castillo','1998-01-27',1),('24Pam','6380e4e12e39b0f0f1b70d20d177dfd2','Pamela','Muñoz Vega','1982-08-11',0),('25Victor','ff9d6e6053f42eec4200c34eff522a86','Victor','Revuelta Puente','1989-03-01',1),('26Fer','4f1f0423f5647ffa0bad46398dae22bf','Fernando','Sierra Torre','1992-05-08',4),('26luc','2854228089f6cf198c23126e8693dd4b','Lucas','Cuesta Santamaría','1976-03-07',2),('26Mart','9a5c7e2565498698986c7377a29a2793','Marta','Ibáñez Iglesias','1973-04-07',0),('26Pe','20c6395b5330ca311cc4ba5304a05483','Pilar','San Emeterio Calderón','1996-03-15',1),('27Daniel','60c75000480640d2ecd05a0934fe032b','Daniel','Tresgallo Ceballos','1990-04-12',5),('27flynn','600992a3e0e881930330c88ea61132a5','Cristina','Cano Trueba','1981-06-24',2),('27potter','3f9a1eb1df2be226faf947d2ed911c81','Harry','Bolado Arce','1980-07-31',0),('27scott','81ee3f116510861c4da5a8148c5bb4a4','Alejandro','Moreno Merino','1994-08-17',0),('28Adela','46dbfb8784aec7fe700ac7e97287b28b','Adela','Campo Pelayo','1994-04-30',3),('28Esther','5a853ed536498442403e6a219b6b44a9','Esther','Diaz Perez','1990-02-23',2),('28Raul','b8fb0ed7246dee55d647fea72c762bd8','Raul','Perez Prieto','1997-02-19',1),('28Roberto','cf119943044c527460841de675315014','Roberto','Diaz Quintana','1993-02-12',0),('29David','6bb890795c309c459d7fa4bdcf1b1092','David','Barquín Becerra','1994-03-12',1),('30Rodrigo','b31306124ab266da76795168ac71eb8b','Rodrigo','Ramos Cuevas','1992-01-25',0),('31juasRodrigo','9df9bab5749a406888413ee76f7483a4','Ramón','Calvo Maza','1994-09-17',0),('AlRuiz01','b71c2091e8ce6251b96cee93006a7341','Alicia','Ruiz Villalba','1994-04-25',0),('AnaArias01','4c537b49977267ac9e470212681e3bed','Ana','Arias Rodríguez','1998-07-24',2),('DaLope01','08beda14c3a9431e6fa2e98503234cd7','David','Lopez Torcida','1998-10-04',0),('ElBuzn01','c5a42972a85b3fcfa5baf5d1e5f19139','Elisa María','Buznego Martinez','1999-01-03',0),('ElHier01','c8accbf49cf36b69b0160e0e2e1b0f9b','Elena','Hierro Arenas','1999-03-03',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votos`
--

DROP TABLE IF EXISTS `votos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `votos` (
  `usuario` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `cancion` int(11) NOT NULL,
  PRIMARY KEY (`usuario`,`fecha`),
  KEY `fk_voto_cancion` (`cancion`),
  CONSTRAINT `fk_voto_cancion` FOREIGN KEY (`cancion`) REFERENCES `canciones` (`numCancion`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_voto_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`user`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votos`
--

LOCK TABLES `votos` WRITE;
/*!40000 ALTER TABLE `votos` DISABLE KEYS */;
INSERT INTO `votos` VALUES ('02Ana','2018-10-21',1),('03ez','2018-10-21',1),('10messy10','2018-10-22',1),('11Eustaquio','2018-06-07',1),('17Cantua','2018-05-28',1),('26Fer','2018-05-27',1),('27Daniel','2018-08-14',1),('28Roberto','2018-10-13',1),('02Ana','2018-06-05',2),('03squeezy','2018-10-21',2),('17Cantua','2018-10-21',2),('20Alberto','2018-06-07',2),('26Fer','2018-05-28',2),('27Daniel','2018-06-03',2),('05User2','2018-05-28',3),('11Epami','2018-06-06',3),('19Carls','2018-05-27',3),('20Luis','2018-10-16',3),('21booom','2018-10-16',3),('26Fer','2018-05-29',3),('27flynn','2018-10-13',3),('11Eustaquio','2018-10-22',4),('16Victor','2018-06-06',4),('21Byron','2018-06-07',4),('25Victor','2018-06-07',4),('02Eva','2018-06-07',5),('05User3','2018-10-23',5),('16Ana','2018-06-20',5),('16Victor','2018-06-05',5),('20Ana','2018-06-08',5),('28Esther','2018-10-13',5),('22Eustaquio','2018-06-04',6),('02Elsa','2018-10-21',7),('20Luis','2018-05-27',7),('22Adolf','2018-06-07',7),('11Eustaquio','2018-06-05',8),('13LourHerna','2018-10-20',8),('ElHier01','2018-10-11',8),('02ana','2018-10-30',9),('02elsa','2018-10-31',9),('16Carlos','2018-06-06',9),('11Jorge','2018-10-22',10),('13LourHerna','2018-05-28',10),('16Carlos','2018-06-07',10),('21Arm','2018-10-16',10),('24Mary','2018-10-14',10),('26luc','2018-05-06',10),('DaLope01','2018-10-12',11),('02Eva','2018-05-29',12),('16Carlos','2018-05-27',12),('16Victor','2018-10-19',12),('18Dana','2018-05-27',12),('19Fresh','2018-05-29',13),('22Adolf','2018-10-16',13),('02Pedro','2018-10-24',14),('20Alberto','2018-06-05',14),('21meko','2018-10-16',14),('24Boom','2018-10-15',14),('02Elsa','2018-06-01',15),('11Epami','2018-06-04',15),('13Lucia','2018-06-07',15),('17Fabric','2018-06-03',15),('17Fabric','2018-08-14',15),('20Ana','2018-06-09',15),('26luc','2018-05-03',15),('AnaArias01','2018-10-12',15),('21Byron','2018-04-28',16),('26Pe','2018-05-03',16),('27scott','2018-10-13',17),('17Fabric','2018-06-04',18),('18Gama','2018-05-31',18),('21Byron','2018-05-19',18),('AlRuiz01','2018-10-12',18),('02Elsa','2018-05-31',19),('27flynn','2018-06-02',19),('02Eva','2018-05-30',20),('11Eustaquio','2018-06-04',20),('13Carlota','2018-10-22',20),('17Val','2018-06-06',20),('17Val','2018-08-07',20),('18Gama','2018-10-18',20),('18Wala','2018-06-02',20),('20Alberto','2018-06-06',20),('26Fer','2018-08-07',20),('27Daniel','2018-08-07',20),('13Lucia','2018-10-20',22),('18Rana','2018-05-31',22),('26luc','2018-10-14',22),('28Adela','2018-05-27',22),('28Raul','2018-05-25',22),('13Concepcion','2018-06-10',23),('20Alberto','2018-10-17',23),('28Adela','2018-07-08',23),('18Dana','2018-10-18',24),('21meko','2018-05-08',24),('28Adela','2018-06-10',24),('28Esther','2018-05-29',24),('03ez','2018-04-27',25),('03lemon','2018-05-20',25),('03pz','2018-05-20',25),('10qwert','2018-10-22',25),('13LourHerna','2018-05-29',25),('17Val','2018-06-05',25),('19Fresh','2018-05-28',25),('22Hans','2018-05-28',25),('27potter','2018-10-13',25),('28Esther','2018-05-27',25),('02Elsa','2018-10-24',26),('22Eustaquio','2018-05-27',26),('27Daniel','2018-06-02',26),('10asdffgh','2018-10-23',27),('13Lucia','2018-06-13',27),('21Byron','2018-10-16',28),('22Santa','2018-10-15',28),('29David','2018-10-13',29),('03ez','2018-10-24',30),('17Val','2018-06-07',30),('24Boom','2018-06-07',30),('24Mary','2018-06-07',30),('21Byron','2018-05-27',31),('21Byron','2018-06-03',31),('21Byron','2018-08-14',31),('24Leia','2018-05-28',31),('24Boom','2018-05-07',32),('27Daniel','2018-06-04',33),('29David','2018-06-07',33),('05User4','2018-10-23',34),('27flynn','2018-06-03',34),('27flynn','2018-08-14',34),('13Lucia','2018-06-04',35),('13Concepcion','2018-06-03',36),('13Concepcion','2018-08-14',36),('30Rodrigo','2018-10-13',36),('10agallas','2018-10-23',37),('16Carlos','2018-10-19',37),('19Joni','2018-10-17',37),('20Ana','2018-10-17',37),('05User2','2018-10-23',38),('05User3','2018-05-10',38),('13LourHerna','2018-06-07',38),('05User2','2018-05-27',39),('24Pam','2018-10-14',40),('22Hans','2018-10-15',41),('27Daniel','2018-06-05',42),('28Adela','2018-10-13',42),('28Raul','2018-10-13',42),('19Toñin','2018-05-27',43),('22Eustaquio','2018-10-15',43),('ElBuzn01','2018-10-12',43),('11Fernando','2018-10-22',44),('19Carls','2018-10-17',44),('03lemon','2018-10-24',45),('22Adolf','2018-06-05',45),('26Mart','2018-10-14',45),('31juasRodrigo','2018-10-12',47),('18Rana','2018-10-18',48),('19Fresh','2018-05-27',50),('24Leia','2018-10-14',50),('03squeezy','2018-10-24',51),('27Daniel','2018-10-13',52),('02Eva','2018-10-24',53),('13Antonio','2018-10-22',53),('20Juan','2018-10-17',53),('03pz','2018-10-24',54),('04CarlosLa','2018-10-23',54),('11Epami','2018-06-05',54),('11Epami','2018-06-07',55),('11Epami','2018-10-22',56),('13Concepcion','2018-10-20',56),('17Fabric','2018-10-18',56),('19Toñin','2018-05-28',56),('16Yeray','2018-10-19',57),('19Toñin','2018-10-17',57),('10elchupacabras','2018-10-22',59),('02Ana','2018-10-24',61),('16Ana','2018-10-19',61),('18Wala','2018-10-18',61),('22Adolf','2018-06-02',61),('13Carlota','2018-06-01',62),('26Fer','2018-10-14',62),('17Val','2018-10-18',63),('19Fresh','2018-10-17',63),('25Victor','2018-10-14',64),('AnaArias01','2018-07-14',66),('AnaArias01','2018-08-07',66),('03ez','2018-07-21',67),('03lemon','2018-07-21',67),('03pz','2018-07-21',67),('03squeezy','2018-07-21',67),('26Pe','2018-10-13',67),('17Campillo','2018-10-19',68),('17Cantua','2018-10-18',68);
/*!40000 ALTER TABLE `votos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-31 19:22:16
