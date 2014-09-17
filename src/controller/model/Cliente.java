package controller.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Cliente {

	private IntegerProperty id;
	
	private StringProperty numeroCNH;

	private StringProperty apoliceSeguro;

	private ObjectProperty<LocalDate> dataLicenca;

	private StringProperty nome;

	private BooleanProperty possuiContrato;

	private IntegerProperty idade;

	private List<Carro> carrosAlugados;

	private BooleanProperty listaNegra;

	private List<Reserva> reserva;

	private Carro carro;
	
	private BooleanProperty ativo;
	
	private StringProperty descricao;
	
	public void fazerReserva() {}

	public void cadastrar() {}
	
	public String toString(){
		return nome.get();
	}
	
	public void iniciarPropriedades(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(Date.from(dataLicenca.get().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH) + 1;
		int ano = cal.get(Calendar.YEAR);
		long anos = ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia), LocalDate.now());
		
		if (anos < 1 || listaNegra.get())
			ativo.set(false); 
		else
			ativo.set(true);
		
		descricao.set("");
		if (anos < 1){
			descricao.set("A licensa atual tem duração menor que 1 ano!");
		}
		else if (listaNegra.get()){
			descricao.set("Esse cliente está na lista negra!");
		}
		
	}
	
	public String getNumeroCNH() {
		return numeroCNH.get();
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH.set(numeroCNH);
	}
	
	public StringProperty numeroCNHProperty() {
        return numeroCNH;
    }
	

	public String getApoliceSeguro() {
		return apoliceSeguro.get();
	}

	public void setApoliceSeguro(String apoliceSeguro) {
		this.apoliceSeguro.set(apoliceSeguro);
	}
	
	public StringProperty apoliceSeguroProperty() {
        return apoliceSeguro;
    }
	

	public LocalDate getDataLicenca() {
		return dataLicenca.get();
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca.set(dataLicenca);
	}
	
	public ObjectProperty<LocalDate> dataLicencaProperty() {
        return dataLicenca;
    }
	

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
        return nome;
    }
	

	public boolean isPossuiContrato() {
		return possuiContrato.get();
	}

	public void setPossuiContrato(boolean possuiContrato) {
		this.possuiContrato.set(possuiContrato);
	}

	public BooleanProperty possuiContratoProperty() {
        return possuiContrato;
    }
	
	
	public int getIdade() {
		return idade.get();
	}

	public void setIdade(int idade) {
		this.idade.set(idade);
	}
	
	public IntegerProperty idadeProperty() {
        return idade;
    }
	

	public List<Carro> getCarrosAlugados() {
		return carrosAlugados;
	}

	public void setCarrosAlugados(List<Carro> carrosAlugados) {
		this.carrosAlugados = carrosAlugados;
	}

	
	public boolean isListaNegra() {
		return listaNegra.get();
	}

	public void setListaNegra(boolean listaNegra) {
		this.listaNegra.set(listaNegra);
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
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}
	
	public IntegerProperty idProperty() {
        return id;
    }
	
	
	public boolean getAtivo() {
		return ativo.get();
	}

	public void setAtivo(boolean ativo) {
		this.ativo.set(ativo);
	}
	
	public BooleanProperty ativoProperty() {
        return ativo;
    }
	

	public String getDescricao() {
		return descricao.get();
	}

	public void setDescricao(String descricao) {
		this.descricao.set(descricao);
	}
	
	public StringProperty descricaoProperty() {
        return descricao;
    }
}