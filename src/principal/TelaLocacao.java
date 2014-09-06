package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Carro;
import modelo.Cliente;

@SuppressWarnings("deprecation")
public class TelaLocacao extends Application{
	List<Carro> carros = new ArrayList<Carro>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void carregaClientesCarros(){
		
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
	}
	
	public void start(Stage stage) throws Exception {
		carregaClientesCarros();
		
		stage.setTitle("Você-Aluga");
		
		Scene cena = new Scene(new Group(), 700, 250);
		
		TextField nome, diaInicio, mesInicio, anoInicio, 
			diaFim, mesFim, anoFim;
		Label lNome, lCarro, lInicio, lFim,lCliente;
		
        ComboBox<Cliente> clienteComboBox = new ComboBox<Cliente>();
        clienteComboBox.getItems().addAll(clientes);
        
        ComboBox<Carro> carroComboBox = new ComboBox<Carro>();
        carroComboBox.getItems().addAll(carros); 
		
		lNome = new Label("Nome:");
		nome = new TextField();
		lCarro = new Label("Selecione o carro:");
		lInicio = new Label("Data de início:");
		lFim = new Label("Data de fim:");
		lCliente = new Label("Selecione o cliente:");
		
		diaInicio = new TextField();
		mesInicio = new TextField();
		anoInicio  = new TextField();
		diaFim = new TextField();
		mesFim = new TextField();
		anoFim = new TextField();
		
		Button bSalvar = new Button("Salvar");
		
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(6,6, 5, 5));
        grid.add(lNome, 0, 0);
        grid.add(nome, 1, 0);
        grid.add(lCarro, 0, 1);
        grid.add(carroComboBox, 1,1,3,1);
        grid.add(lInicio, 0, 2);
        grid.add(diaInicio, 1, 2);
        grid.add(mesInicio, 2, 2);
        grid.add(anoInicio, 3, 2);
        
        grid.add(lFim, 0, 3);
        grid.add(diaFim, 1, 3);
        grid.add(mesFim, 2, 3);
        grid.add(anoFim, 3, 3);
        
        grid.add(lCliente, 0, 4);
        grid.add(clienteComboBox, 1,4,3,1);
        grid.add(bSalvar, 0, 5);
        
        Group raiz = (Group) cena.getRoot();
        raiz.getChildren().add(grid);
        stage.setScene(cena);
		stage.show();
		
		Stage manutencaoDialog = new Stage();
		manutencaoDialog.initModality(Modality.WINDOW_MODAL);
		manutencaoDialog.setScene(new Scene(VBoxBuilder.create().
		    children(new Text("O carro estará em manutenção nesse dia!"), new Button("Ok.")).
		    alignment(Pos.CENTER).padding(new Insets(5)).build()));		

		Stage sucessoDialog = new Stage();
		sucessoDialog.initModality(Modality.WINDOW_MODAL);
		sucessoDialog.setScene(new Scene(VBoxBuilder.create().
		    children(new Text("Locação feita com sucesso!"), new Button("Ok.")).
		    alignment(Pos.CENTER).padding(new Insets(5)).build()));
		
		bSalvar.setOnAction(evento -> {
			Cliente clienteSelecao = clienteComboBox.getValue();
			Carro carroSelecao = carroComboBox.getValue();
			
			String nomeAlocador = nome.getText();
			String anoFimT = anoFim.getText();
			String mesFimT = mesFim.getText();
			String diaFimT = diaFim.getText();
			String dataFim = String.format("%s-%s-%s", anoFimT, mesFimT, diaFimT);
			String anoInicioT = anoInicio.getText();
			String mesInicioT = mesInicio.getText();
			String diaInicioT = diaInicio.getText();
			String dataInicio = String.format("%s-%s-%s", anoInicioT, mesInicioT, diaInicioT);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date dInicio = null, dFim = null;
			try {
				dInicio = sdf.parse(String.format("%s-%s-%s", diaInicioT, mesInicioT, anoInicioT));
				dFim = sdf.parse(String.format("%s-%s-%s", diaFimT, mesFimT, anoFimT));
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
				/*if (){
					TODO verificar se o cliente e o carro estao ativos, os dois tem a propriedade boolean ativo 
				}
				else*/
				if (dataManutencao != null && (dataManutencao.equals(dInicio) || dataManutencao.equals(dFim)))
					manutencaoDialog.show();
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
					
					sucessoDialog.show();
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
		
		});
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
