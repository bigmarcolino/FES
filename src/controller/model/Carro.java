package controller.model;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Carro {

	private IntegerProperty id;
	
	private StringProperty grupo;

	private StringProperty modelo;

	private StringProperty fabricante;

	private BooleanProperty disponivel;

	private BooleanProperty necessitaDeConserto;

	private DoubleProperty quilometragem;

	private ObjectProperty<LocalDate> ultimaRevisao;

	private BooleanProperty manutencaoNoDia;

	private StringProperty filial;

	private Manutencao manutencao;

	private List<Locacao> locacao;

	private Cliente cliente;

	private BooleanProperty ativo;

	private StringProperty descricao;

	public String toString(){
		return fabricante + " " + modelo;
	}
	
	public void iniciarPropriedades() {
		if (necessitaDeConserto.get() || !(disponivel.get()))
			ativo.set(true);
		else
			ativo.set(false);

		if (necessitaDeConserto.get()) {
			descricao.set("Precisa de conserto!");
		}
		else if (!(disponivel.get())) {
			descricao.set("Carro indisponível!");
		}

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
	

	public boolean getDisponivel() {
		return disponivel.get();
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel.set(disponivel);
	}
	
	public BooleanProperty disponivelProperty() {
        return disponivel;
    }
	

	public boolean getNecessitaDeConserto() {
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
	
	
	public boolean getManutencaoNoDia() {
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
	

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	
	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
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