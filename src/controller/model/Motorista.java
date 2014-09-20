package controller.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Motorista {
	
	private IntegerProperty id;
	
	private StringProperty CNH;

	private StringProperty idade;

	private StringProperty apoliceSeguros;

	private ObjectProperty<LocalDate> dataLicenca;

	private BooleanProperty possuiContrato;

	private StringProperty nome;

	private Locacao locacao;

	
	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}
	
	public IntegerProperty idProperty() {
        return id;
    }
	
	
	public String getCNH() {
		return CNH.get();
	}

	public void setCNH(String CNH) {
		this.CNH.set(CNH);
	}
	
	public StringProperty CNHProperty() {
        return CNH;
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
	
	
	public String getApoliceSeguros() {
		return apoliceSeguros.get();
	}

	public void setApoliceSeguros(String apoliceSeguros) {
		this.apoliceSeguros.set(apoliceSeguros);
	}
	
	public StringProperty apoliceSegurosProperty() {
        return apoliceSeguros;
    }
	
	
	public LocalDate getDataLicenca() {
		return dataLicenca.get();
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca.set(dataLicenca);
	}
	
	public ObjectProperty<LocalDate> dataLicencaProperty() {
        return dataLicenca;
    }
	
	
	public Boolean getPossuiContrato() {
		return possuiContrato.get();
	}

	public void setPossuiContrato(Boolean possuiContrato) {
		this.possuiContrato.set(possuiContrato);
	}
	
	public BooleanProperty possuiContratoProperty() {
        return possuiContrato;
    }
	
	
	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
        return nome;
    }
	
	
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
}