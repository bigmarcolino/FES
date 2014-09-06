package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.Carro;
import modelo.Cliente;

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
        grid.add(carroComboBox, 1,4,3,1);
        grid.add(bSalvar, 0, 5);
        
        Group raiz = (Group) cena.getRoot();
        raiz.getChildren().add(grid);
        stage.setScene(cena);
		stage.show();
	}
}
