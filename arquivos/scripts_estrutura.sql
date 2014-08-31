/*
create table cliente (
	id serial,
	nome text,
	numerochn text,
	apolice_seguro text,
	possui_contrato boolean,
	idade int,
	lista_negra boolean,
	PRIMARY KEY (id)
);

create table reserva (
	id serial,
	id_cliente BIGINT UNSIGNED NOT NULL,
	modelo text,
	grupo text,
	data_fim date,
	data_inicio date,
	PRIMARY KEY (id),
	CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente)
	REFERENCES cliente(id)
);


alter table cliente 
add column id_reserva BIGINT UNSIGNED NOT NULL;

alter table cliente
add constraint fk_id_reserva
foreign key (id_reserva)
references reserva(id);


alter table cliente 
modify column id_reserva BIGINT UNSIGNED;


create table locacao (
	id serial,
	id_reserva BIGINT UNSIGNED NOT NULL,
	id_carro BIGINT UNSIGNED NOT NULL,
	agente_de_locacao text,
	primary key(id),
	constraint fk_id_locacao_reserva 
	foreign key (id_reserva)
	references reserva(id)
);

create table carro (
	id serial,
	id_locacao BIGINT UNSIGNED,
	id_cliente BIGINT UNSIGNED,
	id_manutencao BIGINT UNSIGNED NOT NULL,
	grupo text,
	modelo text,
	fabricante text,
	disponivel boolean,
	necessita_de_conserto boolean,
	quilometragem double,
	ultima_revisao date,
	manutencao_no_dia boolean,
	filial text,
	primary key (id),
	
	constraint fk_id_locacao_carro 
	foreign key (id_locacao)
	references locacao(id),
	
	constraint fk_id_cliente_carro 
	foreign key (id_cliente)
	references cliente(id)
);


alter table cliente
add column id_carro BIGINT UNSIGNED;

alter table cliente
add constraint fk_id_carro_cliente
foreign key (id_carro)
references carro(id);


create table manutencao(
	id serial,
	data date,
	id_carro BIGINT UNSIGNED NOT NULL,
	primary key(id),
	constraint fk_id_manutencao_carro 
	foreign key (id_carro)
	references carro(id)
);

alter table carro
add constraint fk_id_carro_manutencao
foreign key (id_manutencao)
references carro(id);


create table pagamento (
	id serial,
	tarifa_de_retorno double,
	tarifa_de_danificacao double,
	tarifa_de_atraso double,
	forma_de_pagamento text,
	primary key (id)
);
*/