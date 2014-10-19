-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: sql2.freemysqlhosting.net:3306
-- Generation Time: Oct 20, 2014 at 12:11 AM
-- Server version: 5.5.38-0ubuntu0.12.04.1
-- PHP Version: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sql250894`
--

-- --------------------------------------------------------

--
-- Table structure for table `carro`
--

CREATE TABLE IF NOT EXISTS `carro` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `carro`
--

INSERT INTO `carro` (`id_carro`, `grupo`, `modelo`, `fabricante`, `disponibilidade`, `quilometragem`, `ultima_revisao`, `filial`, `ano`, `necessita_de_conserto`) VALUES
(1, 'A', 'Gol', 'Volkswagen', 1, 15200.57, '2013-05-18', NULL, '2005', 0),
(2, 'B', 'Fiat', 'Punto', 1, 600, '2014-09-09', NULL, '2013', 1),
(3, 'A', 'Chevrolet', 'Chevette', 1, 100900.1, '1999-11-20', NULL, '1978', 0),
(4, 'D', 'Chevrolet', 'Camaro', 1, 1354, '2012-04-29', NULL, '2011', 0),
(5, 'E', 'Porsche', 'Carrera', 0, 50, '2013-05-18', NULL, '2013', 0);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` text,
  `idade` text,
  `lista_negra` tinyint(1) DEFAULT NULL,
  `id_motorista` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente` (`id_cliente`),
  KEY `FK_cliente_3` (`id_motorista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `idade`, `lista_negra`, `id_motorista`) VALUES
(1, 'Roberto Freitas', '25', 0, 1),
(2, 'José de Faria', '18', 0, NULL),
(3, 'Maria Rocha', '34', 1, 2),
(4, 'Bruno de Almeida', '19', 1, NULL),
(5, 'Elias Monteiro', '38', 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `locacao`
--

CREATE TABLE IF NOT EXISTS `locacao` (
  `id_locacao` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `agente_de_locacao` text,
  `data` date DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  `id_pagamento` bigint(20) unsigned DEFAULT NULL,
  `id_reserva` bigint(20) unsigned DEFAULT NULL,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_locacao`),
  UNIQUE KEY `id_locacao` (`id_locacao`),
  KEY `FK_locacao_0` (`id_pagamento`),
  KEY `FK_locacao_1` (`id_reserva`),
  KEY `FK_locacao_2` (`id_cliente`),
  KEY `FK_locacao_3` (`id_carro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `locacao`
--

INSERT INTO `locacao` (`id_locacao`, `agente_de_locacao`, `data`, `ativo`, `id_pagamento`, `id_reserva`, `id_cliente`, `id_carro`) VALUES
(1, 'Patrick Marques', '2014-02-20', 0, NULL, NULL, 3, 2),
(2, 'Patrick Marques', '2014-06-14', 0, NULL, NULL, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `manutencao`
--

CREATE TABLE IF NOT EXISTS `manutencao` (
  `id_manutencao` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_manutencao`),
  UNIQUE KEY `id_manutencao` (`id_manutencao`),
  KEY `FK_manutencao_0` (`id_carro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `manutencao`
--

INSERT INTO `manutencao` (`id_manutencao`, `data`, `id_carro`) VALUES
(1, '2014-10-25', 1),
(2, '2015-08-19', 2),
(3, '2016-03-27', 3),
(4, '2015-02-28', 4),
(5, '2014-11-30', 5);

-- --------------------------------------------------------

--
-- Table structure for table `motorista`
--

CREATE TABLE IF NOT EXISTS `motorista` (
  `id_motorista` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cnh` text,
  `idade` text,
  `apolice_seguros` text,
  `data_licenca` date DEFAULT NULL,
  `possui_contrato` tinyint(1) DEFAULT NULL,
  `nome` text,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_motorista`),
  UNIQUE KEY `id_motorista` (`id_motorista`),
  KEY `FK_motorista_0` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `motorista`
--

INSERT INTO `motorista` (`id_motorista`, `cnh`, `idade`, `apolice_seguros`, `data_licenca`, `possui_contrato`, `nome`, `id_cliente`) VALUES
(1, '1012316574', '50', '012142', '2000-05-10', 1, 'Alberto Jr. Batista', 1),
(2, '3548961000', '43', '752340', '2010-11-21', 0, 'Júlio Ferreira Santos', 3),
(3, '3211457941', '50', '698532', '2014-01-29', 1, 'Gabriel Moraes', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
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
  KEY `FK_pagamento_1` (`id_reserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `pagamento`
--

INSERT INTO `pagamento` (`id_pagamento`, `tarifa_de_retorno`, `tarifa_de_danificacao`, `tarifa_de_atraso`, `forma_de_pagamento`, `data`, `id_locacao`, `id_reserva`) VALUES
(1, 120.99, NULL, NULL, 'Crédito', '2014-12-30', NULL, 1),
(2, 120.99, NULL, NULL, 'Dinheiro', '2014-12-29', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `id_reserva` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `id_locacao` bigint(20) unsigned DEFAULT NULL,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  `id_pagamento` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  UNIQUE KEY `id_reserva` (`id_reserva`),
  KEY `FK_reserva_0` (`id_locacao`),
  KEY `FK_reserva_1` (`id_cliente`),
  KEY `FK_reserva_2` (`id_carro`),
  KEY `FK_reserva_3` (`id_pagamento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `data_fim`, `data_inicio`, `id_locacao`, `id_cliente`, `id_carro`, `id_pagamento`) VALUES
(1, '2015-01-20', '2015-01-01', NULL, 1, 1, 1),
(2, '2015-01-30', '2015-01-20', NULL, 2, 1, 2),
(3, '0000-00-00', '2015-02-20', NULL, 5, 1, NULL),
(4, '2015-04-13', '2015-04-11', NULL, 2, 3, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_cliente_3` FOREIGN KEY (`id_motorista`) REFERENCES `motorista` (`id_motorista`);

--
-- Constraints for table `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `FK_locacao_0` FOREIGN KEY (`id_pagamento`) REFERENCES `pagamento` (`id_pagamento`),
  ADD CONSTRAINT `FK_locacao_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `FK_locacao_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `FK_locacao_3` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`);

--
-- Constraints for table `manutencao`
--
ALTER TABLE `manutencao`
  ADD CONSTRAINT `FK_manutencao_0` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`);

--
-- Constraints for table `motorista`
--
ALTER TABLE `motorista`
  ADD CONSTRAINT `FK_motorista_0` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `FK_pagamento_0` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`),
  ADD CONSTRAINT `FK_pagamento_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FK_reserva_0` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`),
  ADD CONSTRAINT `FK_reserva_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `FK_reserva_2` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`),
  ADD CONSTRAINT `FK_reserva_3` FOREIGN KEY (`id_pagamento`) REFERENCES `pagamento` (`id_pagamento`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;