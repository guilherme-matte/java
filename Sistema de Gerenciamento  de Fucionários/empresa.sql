-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11/09/2024 às 22:49
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `empresa`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `idFuncionarios` int(11) NOT NULL,
  `nomeFuncionario` varchar(100) NOT NULL,
  `cargoFuncionario` varchar(50) NOT NULL,
  `salarioFuncionario` float(9,2) NOT NULL,
  `valeTransporte` float(9,2) NOT NULL,
  `valeAlimentacao` float(9,2) NOT NULL,
  `planoSaude` float(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionarios`
--

INSERT INTO `funcionarios` (`idFuncionarios`, `nomeFuncionario`, `cargoFuncionario`, `salarioFuncionario`, `valeTransporte`, `valeAlimentacao`, `planoSaude`) VALUES
(1, 'Guilherme Matte', 'Estagiário', 1000.00, 540.00, 320.00, 600.00),
(2, 'Guilherme Matte 2 ', 'Gerente', 9876.52, 790.00, 880.22, 0.00),
(3, 'Guilherme Matte 3 ', 'Funcionário', 899.99, 54.00, 0.00, 0.00),
(4, 'Guilherme Piva Matte', 'Gerente', 15089.99, 699.00, 799.00, 350.00);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`idFuncionarios`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
