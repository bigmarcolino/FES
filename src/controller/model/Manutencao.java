package controller.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class Manutencao {
	private IntegerProperty id;
	
	private ObjectProperty<LocalDate> data;

	private Carro carro;

	public void solicitar() {

	}

	public void enviar() {

	}

	public void retirar() {

	}

	public LocalDate getData() {
		return data.get();
	}

	public void setData(LocalDate data) {
		this.data.set(data);
	}
	
	public ObjectProperty<LocalDate> dataProperty() {
        return data;
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