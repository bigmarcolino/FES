package controller.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Locacao {

	private IntegerProperty id;
	
	private StringProperty agenteDeLocacao;

	private Reserva reserva;

	private Carro carro;

	public void verificarCarrosCadastrados() {

	}

	public void verificarCarrosDisponíveis() {

	}

	public void verificarClientesCadastrados() {

	}

	public void registrar() {

	}

	public String getAgenteDeLocacao() {
		return agenteDeLocacao.get();
	}

	public void setAgenteDeLocacao(String agenteDeLocacao) {
		this.agenteDeLocacao.set(agenteDeLocacao);
	}
	
	public StringProperty agenteDeLocacaoProperty() {
        return agenteDeLocacao;
    }
	

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
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
}