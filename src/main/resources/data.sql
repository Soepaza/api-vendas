CREATE TABLE USERS (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,  -- Coluna ID é a chave primária, do tipo INTEGER, e será auto-incrementada automaticamente pelo banco de dados.
    NAME VARCHAR(255) NOT NULL,                      -- Coluna NAME armazena o nome do usuário, com um máximo de 255 caracteres.
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(64) NOT NULL,
    CPF VARCHAR(24) NOT NULL,
    CEP VARCHAR(24) NOT NULL,
    IS_ACTIVE BOOLEAN DEFAULT TRUE
);

criar 3 tabela para fazer o relacionametno entre o usuario e a lista de produtos dele


CREATE TABLE PRODUTOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    QUANTIDADE INT NOT NULL,
    PRECO BIGINT NOT NULL,
    IS_ACTIVE BOOLEAN DEFAULT TRUE,
    USER_ID INTEGER REFERENCES USERS(ID)
);

