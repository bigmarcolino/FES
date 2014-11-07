package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="venda")
@NamedQuery(name="Venda.findAll", query="SELECT c FROM Venda c")
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venda")
	private String idVenda;
	
	@ManyToOne
	@JoinColumn(name="id_carro")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name="id_pagamento")
	private Pagamento pagamento;

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
}
