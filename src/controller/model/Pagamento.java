package controller.model;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Pagamento {

	private IntegerProperty id;
	
	private DoubleProperty tarifaDeRetorno;

	private DoubleProperty tarifaDeDanificacao;

	private DoubleProperty tarifaDeAtraso;

	private StringProperty formaDePagamento;
	
	private ObjectProperty<LocalDate> data;

	public void registrarPagamento() {

	}

	public double getTarifaDeRetorno() {
		return tarifaDeRetorno.get();
	}

	public void setTarifaDeRetorno(double tarifaDeRetorno) {
		this.tarifaDeRetorno.set(tarifaDeRetorno);
	}
	
	public DoubleProperty tarifaDeRetornoProperty() {
        return tarifaDeRetorno;
    }
	

	public double getTarifaDeDanificacao() {
		return tarifaDeDanificacao.get();
	}

	public void setTarifaDeDanificacao(double tarifaDeDanificacao) {
		this.tarifaDeDanificacao.set(tarifaDeDanificacao);
	}
	
	public DoubleProperty tarifaDeDanificacaoProperty() {
        return tarifaDeRetorno;
    }
	

	public double getTarifaDeAtraso() {
		return tarifaDeAtraso.get();
	}

	public void setTarifaDeAtraso(double tarifaDeAtraso) {
		this.tarifaDeAtraso.set(tarifaDeAtraso);
	}
	
	public DoubleProperty tarifaDeAtrasoProperty() {
        return tarifaDeRetorno;
    }
	

	public String getFormaDePagamento() {
		return formaDePagamento.get();
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento.set(formaDePagamento);
	}
	
	public StringProperty formaDePagamentoProperty() {
        return formaDePagamento;
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