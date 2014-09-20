package controller.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Locacao {

	private IntegerProperty id;
	
	private StringProperty agenteDeLocacao;

	private Reserva reserva;

	private Carro carro;
	
	private Cliente cliente;
	
	private BooleanProperty ativo;
	
	private ObjectProperty<LocalDate> data;

	private Pagamento pagamento;

	private Motorista motorista;
	
	public void verificarCarrosCadastrados() {

	}

	public void verificarCarrosDisponiveis() {

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
	
	
	public LocalDate getData() {
		return data.get();
	}

	public void setData(LocalDate data) {
		this.data.set(data);
	}
	
	public ObjectProperty<LocalDate> dataProperty() {
        return data;
    }
	

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
	public Boolean getAtivo() {
		return ativo.get();
	}

	public void setAtivo(Boolean ativo) {
		this.ativo.set(ativo);
	}
	
	public BooleanProperty AtivoProperty() {
        return ativo;
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