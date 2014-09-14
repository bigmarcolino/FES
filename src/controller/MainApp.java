package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import controller.model.Carro;
import controller.model.Cliente;
import controller.view.MainAppController;

public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Carro> carros = FXCollections.observableArrayList();
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    
    public MainApp() {
    	
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
		/*try {
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
				carro.setUltimaRevisao(resultado.getDate("ultima_revisao").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				carro.setManutencaoNoDia(resultado.getBoolean("manutencao_no_dia"));
				carro.setFilial(resultado.getString("filial"));

				carro.iniciarPropriedades();
				carros.add(carro);
			}
			resultado.close();
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
		}*/
    }
    
    public ObservableList<Carro> getPersonData() {
        return carros;
    }
    
	@Override
	public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	     this.primaryStage.setTitle("Você Aluga");
	     initRootLayout();
	     showInitialPage();
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showInitialPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/initialPage.fxml"));
            AnchorPane initialPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(initialPage);
            
           MainAppController controller = loader.getController();
           controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}