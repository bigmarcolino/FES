package controller.model;

import java.util.Collection;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Cliente {

	private IntegerProperty id;

	private StringProperty nome;

	private StringProperty idade;

	private Collection<Locacao> locacao;

	private BooleanProperty listaNegra;

	private List<Reserva> reserva;

	private Carro carro;
	
	private Collection<Pagamento> pagamento;
	
	public void fazerReserva() {}

	public void cadastrar() {}
	

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
        return nome;
    }

	
	public String getIdade() {
		return idade.get();
	}

	public void setIdade(String idade) {
		this.idade.set(idade);
	}
	
	public StringProperty idadeProperty() {
        return idade;
    }
	

	public Collection<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(Collection<Locacao> locacao) {
		this.locacao = locacao;
	}
	
	
	public Collection<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(Collection<Pagamento> pagamento) {
		this.pagamento = pagamento;
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
}