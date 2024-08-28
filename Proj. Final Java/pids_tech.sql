-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21/06/2024 às 12:18
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pids_tech`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadastro_produto_empresas`
--

CREATE TABLE `cadastro_produto_empresas` (
  `produto_id` int(11) NOT NULL,
  `cnpj` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `quantidade` int(3) NOT NULL,
  `nomeEmpresa` varchar(50) NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `descricao` text NOT NULL,
  `cnpj_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cadastro_produto_empresas`
--

INSERT INTO `cadastro_produto_empresas` (`produto_id`, `cnpj`, `categoria`, `quantidade`, `nomeEmpresa`, `responsavel`, `descricao`, `cnpj_id`) VALUES
(4, '11.111.111/1111-11', 'Perifericos', 100, 'Teste1', 'Guilherme Piva', '', 2),
(5, '11.111.111/1111-11', 'Computador', 100, 'Teste1', 'Guilherme Piva', '', 2),
(6, '11.111.111/1111-11', 'Computador', 100, 'Teste1', 'Guilherme Piva', 'Computador Intel\nProcessador I3 2ª geração\n4gb RAM ddr3', 2),
(7, '11.111.111/1111-11', 'Computador', 4, 'Teste1', 'Guilherme Piva', 'intel', 2),
(8, '77.888.999/9888-99', 'Computador', 1, 'Fibonacci', 'Mozart', 'PC Lentium DDR-1', 6),
(9, '88.476.716/6171-28', 'Notebook', 3, 'Teste3', 'Guilherme3', 'Notebook Negativo', 7),
(10, '11.111.111/1111-11', 'Perifericos', 3, 'Teste1', 'Guilherme Piva', 'teste', 2),
(11, '11.111.111/1111-11', 'Perifericos', 3, 'Teste1', 'Guilherme Piva', 'teste', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadastro_produto_pessoafisica`
--

CREATE TABLE `cadastro_produto_pessoafisica` (
  `pfproduto_id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nomePF` varchar(50) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `descricao` text NOT NULL,
  `cpf_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cadastro_produto_pessoafisica`
--

INSERT INTO `cadastro_produto_pessoafisica` (`pfproduto_id`, `cpf`, `nomePF`, `quantidade`, `categoria`, `descricao`, `cpf_id`) VALUES
(1, '111.111.111-11', 'Guilherme  Piva Matte 3', 100, 'Computador', 'Computador Intel\nProcessador I3 2ª geração\n4gb RAM', 1),
(2, '222.222.222-22', 'Guilherme Teste2', 2, 'Notebook', 'Computador Intel\nProcessador I3 10ª geração\n8gb RAM DDR4', 3),
(3, '111.111.111-11', 'Guilherme  Piva Matte 3', 5, 'Perifericos', 'Mouse e Teclado DELL', 1),
(4, '111.111.111-11', 'Guilherme  Piva Matte 3', 3, 'Computador', 'teste', 1),
(5, '111.111.111-11', 'Guilherme  Piva Matte 3', 3, 'Computador', 'teste', 1),
(6, '111.111.111-11', 'Guilherme  Piva Matte 3', 3, 'Computador', 'teste', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `empresas`
--

CREATE TABLE `empresas` (
  `empresa_id` int(11) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `nome_empresa` varchar(50) NOT NULL,
  `nome_responsavel` varchar(30) NOT NULL,
  `telefone_empresa` varchar(14) NOT NULL,
  `telefone_responsavel` varchar(14) NOT NULL,
  `email_empresa` varchar(100) NOT NULL,
  `email_responsavel` varchar(100) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `data_cadastro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Despejando dados para a tabela `empresas`
--

INSERT INTO `empresas` (`empresa_id`, `cnpj`, `nome_empresa`, `nome_responsavel`, `telefone_empresa`, `telefone_responsavel`, `email_empresa`, `email_responsavel`, `cargo`, `data_cadastro`) VALUES
(2, '11.111.111/1111-11', 'Teste1', 'Guilherme Piva', '(51)98027-4331', '(11)11111-1111', 'Teste1@gmail.com', 'Guilherme1@gmail.com', 'Chefe', '2024-06-06'),
(4, '22.222.222/2222-22', 'Teste2', 'Guilherme2', '(22)22222-2222', '(22)22222-2222', 'Teste2@gmail.com', 'Guilherme2@gmail.com', 'Dono', '2024-06-06'),
(6, '77.888.999/9888-99', 'Fibonacci', 'Mozart', '(51)99999-2222', '(51)99999-2222', 'Fibonacci@gmail', 'Mozart@gmail.com', 'Estágiario', '2024-06-11'),
(7, '88.476.716/6171-28', 'Teste3', 'Guilherme3', '(33)33333-3333', '(33)33333-3333', 'Teste3@gmail.com', 'Guilherme3@gmail.com', 'Fundador', '2024-06-11');

-- --------------------------------------------------------

--
-- Estrutura para tabela `login`
--

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nome_completo` varchar(50) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `perfil` varchar(50) NOT NULL,
  `email` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `login`
--

INSERT INTO `login` (`login_id`, `cpf`, `nome_completo`, `usuario`, `senha`, `perfil`, `email`) VALUES
(1, '', '', 'Guilherme', 'senha123', 'Usuario', ''),
(2, '', '', 'admin', 'senha123', 'Administrador', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa_fisica`
--

CREATE TABLE `pessoa_fisica` (
  `pessoaFisica_id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(30) NOT NULL,
  `email` varchar(100) NOT NULL,
  `endereco` varchar(70) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `data_cadastro` date NOT NULL,
  `telefone` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Despejando dados para a tabela `pessoa_fisica`
--

INSERT INTO `pessoa_fisica` (`pessoaFisica_id`, `cpf`, `nome`, `sobrenome`, `email`, `endereco`, `cep`, `data_cadastro`, `telefone`) VALUES
(1, '111.111.111-11', 'Guilherme ', 'Piva Matte 3', 'Teste1@gmail.com', 'Rua Teste1', '11111-111', '2024-06-06', '(51)98027-4331'),
(3, '222.222.222-22', 'Guilherme', 'Teste2', 'Teste2', 'Rua Teste2', '22222-222', '2024-06-06', '(22)22222-2222'),
(4, '777.777.777-77', 'Teste3', 'Teste3', 'Teste3@gmail.com', 'Teste3', '33333-333', '2024-06-14', '(22)22222-2222');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cadastro_produto_empresas`
--
ALTER TABLE `cadastro_produto_empresas`
  ADD PRIMARY KEY (`produto_id`),
  ADD KEY `fk_relacionar_empresa` (`cnpj_id`);

--
-- Índices de tabela `cadastro_produto_pessoafisica`
--
ALTER TABLE `cadastro_produto_pessoafisica`
  ADD PRIMARY KEY (`pfproduto_id`),
  ADD KEY `fk_relacionar_pf` (`cpf_id`);

--
-- Índices de tabela `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`empresa_id`),
  ADD UNIQUE KEY `cnpj` (`cnpj`);

--
-- Índices de tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login_id`),
  ADD UNIQUE KEY `cpf` (`cpf`,`usuario`);

--
-- Índices de tabela `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  ADD PRIMARY KEY (`pessoaFisica_id`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cadastro_produto_empresas`
--
ALTER TABLE `cadastro_produto_empresas`
  MODIFY `produto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `cadastro_produto_pessoafisica`
--
ALTER TABLE `cadastro_produto_pessoafisica`
  MODIFY `pfproduto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `empresas`
--
ALTER TABLE `empresas`
  MODIFY `empresa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  MODIFY `pessoaFisica_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `cadastro_produto_empresas`
--
ALTER TABLE `cadastro_produto_empresas`
  ADD CONSTRAINT `fk_relacionar_empresa` FOREIGN KEY (`cnpj_id`) REFERENCES `empresas` (`empresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `cadastro_produto_pessoafisica`
--
ALTER TABLE `cadastro_produto_pessoafisica`
  ADD CONSTRAINT `fk_relacionar_pf` FOREIGN KEY (`cpf_id`) REFERENCES `pessoa_fisica` (`pessoaFisica_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
