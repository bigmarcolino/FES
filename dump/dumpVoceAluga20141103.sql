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
  `fabricante` text,
  `modelo` text,
  `placa` varchar(8) DEFAULT NULL,
  `valor` varchar(11) DEFAULT NULL,
  `grupo` text,
  `disponibilidade` tinyint(1) DEFAULT NULL,
  `quilometragem` double DEFAULT NULL,
  `ultima_revisao` date DEFAULT NULL,
  `filial` text,
  `ano` varchar(4) DEFAULT NULL,
  `necessita_de_conserto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_carro`),
  UNIQUE KEY `id_carro` (`id_carro`),
  UNIQUE KEY `placa_UNIQUE` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,'Volkswagen','Gol','PLC6578','22000','A',1,15200.57,'2013-05-18','RJ','2005',0),(2,'Fiat','Punto','WWW8732','29000','B',1,600,'2014-09-09','SP','2013',1),(3,'Chevrolet','Chevette','UFC1234','35000','A',1,100900.1,'1999-11-20','MG','1978',0),(4,'Chevrolet','Camaro','WUC7856','250000','D',1,1354,'2012-04-29','RJ','2014',0),(5,'Porsche','Carrera','IEE6754','450000','B',0,50,'2013-05-18','SP','2013',0),(6,'Ford','New Fusion','JYC7463','110000','A',1,10,'2012-08-13','MG','2014',0),(7,'Ford','Fiesta Sedan','UUU8573','24000','A',1,15,'2013-09-12','RJ','2012',1),(8,'Ford','New Fiesta','HAT0392','37000','A',0,5,'2014-01-14','SP','2014',1),(9,'Honda','City','HIT7392','80000','A',1,15,'2013-02-22','MG','2014',1),(10,'Honda','New Civic','YYY9372','65000','A',0,25,'2007-07-14','RJ','2009',1),(11,'Ford','Ka','LOB3109','25000','A',0,148000,'2010-08-10','SP','2005',1),(12,'Kia','Optima','KXX5764','150000','A',1,40000,'2013-10-17','RJ','2014',0),(13,'Hyundai','Elantra','AAW5373','90000','A',1,20000,'2014-04-13','RJ','2012',0),(14,'Fiat','Palio','UUT7583','25000','A',0,25000,'2013-02-01','SP','2007',1),(15,'Hyundai','HB20','JJJ8473','30000','B',0,15000,'2013-01-01','MG','2014',1),(16,'Chevrolet','Cruze','IOF0938','60000','B',1,23403,'2012-11-11','SP','2012',0),(17,'Chevrolet','Onix','FFC7632','33000','B',1,24582,'2012-12-17','RJ','2012',1),(18,'Hyundai','HB20s','CRV2983','45000','B',0,23445,'2013-02-01','MG','2014',1),(19,'Volkswagen','Celta','RRN8366','20000','B',1,36480,'2010-04-03','RJ','2005',0),(20,'Toyota','Corolla','POO8374','55000','B',1,40593,'2014-06-23','SP','2014',1),(21,'Honda','Fit','POU7722','50000','B',1,43454,'2013-05-18','RJ','2011',0),(22,'Fiat','Stilo','YYU8473','30000','B',1,45356,'2012-12-17','SP','2010',1),(23,'Kia','Cerato','TIC7255','70000','B',1,3435,'2010-08-10','MG','2014',0),(24,'Chevrolet','Camaro','UFR9382','250000','B',1,565654,'2013-10-17','RJ','2008',1),(25,'Chevrolet','Meriva','ERT8732','25000','B',0,5565,'2012-11-11','SP','2012',1),(26,'Renault','Megáne','YTR1029','35000','C',1,6556,'2007-07-14','MG','2013',0),(27,'Renault','Clio','EYW9220','28000','C',1,56,'2013-10-17','RJ','2010',0),(28,'Volkswagen','Brasília','SBV2039','5000','C',0,46,'2013-05-18','SP','2008',0),(29,'Volkswagen','New Beetle','NBS2901','30000','C',0,565,'2010-08-10','MG','2007',0),(30,'Volkswagen','Kombi','CNN3823','5000','C',0,67,'2012-11-11','RJ','2006',1),(31,'Renault','Sandero','LLO8372','25000','C',1,676,'2010-08-10','SP','2005',1),(32,'Ford','Ranger','GTT8273','70000','C',1,767,'2013-02-22','MG','2010',1),(33,'Audi','A3','DBZ6662','40000','C',1,45,'2010-04-03','RJ','2011',0),(34,'Volkswagen','Golf','JHD8932','30000','C',1,56566,'2014-09-09','SP','2012',0),(35,'Kia','Soul','FOF6721','30000','C',1,455,'2014-01-14','MG','2000',0),(36,'Audi','TT','BGS8636','200000','C',0,5566,'2013-02-22','RJ','2014',0),(37,'Audi','R8','CPT9021','1500000','C',1,7778,'2014-01-14','SP','2013',1),(38,'Peugeot','206','HSV7211','20000','D',0,5777,'2012-11-11','MG','2011',1),(39,'Peugeot','207','PLS7832','28000','D',0,66,'2014-09-09','RJ','2012',1),(40,'Mitsubishi','Lancer Evolution','BSA9302','800000','D',0,56,'2012-11-11','SP','2011',0),(41,'Ford','Focus','DSA7311','28000','D',0,56,'2010-08-10','MG','2003',1),(42,'Ford','Ecosport','JMN3184','60000','D',1,46,'2014-01-14','RJ','2014',1),(43,'Chevrolet','Blazer','MMS7832','50000','D',0,6,'2013-09-12','SP','2001',1),(44,'Lamborghini','Gallardo','KKT9042','4000000','D',1,56896,'2014-01-14','MG','2002',0),(45,'Lamborghini','Aventator','OPR9364','2000000','D',0,7686,'2014-01-14','RJ','2005',0),(46,'Ford','Mustang','QPR7484','1800000','D',1,8676,'2010-08-10','SP','2007',0),(47,'Nissan','March','MAN9042','26000','D',0,76,'2013-09-12','MG','2014',0),(48,'Nissan','350Z','UTD5462','900000','D',1,78668,'2014-09-09','RJ','2010',1),(49,'Bugatti','Veyron','HHH7832','5000000','D',1,876,'2012-11-11','SP','2014',1),(50,'Nissan','Skyline','FBK7483','750000','D',0,54,'2013-09-12','MG','2010',1),(51,'Nissan','Sentra','POR8573','70000','D',0,66,'2013-09-12','RJ','2014',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Roberto Freitas','25',0,NULL,'12345678901'),(2,'José de Faria','18',0,NULL,'22132344333'),(3,'Maria Rocha','34',1,NULL,'23333455332'),(4,'Bruno de Almeida','19',1,NULL,'11223467432'),(5,'Elias Monteiro','38',0,NULL,'35563223467'),(6,'Gobbi','21',0,NULL,'13473382734'),(7,'Marcus','12',0,NULL,'12635437211'),(8,'Kaique','12',0,NULL,'12345763211'),(9,'Guilherme Gobbi','22',0,NULL,'12342123456'),(10,'Pati','23',0,NULL,'09876543213'),(11,'raul','23',0,NULL,'09855553213'),(12,'Igor Balofo','15',0,NULL,'13409283232'),(13,'Marcus Vinicius','23',0,NULL,'12345678921'),(14,'Hugo','24',0,NULL,'12345123456');
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

-- Dump completed on 2014-11-03 12:17:25
