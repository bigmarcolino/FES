package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente_tem_motorista database table.
 * 
 */
@Entity
@Table(name="cliente_tem_motorista")
@NamedQuery(name="ClienteTemMotorista.findAll", query="SELECT c FROM ClienteTemMotorista c")
public class ClienteTemMotorista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente_tem_motorista")
	private String idClienteTemMotorista;

	//bi-directional many-to-one association to Motorista
	@ManyToOne
	@JoinColumn(name="id_motorista")
	private Motorista motorista;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public ClienteTemMotorista() {
	}

	public String getIdClienteTemMotorista() {
		return this.idClienteTemMotorista;
	}

	public void setIdClienteTemMotorista(String idClienteTemMotorista) {
		this.idClienteTemMotorista = idClienteTemMotorista;
	}

	public Motorista getMotorista() {
		return this.motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}