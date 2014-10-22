package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carro_tem_reserva database table.
 * 
 */
@Entity
@Table(name="carro_tem_reserva")
@NamedQuery(name="CarroTemReserva.findAll", query="SELECT c FROM CarroTemReserva c")
public class CarroTemReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carro_tem_reserva")
	private String idCarroTemReserva;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="id_carro")
	private Carro carro;

	public CarroTemReserva() {
	}

	public String getIdCarroTemReserva() {
		return this.idCarroTemReserva;
	}

	public void setIdCarroTemReserva(String idCarroTemReserva) {
		this.idCarroTemReserva = idCarroTemReserva;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}