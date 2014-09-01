package modelo;

import java.util.Date;
import java.util.List;

public class Carro {

	private int id;
	
	private String grupo;

	private String modelo;

	private String fabricante;

	private boolean disponivel;

	private boolean necessitaDeConserto;

	private double quilometragem;

	private Date ultimaRevisao;

	private boolean manutencaoNoDia;

	private String filial;

	private Manutencao manutencao;

	private List<Locacao> locacao;

	private Cliente cliente;
	
	//----------------------
	
	private String ativo;
	
	private String descricao;
	
	public void iniciarPropriedades(){
		if (necessitaDeConserto || !disponivel)
			ativo = "disabled=\"disabled\""; 
		else
			ativo = "";
		
		descricao = "";
		if (necessitaDeConserto){
			descricao += "Precisa de conserto!";
		}
		else if (!disponivel){
			descricao += "Carro indisponível!";
		}
		
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isNecessitaDeConserto() {
		return necessitaDeConserto;
	}

	public void setNecessitaDeConserto(boolean necessitaDeConserto) {
		this.necessitaDeConserto = necessitaDeConserto;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Date getUltimaRevisao() {
		return ultimaRevisao;
	}

	public void setUltimaRevisao(Date ultimaRevisao) {
		this.ultimaRevisao = ultimaRevisao;
	}

	public boolean isManutencaoNoDia() {
		return manutencaoNoDia;
	}

	public void setManutencaoNoDia(boolean manutencaoNoDia) {
		this.manutencaoNoDia = manutencaoNoDia;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
