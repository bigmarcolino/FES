package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carro_tem_locacao database table.
 * 
 */
@Entity
@Table(name="carro_tem_locacao")
@NamedQuery(name="CarroTemLocacao.findAll", query="SELECT c FROM CarroTemLocacao c")
public class CarroTemLocacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carro_tem_locacao")
	private String idCarroTemLocacao;

	//bi-directional many-to-one association to Locacao
	@ManyToOne
	@JoinColumn(name="id_locacao")
	private Locacao locacao;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="id_carro")
	private Carro carro;

	public CarroTemLocacao() {
	}

	public String getIdCarroTemLocacao() {
		return this.idCarroTemLocacao;
	}

	public void setIdCarroTemLocacao(String idCarroTemLocacao) {
		this.idCarroTemLocacao = idCarroTemLocacao;
	}

	public Locacao getLocacao() {
		return this.locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}