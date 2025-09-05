-- Cria a database
CREATE DATABASE carrosdb;

-- Conecta no banco de dados criado
\c carrosdb;

-- Cria a tabela carro 
CREATE TABLE carro (
    placa VARCHAR(10) PRIMARY KEY,
    ano INT NOT NULL,
    potencia INT NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL
);
