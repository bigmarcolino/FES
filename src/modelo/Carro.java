package modelo;

import java.util.Date;
import java.util.Collection;

public class Carro {

	private String grupo;

	private String modelo;

	private String fabricante;

	private boolean disponibilidade;

	private boolean necessitaDeConserto;

	private double quilometragem;

	private Date ultimaRevisao;

	private boolean manutencaoNoDia;

	private String filial;

	private Manutencao manutencao;

	private Collection<Locacao> locacao;

	private Cliente cliente;

}
