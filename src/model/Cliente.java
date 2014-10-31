package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private String idCliente;

	@Column(name="id_motorista")
	private String idMotorista;

	@Lob
	private String idade;

	@Column(name="lista_negra")
	private boolean listaNegra;

	@Lob
	private String nome;
	
	@Lob
	private String cpf;

	//bi-directional many-to-one association to ClienteTemMotorista
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<ClienteTemMotorista> clienteTemMotoristas;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Locacao> locacaos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Reserva> reservas;

	public Cliente() {
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdMotorista() {
		return this.idMotorista;
	}

	public void setIdMotorista(String idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public boolean getListaNegra() {
		return this.listaNegra;
	}

	public void setListaNegra(boolean listaNegra) {
		this.listaNegra = listaNegra;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ClienteTemMotorista> getClienteTemMotoristas() {
		return this.clienteTemMotoristas;
	}

	public void setClienteTemMotoristas(List<ClienteTemMotorista> clienteTemMotoristas) {
		this.clienteTemMotoristas = clienteTemMotoristas;
	}

	public ClienteTemMotorista addClienteTemMotorista(ClienteTemMotorista clienteTemMotorista) {
		getClienteTemMotoristas().add(clienteTemMotorista);
		clienteTemMotorista.setCliente(this);

		return clienteTemMotorista;
	}

	public ClienteTemMotorista removeClienteTemMotorista(ClienteTemMotorista clienteTemMotorista) {
		getClienteTemMotoristas().remove(clienteTemMotorista);
		clienteTemMotorista.setCliente(null);

		return clienteTemMotorista;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setCliente(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setCliente(null);

		return locacao;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCliente(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCliente(null);

		return reserva;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}