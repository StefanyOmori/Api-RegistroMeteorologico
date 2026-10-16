CREATE TABLE tb_registro (
    registro_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estacao_nome VARCHAR(150) NOT NULL,
    data_registro DATE NOT NULL,
    temperatura DOUBLE NOT NULL,
    percentual_umidade DOUBLE NOT NULL,
    precipitacao DOUBLE NOT NULL,
    condicao_climatica VARCHAR(30) NOT NULL
);
