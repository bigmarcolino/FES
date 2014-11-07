package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private String idReserva;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_reserva")
	private Date dataReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fim")
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Column(name="id_carro")
	private String idCarro;

	@Column(name="id_locacao")
	private String idLocacao;

	@Column(name="id_pagamento")
	private String idPagamento;

	//bi-directional many-to-one association to CarroTemReserva
	@OneToMany(mappedBy="reserva", fetch=FetchType.EAGER)
	private List<CarroTemReserva> carroTemReservas;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="reserva", fetch=FetchType.EAGER)
	private List<Locacao> locacaos;

	//bi-directional many-to-one association to Pagamento
	@OneToMany(mappedBy="reserva", fetch=FetchType.EAGER)
	private List<Pagamento> pagamentos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Reserva() {
	}

	public String getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	
	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getIdCarro() {
		return this.idCarro;
	}

	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}

	public String getIdLocacao() {
		return this.idLocacao;
	}

	public void setIdLocacao(String idLocacao) {
		this.idLocacao = idLocacao;
	}

	public String getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public List<CarroTemReserva> getCarroTemReservas() {
		return this.carroTemReservas;
	}

	public void setCarroTemReservas(List<CarroTemReserva> carroTemReservas) {
		this.carroTemReservas = carroTemReservas;
	}

	public CarroTemReserva addCarroTemReserva(CarroTemReserva carroTemReserva) {
		getCarroTemReservas().add(carroTemReserva);
		carroTemReserva.setReserva(this);

		return carroTemReserva;
	}

	public CarroTemReserva removeCarroTemReserva(CarroTemReserva carroTemReserva) {
		getCarroTemReservas().remove(carroTemReserva);
		carroTemReserva.setReserva(null);

		return carroTemReserva;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setReserva(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setReserva(null);

		return locacao;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setReserva(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setReserva(null);

		return pagamento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}