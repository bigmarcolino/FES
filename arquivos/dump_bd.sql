-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: sql2.freemysqlhosting.net:3306
-- Generation Time: Aug 31, 2014 at 09:42 PM
-- Server version: 5.5.35-0ubuntu0.12.04.2
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
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_locacao` bigint(20) unsigned DEFAULT NULL,
  `id_cliente` bigint(20) unsigned DEFAULT NULL,
  `id_manutencao` bigint(20) unsigned NOT NULL,
  `grupo` text,
  `modelo` text,
  `fabricante` text,
  `disponivel` tinyint(1) DEFAULT NULL,
  `necessita_de_conserto` tinyint(1) DEFAULT NULL,
  `quilometragem` double DEFAULT NULL,
  `ultima_revisao` date DEFAULT NULL,
  `manutencao_no_dia` tinyint(1) DEFAULT NULL,
  `filial` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_id_locacao_carro` (`id_locacao`),
  KEY `fk_id_cliente_carro` (`id_cliente`),
  KEY `fk_id_carro_manutencao` (`id_manutencao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `carro`
--

INSERT INTO `carro` (`id`, `id_locacao`, `id_cliente`, `id_manutencao`, `grupo`, `modelo`, `fabricante`, `disponivel`, `necessita_de_conserto`, `quilometragem`, `ultima_revisao`, `manutencao_no_dia`, `filial`) VALUES
(2, NULL, NULL, 2, 'A', 'Gol', 'Volkswagen', 1, 0, 5685.51, '2013-05-15', 0, 'Voce-Aluga-RJ'),
(3, NULL, NULL, 2, 'B', 'Audi A3', 'Volkswagen', 0, 1, 1325.1, '2014-05-15', 0, 'Voce-Aluga-SP'),
(4, NULL, NULL, 2, 'A', 'Punto', 'Fiat', 1, 0, 590.62, '2014-04-12', 1, 'Voce-Aluga-RJ'),
(5, NULL, NULL, 2, 'A', 'Civic', 'Honda', 1, 1, 3480, '2014-02-27', 0, 'Voce-Aluga-SP'),
(6, NULL, NULL, 2, 'C', 'Camaro', 'Chevrolet', 1, 0, 205.71, '2014-01-05', 0, 'Voce-Aluga-RJ');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` text,
  `numerocnh` text,
  `apolice_seguro` text,
  `possui_contrato` tinyint(1) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `lista_negra` tinyint(1) DEFAULT NULL,
  `id_reserva` bigint(20) unsigned DEFAULT NULL,
  `id_carro` bigint(20) unsigned DEFAULT NULL,
  `data_licenca` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_id_reserva` (`id_reserva`),
  KEY `fk_id_carro_cliente` (`id_carro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `numerocnh`, `apolice_seguro`, `possui_contrato`, `idade`, `lista_negra`, `id_reserva`, `id_carro`, `data_licenca`) VALUES
(1, 'João de Souza', '162365210410', '300110', 1, 30, 0, NULL, NULL, '2013-05-01'),
(2, 'Maria da Silva', '152160280945', '204100', 1, 40, 0, NULL, NULL, '2014-01-25'),
(3, 'Gabriel dos Santos', '32630080977', '705000', 0, 22, 1, NULL, NULL, '2011-09-04'),
(4, 'Antonio Junior', '278961280045', '555100', 0, 55, 0, NULL, NULL, '1980-01-25'),
(5, 'Carolina Pereira', '398563214945', '354122', 1, 34, 0, NULL, NULL, '2000-08-12');

-- --------------------------------------------------------

--
-- Table structure for table `locacao`
--

CREATE TABLE IF NOT EXISTS `locacao` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_reserva` bigint(20) unsigned NOT NULL,
  `id_carro` bigint(20) unsigned NOT NULL,
  `agente_de_locacao` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_id_locacao_reserva` (`id_reserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `locacao`
--

INSERT INTO `locacao` (`id`, `id_reserva`, `id_carro`, `agente_de_locacao`) VALUES
(1, 1, 3, 'Fabricio Moreira'),
(2, 2, 4, 'Armando Nogueira'),
(3, 3, 6, 'Fabricio Moreira'),
(4, 4, 5, 'Armando Nogueira'),
(5, 5, 2, 'Fabricio Moreira'),
(6, 6, 3, 'Armando Nogueira'),
(7, 7, 4, 'Fabricio Moreira'),
(8, 8, 6, 'Armando Nogueira'),
(9, 9, 5, 'Fabricio Moreira'),
(10, 10, 2, 'Armando Nogueira');

-- --------------------------------------------------------

--
-- Table structure for table `manutencao`
--

CREATE TABLE IF NOT EXISTS `manutencao` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_carro` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_id_manutencao_carro` (`id_carro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `manutencao`
--

INSERT INTO `manutencao` (`id`, `data`, `id_carro`) VALUES
(2, '2014-04-12', 2);

-- --------------------------------------------------------

--
-- Table structure for table `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tarifa_de_retorno` double DEFAULT NULL,
  `tarifa_de_danificacao` double DEFAULT NULL,
  `tarifa_de_atraso` double DEFAULT NULL,
  `forma_de_pagamento` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `modelo` text,
  `grupo` text,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`id`, `id_cliente`, `modelo`, `grupo`, `data_fim`, `data_inicio`) VALUES
(1, 1, 'Audi A3', 'B', '2014-04-03', '2014-04-12'),
(2, 4, 'Punto', 'A', '2014-08-26', '2014-09-01'),
(3, 3, 'Camaro', 'C', '2014-06-01', '2012-06-03'),
(4, 1, 'Civic', 'A', '2014-05-25', '2014-06-12'),
(5, 2, 'Gol', 'A', '2014-06-28', '2014-07-04'),
(6, 4, 'Audi A3', 'B', '2014-04-13', '2014-04-20'),
(7, 1, 'Punto', 'A', '2014-01-04', '2014-01-14'),
(8, 5, 'Camaro', 'C', '2014-07-05', '2012-07-08'),
(9, 3, 'Civic', 'A', '2014-02-27', '2014-03-15'),
(10, 1, 'Gol', 'A', '2014-04-11', '2014-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) DEFAULT NULL,
  `value` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `value`) VALUES
(1, 'Hi'),
(2, 'Hello');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carro`
--
ALTER TABLE `carro`
  ADD CONSTRAINT `fk_id_carro_manutencao` FOREIGN KEY (`id_manutencao`) REFERENCES `carro` (`id`),
  ADD CONSTRAINT `fk_id_cliente_carro` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `fk_id_locacao_carro` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id`);

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_id_carro_cliente` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id`),
  ADD CONSTRAINT `fk_id_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`);

--
-- Constraints for table `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `fk_id_locacao_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`);

--
-- Constraints for table `manutencao`
--
ALTER TABLE `manutencao`
  ADD CONSTRAINT `fk_id_manutencao_carro` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id`);

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
