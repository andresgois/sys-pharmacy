create database farmacia;

use farmacia;

-- Criação da tabela Fornecedores
CREATE TABLE Fornecedores (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criação da tabela Produtos
CREATE TABLE Produtos (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    quantidade BIGINT NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    fornecedor_codigo BIGINT,
    FOREIGN KEY (fornecedor_codigo) REFERENCES Fornecedores(codigo)
);

-- Alterar a coluna para AUTO_INCREMENT na tabela Fornecedores
--ALTER TABLE Fornecedores MODIFY COLUMN codigo BIGINT AUTO_INCREMENT PRIMARY KEY;

-- Alterar a coluna para AUTO_INCREMENT na tabela Produtos
--ALTER TABLE Produtos MODIFY COLUMN codigo BIGINT AUTO_INCREMENT PRIMARY KEY;