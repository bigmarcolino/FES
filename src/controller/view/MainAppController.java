package controller.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import controller.MainApp;

public class MainAppController {

	// Acordeon Alocar Imediato -----------------
	@FXML
    private TextField nomeCliente_AlocarImediato;
	
	// ------------------------------------------
	
	private MainApp mainApp;
	
	public MainAppController() {
    }
	
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	nomeCliente_AlocarImediato.setText("abc");
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //nomeCliente_AlocarImediato.setText("aaaaa");    
    }
}
