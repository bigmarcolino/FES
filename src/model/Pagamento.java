package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pagamento database table.
 * 
 */
@Entity
@Table(name="pagamento")
@NamedQuery(name="Pagamento.findAll", query="SELECT p FROM Pagamento p")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pagamento")
	private String idPagamento;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	@Column(name="forma_de_pagamento")
	private String formaDePagamento;

	@Column(name="tarifa_de_atraso")
	private Double tarifaDeAtraso;

	@Column(name="tarifa_de_danificacao")
	private Double tarifaDeDanificacao;

	@Column(name="tarifa_de_retorno")
	private Double tarifaDeRetorno;
	
	@Lob
	@Column(name="dinheiro_cartao")
	private String dinheiroCartao;

	@Lob
	@Column(name="credito_debito")
	private String creditoDebito;
	
	@Lob
	private Integer parcelamento;
	
	@Column(name="tarifa_desconto")
	private Double tarifaDesconto;
	
	@Column(name="valor_total")
	private Double valorTotal;
	
	//bi-directional many-to-one association to Locacao
	@ManyToOne
	@JoinColumn(name="id_locacao")
	private Locacao locacao;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;
	
	@OneToMany(mappedBy="pagamento", fetch=FetchType.EAGER)
	private List<Venda> vendas;

	public Pagamento() {
	}

	public String getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFormaDePagamento() {
		return this.formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Double getTarifaDeAtraso() {
		return this.tarifaDeAtraso;
	}

	public void setTarifaDeAtraso(Double tarifaDeAtraso) {
		this.tarifaDeAtraso = tarifaDeAtraso;
	}

	public Double getTarifaDeDanificacao() {
		return this.tarifaDeDanificacao;
	}

	public void setTarifaDeDanificacao(Double tarifaDeDanificacao) {
		this.tarifaDeDanificacao = tarifaDeDanificacao;
	}

	public Double getTarifaDeRetorno() {
		return this.tarifaDeRetorno;
	}

	public void setTarifaDeRetorno(Double tarifaDeRetorno) {
		this.tarifaDeRetorno = tarifaDeRetorno;
	}

	public Locacao getLocacao() {
		return this.locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public String getDinheiroCartao() {
		return dinheiroCartao;
	}

	public void setDinheiroCartao(String dinheiroCartao) {
		this.dinheiroCartao = dinheiroCartao;
	}

	public String getCreditoDebito() {
		return creditoDebito;
	}

	public void setCreditoDebito(String creditoDebito) {
		this.creditoDebito = creditoDebito;
	}

	public Integer getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Integer parcelamento) {
		this.parcelamento = parcelamento;
	}

	public Double getTarifaDesconto() {
		return tarifaDesconto;
	}

	public void setTarifaDesconto(Double tarifaDesconto) {
		this.tarifaDesconto = tarifaDesconto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}