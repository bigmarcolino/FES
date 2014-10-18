CREATE TABLE carro (
 id_carro SERIAL,
 grupo text,
 modelo text,
 fabricante text,
 disponibilidade boolean,
 necessita_de_conserto boolean,
 quilometragem DOUBLE PRECISION,
 ultima_revisao DATE,
 filial text,
 ano VARCHAR(4),
 id_locacao BIGINT UNSIGNED,
 id_reserva BIGINT UNSIGNED,
 id_manutencao BIGINT UNSIGNED
);

ALTER TABLE carro ADD CONSTRAINT PK_carro PRIMARY KEY (id_carro);


CREATE TABLE cliente (
 id_cliente SERIAL,
 nome text,
 idade text,
 lista_negra boolean,
 id_locacao BIGINT UNSIGNED,
 id_reserva BIGINT UNSIGNED,
 id_motorista BIGINT UNSIGNED
);

ALTER TABLE cliente ADD CONSTRAINT PK_cliente PRIMARY KEY (id_cliente);


CREATE TABLE locacao (
 id_locacao SERIAL,
 agente_de_locacao text,
 data DATE,
 ativo boolean,
 id_pagamento BIGINT UNSIGNED,
 id_reserva BIGINT UNSIGNED,
 id_cliente BIGINT UNSIGNED,
 id_carro BIGINT UNSIGNED
);

ALTER TABLE locacao ADD CONSTRAINT PK_locacao PRIMARY KEY (id_locacao);


CREATE TABLE manutencao (
 id_manutencao SERIAL,
 data DATE,
 id_carro BIGINT UNSIGNED
);

ALTER TABLE manutencao ADD CONSTRAINT PK_manutencao PRIMARY KEY (id_manutencao);


CREATE TABLE motorista (
 id_motorista SERIAL,
 cnh text,
 idade text,
 apolice_seguros text,
 data_licenca DATE,
 possui_contrato boolean,
 nome text,
 id_cliente BIGINT UNSIGNED
);

ALTER TABLE motorista ADD CONSTRAINT PK_motorista PRIMARY KEY (id_motorista);


CREATE TABLE pagamento (
 id_pagamento SERIAL,
 tarifa_de_retorno DOUBLE PRECISION,
 tarifa_de_danificacao DOUBLE PRECISION,
 tarifa_de_atraso DOUBLE PRECISION,
 forma_de_pagamento text,
 data DATE,
 id_locacao BIGINT UNSIGNED,
 id_reserva BIGINT UNSIGNED
);

ALTER TABLE pagamento ADD CONSTRAINT PK_pagamento PRIMARY KEY (id_pagamento);


CREATE TABLE reserva (
 id_reserva SERIAL,
 data_fim DATE,
 data_inicio DATE,
 id_locacao BIGINT UNSIGNED,
 id_cliente BIGINT UNSIGNED,
 id_carro BIGINT UNSIGNED,
 id_pagamento BIGINT UNSIGNED
);

ALTER TABLE reserva ADD CONSTRAINT PK_reserva PRIMARY KEY (id_reserva);


ALTER TABLE carro ADD CONSTRAINT FK_carro_0 FOREIGN KEY (id_locacao) REFERENCES locacao (id_locacao);
ALTER TABLE carro ADD CONSTRAINT FK_carro_1 FOREIGN KEY (id_reserva) REFERENCES reserva (id_reserva);
ALTER TABLE carro ADD CONSTRAINT FK_carro_3 FOREIGN KEY (id_manutencao) REFERENCES manutencao (id_manutencao);


ALTER TABLE cliente ADD CONSTRAINT FK_cliente_0 FOREIGN KEY (id_locacao) REFERENCES locacao (id_locacao);
ALTER TABLE cliente ADD CONSTRAINT FK_cliente_1 FOREIGN KEY (id_reserva) REFERENCES reserva (id_reserva);
ALTER TABLE cliente ADD CONSTRAINT FK_cliente_3 FOREIGN KEY (id_motorista) REFERENCES motorista (id_motorista);


ALTER TABLE locacao ADD CONSTRAINT FK_locacao_0 FOREIGN KEY (id_pagamento) REFERENCES pagamento (id_pagamento);
ALTER TABLE locacao ADD CONSTRAINT FK_locacao_1 FOREIGN KEY (id_reserva) REFERENCES reserva (id_reserva);
ALTER TABLE locacao ADD CONSTRAINT FK_locacao_2 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);
ALTER TABLE locacao ADD CONSTRAINT FK_locacao_3 FOREIGN KEY (id_carro) REFERENCES carro (id_carro);


ALTER TABLE manutencao ADD CONSTRAINT FK_manutencao_0 FOREIGN KEY (id_carro) REFERENCES carro (id_carro);


ALTER TABLE motorista ADD CONSTRAINT FK_motorista_0 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);


ALTER TABLE pagamento ADD CONSTRAINT FK_pagamento_0 FOREIGN KEY (id_locacao) REFERENCES locacao (id_locacao);
ALTER TABLE pagamento ADD CONSTRAINT FK_pagamento_1 FOREIGN KEY (id_reserva) REFERENCES reserva (id_reserva);


ALTER TABLE reserva ADD CONSTRAINT FK_reserva_0 FOREIGN KEY (id_locacao) REFERENCES locacao (id_locacao);
ALTER TABLE reserva ADD CONSTRAINT FK_reserva_1 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);
ALTER TABLE reserva ADD CONSTRAINT FK_reserva_2 FOREIGN KEY (id_carro) REFERENCES carro (id_carro);
ALTER TABLE reserva ADD CONSTRAINT FK_reserva_3 FOREIGN KEY (id_pagamento) REFERENCES pagamento (id_pagamento);


