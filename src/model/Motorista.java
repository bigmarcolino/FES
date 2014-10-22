package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the motorista database table.
 * 
 */
@Entity
@Table(name="motorista")
@NamedQuery(name="Motorista.findAll", query="SELECT m FROM Motorista m")
public class Motorista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_motorista")
	private String idMotorista;

	@Lob
	@Column(name="apolice_seguros")
	private String apoliceSeguros;

	@Lob
	private String cnh;

	@Temporal(TemporalType.DATE)
	@Column(name="data_licenca")
	private Date dataLicenca;

	@Column(name="id_cliente")
	private String idCliente;

	@Lob
	private String idade;

	@Lob
	private String nome;

	@Column(name="possui_contrato")
	private boolean possuiContrato;

	//bi-directional many-to-one association to ClienteTemMotorista
	@OneToMany(mappedBy="motorista", fetch=FetchType.EAGER)
	private List<ClienteTemMotorista> clienteTemMotoristas;

	public Motorista() {
	}

	public String getIdMotorista() {
		return this.idMotorista;
	}

	public void setIdMotorista(String idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getApoliceSeguros() {
		return this.apoliceSeguros;
	}

	public void setApoliceSeguros(String apoliceSeguros) {
		this.apoliceSeguros = apoliceSeguros;
	}

	public String getCnh() {
		return this.cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Date getDataLicenca() {
		return this.dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getPossuiContrato() {
		return this.possuiContrato;
	}

	public void setPossuiContrato(boolean possuiContrato) {
		this.possuiContrato = possuiContrato;
	}

	public List<ClienteTemMotorista> getClienteTemMotoristas() {
		return this.clienteTemMotoristas;
	}

	public void setClienteTemMotoristas(List<ClienteTemMotorista> clienteTemMotoristas) {
		this.clienteTemMotoristas = clienteTemMotoristas;
	}

	public ClienteTemMotorista addClienteTemMotorista(ClienteTemMotorista clienteTemMotorista) {
		getClienteTemMotoristas().add(clienteTemMotorista);
		clienteTemMotorista.setMotorista(this);

		return clienteTemMotorista;
	}

	public ClienteTemMotorista removeClienteTemMotorista(ClienteTemMotorista clienteTemMotorista) {
		getClienteTemMotoristas().remove(clienteTemMotorista);
		clienteTemMotorista.setMotorista(null);

		return clienteTemMotorista;
	}

}