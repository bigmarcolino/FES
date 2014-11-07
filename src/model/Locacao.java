package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the locacao database table.
 * 
 */
@Entity
@Table(name="locacao")
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_locacao")
	private String idLocacao;

	@Lob
	@Column(name="agente_de_locacao")
	private String agenteDeLocacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_fim")
	private Date dataFim;

	@Column(name="id_carro")
	private String idCarro;

	@Column(name="id_pagamento")
	private String idPagamento;

	//bi-directional many-to-one association to CarroTemLocacao
	@OneToMany(mappedBy="locacao", fetch=FetchType.EAGER)
	private List<CarroTemLocacao> carroTemLocacaos;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Pagamento
	@OneToMany(mappedBy="locacao", fetch=FetchType.EAGER)
	private List<Pagamento> pagamentos;

	public Locacao() {
	}

	public String getIdLocacao() {
		return this.idLocacao;
	}

	public void setIdLocacao(String idLocacao) {
		this.idLocacao = idLocacao;
	}

	public String getAgenteDeLocacao() {
		return this.agenteDeLocacao;
	}

	public void setAgenteDeLocacao(String agenteDeLocacao) {
		this.agenteDeLocacao = agenteDeLocacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getIdCarro() {
		return this.idCarro;
	}

	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}

	public String getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public List<CarroTemLocacao> getCarroTemLocacaos() {
		return this.carroTemLocacaos;
	}

	public void setCarroTemLocacaos(List<CarroTemLocacao> carroTemLocacaos) {
		this.carroTemLocacaos = carroTemLocacaos;
	}

	public CarroTemLocacao addCarroTemLocacao(CarroTemLocacao carroTemLocacao) {
		getCarroTemLocacaos().add(carroTemLocacao);
		carroTemLocacao.setLocacao(this);

		return carroTemLocacao;
	}

	public CarroTemLocacao removeCarroTemLocacao(CarroTemLocacao carroTemLocacao) {
		getCarroTemLocacaos().remove(carroTemLocacao);
		carroTemLocacao.setLocacao(null);

		return carroTemLocacao;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setLocacao(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setLocacao(null);

		return pagamento;
	}

}