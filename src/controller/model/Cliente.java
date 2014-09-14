package controller.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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
	private boolean ativo;
	
	private String descricao;
	
	public String toString(){
		return nome;
	}
	
	public void iniciarPropriedades(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataLicenca);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH) + 1;
		int ano = cal.get(Calendar.YEAR);
		long anos = ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia), LocalDate.now());
		
		if (anos < 1 || listaNegra)
			ativo = false; 
		else
			ativo = true;
		
		descricao = "";
		if (anos < 1){
			descricao += "A licensa atual tem duração menor que 1 ano!";
		}
		else if (listaNegra){
			descricao += "Esse cliente está na lista negra!";
		}
		
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
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
