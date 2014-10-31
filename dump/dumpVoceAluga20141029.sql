CREATE DATABASE  IF NOT EXISTS `vocealuga` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vocealuga`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vocealuga
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro` (
  `id_carro` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `grupo` text,
  `modelo` text,
  `fabricante` text,
  `disponibilidade` tinyint(1) DEFAULT NULL,
  `quilometragem` double DEFAULT NULL,
  `ultima_revisao` date DEFAULT NULL,
  `filial` text,
  `ano` varchar(4) DEFAULT NULL,
  `necessita_de_conserto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_carro`),
  UNIQUE KEY `id_carro` (`id_carro`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,'A','Gol','Volkswagen',1,15200.57,'2013-05-18','RJ','2005',0),(2,'B','Punto','Fiat',1,600,'2014-09-09','SP','2013',1),(3,'A','Chevette','Chevrolet',1,100900.1,'1999-11-20','MG','1978',0),(4,'D','Camaro','Chevrolet',1,1354,'2012-04-29','RJ','2014',0),(5,'B','Carrera','Porsche',0,50,'2013-05-18','SP','2013',0),(6,'A','New Fusion','Ford',1,10,'2012-08-13','MG','2014',0),(7,'A','Fiesta','Ford',1,15,'2013-09-12','RJ','2012',1),(8,'A','New Fiesta','Ford',0,5,'2014-01-14','SP','2014',1),(9,'A','City','Honda',1,15,'2013-02-22','MG','2014',1),(10,'A','New Civic','Honda',0,25,'2007-07-14','RJ','2009',1),(11,'A','Ka','Ford',0,148000,'2010-08-10','SP','2005',1),(12,'A','Optima','Kia',1,40000,'2013-10-17','RJ','2014',0),(13,'A','Elantra','Hyundai',1,20000,'2014-04-13','RJ','2012',0),(14,'A','Palio','Fiat',0,25000,'2013-02-01','SP','2007',1),(15,'B','HB20','Hyundai',0,15000,'2013-01-01','MG','2014',1),(16,'B','Cruze','Chevrolet',1,23403,'2012-11-11','SP','2012',0),(17,'B','Onix','Chevrolet',1,24582,'2012-12-17','RJ','2012',1),(18,'B','HB20s','Hyundai',0,23445,'2013-02-01','MG','2014',1),(19,'B','Celta','Volkswagen',1,36480,'2010-04-03','RJ','2005',0),(20,'B','Corolla','Toyota',1,40593,'2014-06-23','SP','2014',1),(21,'B','Fit','Honda',1,43454,'2013-05-18','RJ','2011',0),(22,'B','Stilo','Fiat',1,45356,'2012-12-17','SP','2010',1),(23,'B','Ceratto','Kia',1,3435,'2010-08-10','MG','2014',0),(24,'B','Camaro','Chevrolet',1,565654,'2013-10-17','RJ','2008',1),(25,'B','Meriva','Chevrolet',0,5565,'2012-11-11','SP','2012',1),(26,'C','Megáne','Renault',1,6556,'2007-07-14','MG','2013',0),(27,'C','Clio','Renault',1,56,'2013-10-17','RJ','2010',0),(28,'C','Brasília','Volkswagen',0,46,'2013-05-18','SP','2008',0),(29,'C','Fusca','Volkswagen',0,565,'2010-08-10','MG','2007',0),(30,'C','Kombi','Volkswagen',0,67,'2012-11-11','RJ','2006',1),(31,'C','Sandero','Renault',1,676,'2010-08-10','SP','2005',1),(32,'C','Ranger','Ford',1,767,'2013-02-22','MG','2010',1),(33,'C','A3','Audi',1,45,'2010-04-03','RJ','2011',0),(34,'C','Golf','Volkswagen',1,56566,'2014-09-09','SP','2012',0),(35,'C','Soul','Kia',1,455,'2014-01-14','MG','2000',0),(36,'C','TT','Audi',0,5566,'2013-02-22','RJ','2014',0),(37,'C','R8','Audi',1,7778,'2014-01-14','SP','2013',1),(38,'D','206','Peugeot',0,5777,'2012-11-11','MG','2011',1),(39,'D','207','Peugeot',0,66,'2014-09-09','RJ','2012',1),(40,'D','Lancer Evolution','Mitsubishi',0,56,'2012-11-11','SP','2011',0),(41,'D','Focus','Ford',0,56,'2010-08-10','MG','2003',1),(42,'D','Ecosport','Ford',1,46,'2014-01-14','RJ','2014',1),(43,'D','Blazer','Chevrolet',0,6,'2013-09-12','SP','2001',1),(44,'D','Gallardo','Lamborghini',1,56896,'2014-01-14','MG','2002',0),(45,'D','Diablo','Lamborghini',0,7686,'2014-01-14','RJ','2005',0),(46,'D','Mustang','Ford',1,8676,'2010-08-10','SP','2007',0),(47,'D','March','Nissan',0,76,'2013-09-12','MG','2014',0),(48,'D','350Z','Nissan',1,78668,'2014-09-09','RJ','2010',1),(49,'D','Veyron','Bugatti',1,876,'2012-11-11','SP','2014',1),(50,'D','Skyline','Nissan',0,54,'2013-09-12','MG','2010',1),(51,'D','Sentra','Nissan',0,66,'2013-09-12','RJ','2014',1);
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro_tem_locacao`
--

DROP TABLE IF EXISTS `carro_tem_locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro_tem_locacao` (
  `id_carro_tem_locacao` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  `id_locacao` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_carro_tem_locacao`),
  UNIQUE KEY `id_carro_tem_locacao` (`id_carro_tem_locacao`),
  KEY `FK_carro_tem_locacao_0` (`id_carro`),
  KEY `FK_carro_tem_locacao_1` (`id_locacao`),
  CONSTRAINT `FK_carro_tem_locacao_0` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`),
  CONSTRAINT `FK_carro_tem_locacao_1` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro_tem_locacao`
--

LOCK TABLES `carro_tem_locacao` WRITE;
/*!40000 ALTER TABLE `carro_tem_locacao` DISABLE KEYS */;
INSERT INTO `carro_tem_locacao` VALUES (1,4,1),(2,1,2);
/*!40000 ALTER TABLE `carro_tem_locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro_tem_reserva`
--

DROP TABLE IF EXISTS `carro_tem_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro_tem_reserva` (
  `id_carro_tem_reserva` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  `id_reserva` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_carro_tem_reserva`),
  UNIQUE KEY `id_carro_tem_reserva` (`id_carro_tem_reserva`),
  KEY `FK_carro_tem_reserva_0` (`id_carro`),
  KEY `FK_carro_tem_reserva_1` (`id_reserva`),
  CONSTRAINT `FK_carro_tem_reserva_0` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`),
  CONSTRAINT `FK_carro_tem_reserva_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro_tem_reserva`
--

LOCK TABLES `carro_tem_reserva` WRITE;
/*!40000 ALTER TABLE `carro_tem_reserva` DISABLE KEYS */;
INSERT INTO `carro_tem_reserva` VALUES (1,1,1),(2,3,2),(3,3,3),(4,4,4);
/*!40000 ALTER TABLE `carro_tem_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` text,
  `idade` text,
  `lista_negra` tinyint(1) DEFAULT NULL,
  `id_motorista` int(11) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente` (`id_cliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Roberto Freitas','25',0,NULL,'12345678901'),(2,'José de Faria','18',0,NULL,'22132344333'),(3,'Maria Rocha','34',1,NULL,'23333455332'),(4,'Bruno de Almeida','19',1,NULL,'11223467432'),(5,'Elias Monteiro','38',0,NULL,'35563223467');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_tem_motorista`
--

DROP TABLE IF EXISTS `cliente_tem_motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_tem_motorista` (
  `id_cliente_tem_motorista` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_motorista` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_cliente_tem_motorista`),
  UNIQUE KEY `id_cliente_tem_motorista` (`id_cliente_tem_motorista`),
  KEY `FK_cliente_tem_motorista_0` (`id_cliente`),
  KEY `FK_cliente_tem_motorista_1` (`id_motorista`),
  CONSTRAINT `FK_cliente_tem_motorista_0` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FK_cliente_tem_motorista_1` FOREIGN KEY (`id_motorista`) REFERENCES `motorista` (`id_motorista`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_tem_motorista`
--

LOCK TABLES `cliente_tem_motorista` WRITE;
/*!40000 ALTER TABLE `cliente_tem_motorista` DISABLE KEYS */;
INSERT INTO `cliente_tem_motorista` VALUES (1,1,1),(2,3,2),(3,5,3);
/*!40000 ALTER TABLE `cliente_tem_motorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacao` (
  `id_locacao` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `agente_de_locacao` text,
  `data` date DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  `id_reserva` bigint(20) unsigned DEFAULT NULL,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_carro` varchar(255) DEFAULT NULL,
  `id_pagamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_locacao`),
  UNIQUE KEY `id_locacao` (`id_locacao`),
  KEY `FK_locacao_1` (`id_reserva`),
  KEY `FK_locacao_2` (`id_cliente`),
  CONSTRAINT `FK_locacao_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  CONSTRAINT `FK_locacao_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,'Patrick Marques','2014-02-20',0,NULL,3,NULL,NULL),(2,'Patrick Marques','2014-06-14',0,NULL,4,NULL,NULL);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manutencao`
--

DROP TABLE IF EXISTS `manutencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manutencao` (
  `id_manutencao` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_manutencao`),
  UNIQUE KEY `id_manutencao` (`id_manutencao`),
  KEY `FK_manutencao_0` (`id_carro`),
  CONSTRAINT `FK_manutencao_0` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manutencao`
--

LOCK TABLES `manutencao` WRITE;
/*!40000 ALTER TABLE `manutencao` DISABLE KEYS */;
INSERT INTO `manutencao` VALUES (1,'2014-10-25',1),(2,'2015-08-19',2),(3,'2016-03-27',3),(4,'2015-02-28',4),(5,'2014-11-30',5);
/*!40000 ALTER TABLE `manutencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorista`
--

DROP TABLE IF EXISTS `motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motorista` (
  `id_motorista` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cnh` text,
  `idade` text,
  `apolice_seguros` text,
  `data_licenca` date DEFAULT NULL,
  `possui_contrato` tinyint(1) DEFAULT NULL,
  `nome` text,
  `id_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_motorista`),
  UNIQUE KEY `id_motorista` (`id_motorista`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorista`
--

LOCK TABLES `motorista` WRITE;
/*!40000 ALTER TABLE `motorista` DISABLE KEYS */;
INSERT INTO `motorista` VALUES (1,'1012316574','50','012142','2000-05-10',1,'Alberto Jr. Batista',NULL),(2,'3548961000','47','752340','2010-11-21',0,'Júlio Ferreira Santos',NULL),(3,'3211457941','50','698532','2014-01-29',1,'Gabriel Moraes',NULL);
/*!40000 ALTER TABLE `motorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `id_pagamento` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tarifa_de_retorno` double DEFAULT NULL,
  `tarifa_de_danificacao` double DEFAULT NULL,
  `tarifa_de_atraso` double DEFAULT NULL,
  `forma_de_pagamento` text,
  `data` date DEFAULT NULL,
  `id_locacao` bigint(20) unsigned DEFAULT NULL,
  `id_reserva` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`),
  UNIQUE KEY `id_pagamento` (`id_pagamento`),
  KEY `FK_pagamento_0` (`id_locacao`),
  KEY `FK_pagamento_1` (`id_reserva`),
  CONSTRAINT `FK_pagamento_0` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`),
  CONSTRAINT `FK_pagamento_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,120.99,NULL,NULL,'Crédito','2014-12-30',NULL,1),(2,120.99,NULL,NULL,'Dinheiro','2014-12-29',NULL,2);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id_reserva` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_carro` varchar(255) DEFAULT NULL,
  `id_locacao` varchar(255) DEFAULT NULL,
  `id_pagamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  UNIQUE KEY `id_reserva` (`id_reserva`),
  KEY `FK_reserva_1` (`id_cliente`),
  CONSTRAINT `FK_reserva_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2015-01-20','2015-01-01',1,NULL,NULL,NULL),(2,'2015-01-30','2015-01-20',2,NULL,NULL,NULL),(3,'2015-02-28','2015-02-20',5,NULL,NULL,NULL),(4,'2015-04-13','2015-04-11',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-29  4:08:25
