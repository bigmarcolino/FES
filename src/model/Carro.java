package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carro database table.
 * 
 */
@Entity
@Table(name="carro")
@NamedQuery(name="Carro.findAll", query="SELECT c FROM Carro c")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carro")
	private String idCarro;

	private String ano;

	private boolean disponibilidade;

	@Lob
	private String fabricante;

	@Lob
	private String filial;

	@Lob
	private String grupo;

	@Lob
	private String modelo;

	@Column(name="necessita_de_conserto")
	private boolean necessitaDeConserto;

	private Double quilometragem;

	@Temporal(TemporalType.DATE)
	@Column(name="ultima_revisao")
	private Date ultimaRevisao;

	//bi-directional many-to-one association to CarroTemLocacao
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<CarroTemLocacao> carroTemLocacaos;

	//bi-directional many-to-one association to CarroTemReserva
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<CarroTemReserva> carroTemReservas;

	//bi-directional many-to-one association to Manutencao
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<Manutencao> manutencaos;

	public Carro() {
	}

	public String getIdCarro() {
		return this.idCarro;
	}

	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public boolean getDisponibilidade() {
		return this.disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getFilial() {
		return this.filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean getNecessitaDeConserto() {
		return this.necessitaDeConserto;
	}

	public void setNecessitaDeConserto(boolean necessitaDeConserto) {
		this.necessitaDeConserto = necessitaDeConserto;
	}

	public Double getQuilometragem() {
		return this.quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Date getUltimaRevisao() {
		return this.ultimaRevisao;
	}

	public void setUltimaRevisao(Date ultimaRevisao) {
		this.ultimaRevisao = ultimaRevisao;
	}

	public List<CarroTemLocacao> getCarroTemLocacaos() {
		return this.carroTemLocacaos;
	}

	public void setCarroTemLocacaos(List<CarroTemLocacao> carroTemLocacaos) {
		this.carroTemLocacaos = carroTemLocacaos;
	}

	public CarroTemLocacao addCarroTemLocacao(CarroTemLocacao carroTemLocacao) {
		getCarroTemLocacaos().add(carroTemLocacao);
		carroTemLocacao.setCarro(this);

		return carroTemLocacao;
	}

	public CarroTemLocacao removeCarroTemLocacao(CarroTemLocacao carroTemLocacao) {
		getCarroTemLocacaos().remove(carroTemLocacao);
		carroTemLocacao.setCarro(null);

		return carroTemLocacao;
	}

	public List<CarroTemReserva> getCarroTemReservas() {
		return this.carroTemReservas;
	}

	public void setCarroTemReservas(List<CarroTemReserva> carroTemReservas) {
		this.carroTemReservas = carroTemReservas;
	}

	public CarroTemReserva addCarroTemReserva(CarroTemReserva carroTemReserva) {
		getCarroTemReservas().add(carroTemReserva);
		carroTemReserva.setCarro(this);

		return carroTemReserva;
	}

	public CarroTemReserva removeCarroTemReserva(CarroTemReserva carroTemReserva) {
		getCarroTemReservas().remove(carroTemReserva);
		carroTemReserva.setCarro(null);

		return carroTemReserva;
	}

	public List<Manutencao> getManutencaos() {
		return this.manutencaos;
	}

	public void setManutencaos(List<Manutencao> manutencaos) {
		this.manutencaos = manutencaos;
	}

	public Manutencao addManutencao(Manutencao manutencao) {
		getManutencaos().add(manutencao);
		manutencao.setCarro(this);

		return manutencao;
	}

	public Manutencao removeManutencao(Manutencao manutencao) {
		getManutencaos().remove(manutencao);
		manutencao.setCarro(null);

		return manutencao;
	}

}