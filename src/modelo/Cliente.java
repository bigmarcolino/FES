package modelo;

import java.util.Date;
import java.util.List;

public class Cliente {

	private int id;
	
	private String numeroCNH;

	private String apoliceSeguro;

	private Date dataLicenca;

	private String nome;

	private boolean possuiContrato;

	private int idade;

	private List<Carro> carrosAlugados;

	private boolean listaNegra;

	private List<Reserva> reserva;

	private Carro carro;

	public void fazerReserva() {

	}

	public void cadastrar() {

	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public String getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(String apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPossuiContrato() {
		return possuiContrato;
	}

	public void setPossuiContrato(boolean possuiContrato) {
		this.possuiContrato = possuiContrato;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Carro> getCarrosAlugados() {
		return carrosAlugados;
	}

	public void setCarrosAlugados(List<Carro> carrosAlugados) {
		this.carrosAlugados = carrosAlugados;
	}

	public boolean isListaNegra() {
		return listaNegra;
	}

	public void setListaNegra(boolean listaNegra) {
		this.listaNegra = listaNegra;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
