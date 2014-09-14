package controller.model;

import java.util.Date;

public class Manutencao {
	private int id;
	
	private Date data;

	private Carro carro;

	public void solicitar() {

	}

	public void enviar() {

	}

	public void retirar() {

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
