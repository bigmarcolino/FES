package principal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carro;
import modelo.Cliente;

@WebServlet("/salvarAlocacao")
public class SalvarAlocacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarAlocacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("sel_cliente");
		Cliente clienteSelecao = getClienteById(idCliente);
		
		String idCarro = request.getParameter("sel_carro");
		Carro carroSelecao = getCarroById(idCarro);
		
		String nomeAlocador = request.getParameter("nome");
		String anoFim = request.getParameter("ano_fim");
		String mesFim = request.getParameter("mes_fim");
		String diaFim = request.getParameter("dia_fim");
		String dataFim = String.format("%s-%s-%s", anoFim, mesFim, diaFim);
		String anoInicio = request.getParameter("ano_inicio");
		String mesInicio = request.getParameter("mes_inicio");
		String diaInicio = request.getParameter("dia_inicio");
		String dataInicio = String.format("%s-%s-%s", anoInicio, mesInicio, diaInicio);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dInicio = null, dFim = null;
		try {
			dInicio = sdf.parse(String.format("%s-%s-%s", diaInicio, mesInicio, anoInicio));
			dFim = sdf.parse(String.format("%s-%s-%s", diaFim, mesFim, anoFim));
		}
		catch (ParseException e2) {
			System.out.println(dInicio);
			System.out.println(dFim);
			e2.printStackTrace();
		}

		PreparedStatement comandoEditavel = null;
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", BD.URL,
					BD.PORTA, BD.NOME_BD, BD.USUARIO, BD.SENHA));
		}
		catch (SQLException e1) {
			System.out.println("Erro ao abrir a conexao");
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver nao encontrado");
			e.printStackTrace();
		}

		ResultSet resultado = null;
		Statement comando = null;
		try {
			comando = conexao.createStatement();
			resultado = comando.executeQuery("select * from manutencao where id_carro = " + carroSelecao.getId());
			Date dataManutencao = null;
			if (resultado.first())
				dataManutencao = resultado.getDate("data");
			resultado.close();
			
			System.out.println(dataManutencao);
			if (dataManutencao != null && (dataManutencao.equals(dInicio) || dataManutencao.equals(dFim)))
				response.getWriter().write("O carro estará em manuteção nesse dia! ");
			else {

				comandoEditavel = conexao.prepareStatement("insert into reserva (modelo, grupo, data_inicio, data_fim, id_cliente) "
						+ "values (?, ?, ?, ? , ?)");

				comandoEditavel.setString(1, carroSelecao.getModelo());
				comandoEditavel.setString(2, carroSelecao.getGrupo());
				comandoEditavel.setString(3, dataInicio);
				comandoEditavel.setString(4, dataFim);
				comandoEditavel.setInt(5, clienteSelecao.getId());
				comandoEditavel.executeUpdate();
				

				resultado = comando.executeQuery("select max(id) as m from reserva");
				resultado.first();
				int idTopo = Integer.parseInt(resultado.getString("m"));

				comandoEditavel = conexao
						.prepareStatement("insert into locacao (agente_de_locacao, id_carro, id_reserva) "
								+ "values (?, ?, ?)");

				comandoEditavel.setString(1, nomeAlocador);
				comandoEditavel.setInt(2, carroSelecao.getId());
				comandoEditavel.setInt(3, idTopo);
				comandoEditavel.executeUpdate();
				
				response.getWriter().write("Locação feita com sucesso! ");
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao acesssar o BD C");
		}
		finally {
			try {
				if (resultado != null)
					resultado.close();
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			catch (SQLException e) {
				System.out.println("Erro ao fechar a conexao");
				e.printStackTrace();
			}

		}
		// response.getWriter().write("ID selecionada: " + id);
	}

	public Carro getCarroById(String idCarro) {
		Carro carro = new Carro();
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", BD.URL,
					BD.PORTA, BD.NOME_BD, BD.USUARIO, BD.SENHA));
		}
		catch (SQLException e1) {
			System.out.println("Erro ao abrir a conexao");
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver nao encontrado");
			e.printStackTrace();
		}

		ResultSet resultado = null;
		Statement comando = null;
		try {
			comando = conexao.createStatement();

			resultado = comando.executeQuery("select * from carro where id = " + idCarro);

			resultado.next();
			carro.setId(resultado.getInt("id"));
			carro.setGrupo(resultado.getString("grupo"));
			carro.setModelo(resultado.getString("modelo"));
			carro.setFabricante(resultado.getString("fabricante"));
			carro.setDisponivel(resultado.getBoolean("disponivel"));
			carro.setNecessitaDeConserto(resultado.getBoolean("necessita_de_conserto"));
			carro.setQuilometragem(resultado.getDouble("quilometragem"));
			carro.setUltimaRevisao(resultado.getDate("ultima_revisao"));
			carro.setManutencaoNoDia(resultado.getBoolean("manutencao_no_dia"));
			carro.setFilial(resultado.getString("filial"));
			
			resultado.close();

		}
		catch (SQLException e) {
			System.out.println("Erro ao acesssar o BD B");
		}
		finally {
			try {
				if (resultado != null)
					resultado.close();
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			catch (SQLException e) {
				System.out.println("Erro ao fechar a conexao");
				e.printStackTrace();
			}

		}
		return carro;
	}

	public Cliente getClienteById(String idCliente) {
		Cliente cliente = new Cliente();
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", BD.URL,
					BD.PORTA, BD.NOME_BD, BD.USUARIO, BD.SENHA));
		}
		catch (SQLException e1) {
			System.out.println("Erro ao abrir a conexao");
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver nao encontrado");
			e.printStackTrace();
		}

		ResultSet resultado = null;
		Statement comando = null;
		try {
			comando = conexao.createStatement();

			resultado = comando.executeQuery("select * from cliente where id = " + idCliente);

			resultado.next();
			cliente.setId(resultado.getInt("id"));
			cliente.setNumeroCNH(resultado.getString("numerocnh"));
			cliente.setApoliceSeguro(resultado.getString("apolice_seguro"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setDataLicenca(resultado.getDate("data_licenca"));
			cliente.setPossuiContrato(resultado.getBoolean("possui_contrato"));
			cliente.setIdade(resultado.getInt("idade"));
			cliente.setListaNegra(resultado.getBoolean("lista_negra"));
			cliente.iniciarPropriedades();
			resultado.close();

		}
		catch (SQLException e) {
			System.out.println("Erro ao acesssar o BD A");
		}
		finally {
			try {
				if (resultado != null)
					resultado.close();
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			catch (SQLException e) {
				System.out.println("Erro ao fechar a conexao");
				e.printStackTrace();
			}

		}
		return cliente;
	}
}
