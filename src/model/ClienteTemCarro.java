package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente_tem_Carro database table.
 * 
 */
@Entity
@Table(name="cliente_tem_carro")
@NamedQuery(name="ClienteTemCarro.findAll", query="SELECT c FROM ClienteTemCarro c")
public class ClienteTemCarro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente_tem_carro")
	private String idClienteTemCarro;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="id_Carro")
	private Carro Carro;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public ClienteTemCarro() {
	}

	public String getIdClienteTemCarro() {
		return this.idClienteTemCarro;
	}

	public void setIdClienteTemCarro(String idClienteTemCarro) {
		this.idClienteTemCarro = idClienteTemCarro;
	}

	public Carro getCarro() {
		return this.Carro;
	}

	public void setCarro(Carro Carro) {
		this.Carro = Carro;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}