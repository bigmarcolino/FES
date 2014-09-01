package principal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carro;
import modelo.Cliente;

@WebServlet("/locacao")
public class LocacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocacaoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Carro> carros = new ArrayList<Carro>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
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

		// Connection conexao = BancoDeDados.conectar();
		ResultSet resultado = null;
		Statement comando = null;
		try {
			comando = conexao.createStatement();

			resultado = comando.executeQuery("select * from carro");

			while (resultado.next()) {
				Carro carro = new Carro();

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

				carro.iniciarPropriedades();
				carros.add(carro);
			}
			resultado.close();
			
			resultado = comando.executeQuery("select * from cliente");
			while (resultado.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(resultado.getInt("id"));
				cliente.setNumeroCNH(resultado.getString("numerocnh"));
				cliente.setApoliceSeguro(resultado.getString("apolice_seguro"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setDataLicenca(resultado.getDate("data_licenca"));
				cliente.setPossuiContrato(resultado.getBoolean("possui_contrato"));
				cliente.setIdade(resultado.getInt("idade"));
				cliente.setListaNegra(resultado.getBoolean("lista_negra"));
				cliente.iniciarPropriedades();
				clientes.add(cliente);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao acesssar o BD");
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

		request.setAttribute("clientes", clientes);
		request.setAttribute("carros", carros);
		request.getRequestDispatcher("/locacao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
