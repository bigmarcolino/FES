package controller.view;

import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import controller.MainApp;

public class MainAppController {
	
	// Acordeon Alocar Imediato ------------------------------------------------------------------------------------------------------

	private ObservableList<String> dadosComboBoxGrupos_AlocarImediato = FXCollections.observableArrayList();
	private ObservableList<String> dadosComboBoxCarros_AlocarImediato = FXCollections.observableArrayList();
	
	@FXML
    private TextField nomeCliente_AlocarImediato;
	
	@FXML
    private ComboBox<String> grupoCarro_AlocarImediato;
	
	@FXML
    private ComboBox<String> carro_AlocarImediato;
	
	@FXML
    private DatePicker dataInicio_AlocarImediato;
	
	@FXML
    private DatePicker dataFim_AlocarImediato;
	
	@FXML
    private Label ok_AlocarImediato;
	
	@FXML
    private Button efetuarAlocacao_AlocarImediato;
	
	@FXML
    private Button limpar_AlocarImediato;
	
	// ---------------------------------------------------------------------------------------------------------------------------------
	
	private MainApp mainApp;
	
	public MainAppController() {
    }
	
    @FXML
    private void initialize() {
    	
    	//Lógica e inicialização de campos da Alocação Imediata ------------------------------------------------------------------------------
    	
    	TextFields.bindAutoCompletion(nomeCliente_AlocarImediato, "Hey", "Hello", "Hello World", "Apple", "Cool", "Costa", "Cola", "Coca Cola");

    	nomeCliente_AlocarImediato.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue && !nomeCliente_AlocarImediato.getText().equals(""))
		        {
		        	ok_AlocarImediato.setText("OK");
		        }
		    }
    	});
    	
    	dadosComboBoxGrupos_AlocarImediato.add("A");
    	dadosComboBoxGrupos_AlocarImediato.add("B");
    	dadosComboBoxGrupos_AlocarImediato.add("C");
    	dadosComboBoxGrupos_AlocarImediato.add("D");
    	dadosComboBoxGrupos_AlocarImediato.add("E");
    	
    	grupoCarro_AlocarImediato.setItems(dadosComboBoxGrupos_AlocarImediato);
    	
    	dadosComboBoxCarros_AlocarImediato.add("Fiat Uno");
    	dadosComboBoxCarros_AlocarImediato.add("Volkswagen Gol");
    	dadosComboBoxCarros_AlocarImediato.add("Chevrolet Camaro");
    	dadosComboBoxCarros_AlocarImediato.add("Ford New Fusion");
    	dadosComboBoxCarros_AlocarImediato.add("Ford Focus");
    	dadosComboBoxCarros_AlocarImediato.add("Audi R8");
    	
    	grupoCarro_AlocarImediato.setOnAction((event) -> {            
            carro_AlocarImediato.setItems(dadosComboBoxCarros_AlocarImediato);
        });
    	
    	LocalDate localDate = LocalDate.now();
    	dataInicio_AlocarImediato.setValue(localDate);
    	
    	efetuarAlocacao_AlocarImediato.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
    		        .showConfirm();

    		if (response == Dialog.Actions.OK) {
    			System.out.println("Enviei os dados");
    		}
    	});
    	
    	limpar_AlocarImediato.setOnAction((event) -> {
    		
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja limpar os campos?")
    		        .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
    		        .showConfirm();

    		if (response == Dialog.Actions.OK) {
    			nomeCliente_AlocarImediato.setText("");
        		grupoCarro_AlocarImediato.getSelectionModel().clearSelection();
        		carro_AlocarImediato.getSelectionModel().clearSelection();
        		dataFim_AlocarImediato.setValue(null);
        		ok_AlocarImediato.setText("");
    		}
    	});
    	
    	//---------------------------------------------------------------------------------------------------------------------------------------
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}