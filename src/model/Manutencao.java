package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the manutencao database table.
 * 
 */
@Entity
@Table(name="manutencao")
@NamedQuery(name="Manutencao.findAll", query="SELECT m FROM Manutencao m")
public class Manutencao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_manutencao")
	private String idManutencao;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="id_carro")
	private Carro carro;

	public Manutencao() {
	}

	public String getIdManutencao() {
		return this.idManutencao;
	}

	public void setIdManutencao(String idManutencao) {
		this.idManutencao = idManutencao;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}