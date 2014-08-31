package modelo;

public class Locacao {

	private String agenteDeLocacao;

	private Reserva reserva;

	private Carro carro;

	public void verificarCarrosCadastrados() {

	}

	public void verificarCarrosDisponíveis() {

	}

	public void verificarClientesCadastrados() {

	}

	public void registrar() {

	}

	public String getAgenteDeLocacao() {
		return agenteDeLocacao;
	}

	public void setAgenteDeLocacao(String agenteDeLocacao) {
		this.agenteDeLocacao = agenteDeLocacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
