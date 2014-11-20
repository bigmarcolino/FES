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
	private String valor;
	
	@Lob
	private String placa;

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
	
	//bi-directional many-to-one association to ClienteTemCarro
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<ClienteTemCarro> clienteTemCarros;
	
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<Manutencao> manutencaos;

	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<Venda> vendas;
	
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
	
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
	
	public String getNome(){
		return getFabricante() + " " + getModelo();
	}

	public Manutencao removeManutencao(Manutencao manutencao) {
		getManutencaos().remove(manutencao);
		manutencao.setCarro(null);

		return manutencao;
	}

	public List<ClienteTemCarro> getClienteTemCarros() {
		return clienteTemCarros;
	}

	public void setClienteTemCarros(List<ClienteTemCarro> clienteTemCarros) {
		this.clienteTemCarros = clienteTemCarros;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public boolean equals (Object obj){
		if (!(obj instanceof Carro))
			return false;
		Carro carro = (Carro) obj;
		if (carro.getIdCarro() == null || this.idCarro == null)
			return false; 
		// ATENCAO: esse metodo soh deve ser chamado depois de salvar o objeto no banco,
		// dessa forma os dois objetos terao id, a verificação acima eh soh pra nao dah erro de nullpointer,
		// caso vc chame o equals para o objeto sem id
		return this.idCarro.equals(carro.getIdCarro());
	}
	
	//se vc usar HashMap ou LinkedHashSet no seu codigo, o metodo abaixo tambem deve ser implementado
	public int hashCode() {
		if (this.idCarro == null)
			return super.hashCode(); //de novo, soh pra nao dah nullpointer, mas eh a msma explicacao do problema acima
		else
			return this.idCarro.hashCode();
	}
	
	public boolean ehCompletamenteIgual(Carro carro){
		boolean resposta = true;
		resposta &= this.idCarro == null ? carro.getIdCarro() == null : this.idCarro.equals(carro.getIdCarro());
		resposta &= ano == null ? carro.getAno() == null : this.getAno().equals(carro.getAno());
		resposta &= disponibilidade == carro.getDisponibilidade();
		resposta &= fabricante == null ? carro.getAno() == null : this.getFabricante().equals(carro.getFabricante());
		resposta &= filial == null ? carro.getFilial() == null : this.getFilial().equals(carro.getFilial());
		resposta &= valor == null ? carro.getValor() == null : this.getValor().equals(carro.getValor());
		resposta &= placa == null ? carro.getPlaca() == null : this.getPlaca().equals(carro.getPlaca());
		resposta &= modelo == null ? carro.getModelo() == null : this.getModelo().equals(carro.getModelo());
		resposta &= necessitaDeConserto == carro.getNecessitaDeConserto();
		resposta &= quilometragem == null ? carro.getQuilometragem() == null : this.getQuilometragem().equals(carro.getQuilometragem());
		resposta &= ultimaRevisao == null ? carro.getUltimaRevisao() == null : this.getUltimaRevisao().equals(carro.getUltimaRevisao());
		// se vc quisesse ser mais meticuloso, vc poderia comparar as listas manutencaos, vendas, etc e 
		// ver se elas tambem sao iguais, mas eh mto trabalho pra esse trabalhinho tosco...
		return resposta;
	}
}