package controller.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class Reserva {

	private IntegerProperty id;

	private ObjectProperty<LocalDate> dataFim;

	private ObjectProperty<LocalDate> dataInicio;

	private Locacao locacao;

	private Cliente cliente;
	
	private Carro carro;

	private Pagamento pagamento;

	public void criar() {

	}

	public void cancelar() {

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
	
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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