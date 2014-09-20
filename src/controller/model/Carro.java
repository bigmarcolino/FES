package controller.model;

import java.time.LocalDate;
import java.util.Collection;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Carro {

	private IntegerProperty id;
	
	private StringProperty grupo;
	
	private StringProperty fabricante;

	private StringProperty modelo;

	private StringProperty ano;

	private BooleanProperty disponivel;

	private BooleanProperty necessitaDeConserto;

	private DoubleProperty quilometragem;

	private ObjectProperty<LocalDate> ultimaRevisao;

	private BooleanProperty manutencaoNoDia;

	private StringProperty filial;

	private Collection<Locacao> locacao;

	private Cliente cliente;

	private Reserva reserva;

	private Collection<Manutencao> manutencao;
	
	public String getNome() {
		return fabricante + " " + modelo;
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
	
	public String getAno() {
		return ano.get();
	}

	public void setAno(String ano) {
		this.ano.set(ano);
	}
	
	public StringProperty anoProperty() {
        return ano;
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
	

	public String getFabricante() {
		return fabricante.get();
	}

	public void setFabricante(String fabricante) {
		this.fabricante.set(fabricante);
	}
	
	public StringProperty fabricanteProperty() {
        return fabricante;
    }
	

	public boolean isDisponivel() {
		return disponivel.get();
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel.set(disponivel);
	}
	
	public BooleanProperty disponivelProperty() {
        return disponivel;
    }
	

	public boolean isNecessitaDeConserto() {
		return necessitaDeConserto.get();
	}

	public void setNecessitaDeConserto(boolean necessitaDeConserto) {
		this.necessitaDeConserto.set(necessitaDeConserto);
	}
	
	public BooleanProperty necessitaDeConsertoProperty() {
        return necessitaDeConserto;
    }

	
	public double getQuilometragem() {
		return quilometragem.get();
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem.set(quilometragem);
	}
	
	public DoubleProperty quilometragemProperty() {
        return quilometragem;
    }
	

	public LocalDate getUltimaRevisao() {
		return ultimaRevisao.get();
	}

	public void setUltimaRevisao(LocalDate ultimaRevisao) {
		this.ultimaRevisao.set(ultimaRevisao);
	}
	
	public ObjectProperty<LocalDate> ultimaRevisaoProperty() {
        return ultimaRevisao;
    }
	
	
	public boolean isManutencaoNoDia() {
		return manutencaoNoDia.get();
	}

	public void setManutencaoNoDia(boolean manutencaoNoDia) {
		this.manutencaoNoDia.set(manutencaoNoDia);
	}
	
	public BooleanProperty manutencaoNoDiaProperty() {
        return manutencaoNoDia;
    }

	
	public String getFilial() {
		return filial.get();
	}

	public void setFilial(String filial) {
		this.filial.set(filial);
	}
	
	public StringProperty filialProperty() {
        return filial;
    }

	
	public Collection<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(Collection<Locacao> locacao) {
		this.locacao = locacao;
	}
	
	
	public Collection<Manutencao> getManutencao() {
		return manutencao;
	}

	public void setManutencao(Collection<Manutencao> manutencao) {
		this.manutencao = manutencao;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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