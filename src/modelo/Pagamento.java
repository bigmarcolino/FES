package modelo;

public class Pagamento {

	private double tarifaDeRetorno;

	private double tarifaDeDanificacao;

	private double tarifaDeAtraso;

	private String formaDePagamento;

	public void registrarPagamento() {

	}

	public double getTarifaDeRetorno() {
		return tarifaDeRetorno;
	}

	public void setTarifaDeRetorno(double tarifaDeRetorno) {
		this.tarifaDeRetorno = tarifaDeRetorno;
	}

	public double getTarifaDeDanificacao() {
		return tarifaDeDanificacao;
	}

	public void setTarifaDeDanificacao(double tarifaDeDanificacao) {
		this.tarifaDeDanificacao = tarifaDeDanificacao;
	}

	public double getTarifaDeAtraso() {
		return tarifaDeAtraso;
	}

	public void setTarifaDeAtraso(double tarifaDeAtraso) {
		this.tarifaDeAtraso = tarifaDeAtraso;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

}
