package controller.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Reserva {

	private IntegerProperty id;
	
	private StringProperty modelo;

	private StringProperty grupo;

	private ObjectProperty<LocalDate> dataFim;

	private ObjectProperty<LocalDate> dataInicio;

	private Locacao locacao;

	private Cliente cliente;

	public void criar() {

	}

	public void cancelar() {

	}

	public String getModelo() {
		return modelo.get();
	}

	public void setModelo(String modelo) {
		this.modelo.set(modelo);
	}
	
	public StringProperty modeloProperty() {
        return modelo;
    }
	

	public String getGrupo() {
		return grupo.get();
	}

	public void setGrupo(String grupo) {
		this.grupo.set(grupo);
	}
	
	public StringProperty grupoProperty() {
        return grupo;
    }
	

	public LocalDate getDataFim() {
		return dataFim.get();
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim.set(dataFim);
	}
	
	public ObjectProperty<LocalDate> dataFimProperty() {
        return dataFim;
    }
	

	public LocalDate getDataInicio() {
		return dataInicio.get();
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio.set(dataInicio);
	}
	
	public ObjectProperty<LocalDate> dataInicioProperty() {
        return dataInicio;
    }
	

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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