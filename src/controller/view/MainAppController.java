package controller.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Carro;
import model.Cliente;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import controller.Controlador;
import controller.MainApp;

public class MainAppController {
	// atributos do acordeon Pagar ------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_Pagar;
	
	@FXML
    private RadioButton dinheiro_Pagar;
	
	@FXML
    private RadioButton cartao_Pagar;
	
	@FXML
    private ComboBox<String> danificacao_Pagar;
	
	@FXML
    private TextField valorDanificacao_Pagar;
	
	@FXML
    private ComboBox<String> retorno_Pagar;
	
	@FXML
    private ComboBox<String> filiais_Pagar;
	
	@FXML
    private TextField valorRetorno_Pagar;
	
	@FXML
    private ComboBox<String> desconto_Pagar;
	
	@FXML
    private TextField valorDesconto_Pagar;
	
	@FXML
    private ComboBox<String> formaDePagamento_Pagar;
	
	@FXML
    private ComboBox<String> creditoDebito_Pagar;
	
	@FXML
    private ComboBox<Integer> parcelamento_Pagar;
	
	@FXML
    private TextField valor_Pagar;
	
	@FXML
    private Button pagar_Pagar;
	
	@FXML
    private Button limpar_Pagar;
	
	@FXML
    private Label totalPagar_Pagar;
	
	@FXML
    private Label aviso_Pagar;
	// fim dos atributos do acordeon Pagar ---------------------------------------------------------------------------------------------------
	
	
	// atributos do acordeon Cadastrar Cliente ------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_CadastrarCliente;
	
	@FXML
    private TextField cpf_CadastrarCliente;
	
	@FXML
    private TextField idade_CadastrarCliente;
	
	@FXML
    private ImageView img_clienteExiste_CadastrarCliente;
	
	@FXML
    private Label clienteExiste_CadastrarCliente;
	
	@FXML
    private ImageView img_cpfInvalido_CadastrarCliente;
	
	@FXML
    private Label cpfInvalido_CadastrarCliente;
	
	@FXML
    private Button cadastrar_CadastrarCliente;
	
	@FXML
    private Button limpar_CadastrarCliente;
	
	@FXML
    private Label aviso_CadastrarCliente;
	// fim dos atributos do acordeon CadastrarCliente ---------------------------------------------------------------------------------------------------
	
	
	// atributos do acordeon Reservar Antecipado --------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_ReservarAntecipado;
	
	@FXML
    private ComboBox<String> filial_ReservarAntecipado;
	
	@FXML
    private ComboBox<String> grupoCarro_ReservarAntecipado;
	
	@FXML
    private ComboBox<String> carro_ReservarAntecipado;
	
	@FXML
    private DatePicker dataInicio_ReservarAntecipado;
	
	@FXML
    private DatePicker dataFim_ReservarAntecipado;
	
	@FXML
    private ImageView img_listaNegra_ReservarAntecipado;
	
	@FXML
    private Label listaNegra_ReservarAntecipado;
	
	@FXML
    private Button efetuarReserva_ReservarAntecipado;
	
	@FXML
    private Button limpar_ReservarAntecipado;
	
	@FXML
    private Label aviso_ReservarAntecipado;
	// fim dos atributos acorderon Reservar Antecipado -----------------------------------------------------------------------------------------------
	
	
	// atributos do acordeon Alocar Imediato ------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_AlocarImediato;
	
	@FXML
    private ComboBox<String> filial_AlocarImediato;
	
	@FXML
    private ComboBox<String> grupoCarro_AlocarImediato;
	
	@FXML
    private ComboBox<String> carro_AlocarImediato;
	
	@FXML
    private DatePicker dataInicio_AlocarImediato;
	
	@FXML
    private DatePicker dataFim_AlocarImediato;
	
	@FXML
    private ImageView img_listaNegra_AlocarImediato;
	
	@FXML
    private Label listaNegra_AlocarImediato;
	
	@FXML
    private Button efetuarAlocacao_AlocarImediato;
	
	@FXML
    private Button limpar_AlocarImediato;
	
	@FXML
    private Label aviso_AlocarImediato;
	// fim dos atributos do acordeon Alocar Imediato ---------------------------------------------------------------------------------------------------
	
	
	// atributos do acordeon Vender --------------------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_Vender;
	
	@FXML
    private ComboBox<String> carro_Vender;
	
	@FXML
    private ImageView img_listaNegra_Vender;
	
	@FXML
    private Label listaNegra_Vender;
	
	@FXML
    private Button vender_Vender;
	
	@FXML
    private Button limpar_Vender;
	
	@FXML
    private Label aviso_Vender;
	// fim dos atributos do acordeon Vender -------------------------------------------------------------------------------------------------------------
	
	private MainApp mainApp;
	
	public MainAppController() {
    }
	
    @FXML
    private void initialize() {
    	// variáveis globais dos acordeons----------------------------------------------------------------------------------------------------------------
    	List<Cliente> clientes = Controlador.listaClientes();
    	Collection<String> sugestoesClientes = new ArrayList<String>();
    	HashMap<String,Cliente> mapClientes = new HashMap<String,Cliente>();

    	for (Cliente cliente : clientes){
    		mapClientes.put(cliente.getNome(), cliente);
    		sugestoesClientes.add(cliente.getNome());
    	}
    	
    	List<Carro> carros = Controlador.listaCarros();
    	HashMap<String,Carro> mapCarros = new HashMap<String,Carro>();
    	
    	for (Carro carro : carros){
    		mapCarros.put(carro.getNome(), carro);
    	}
    	
    	LocalDate localDate = LocalDate.now();
    	// fim das variaveis globais ----------------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Pagar ---------------------------------------------------------------------------------------------------------------------
    	//autocomplete  
    	TextFields.bindAutoCompletion(nomeCliente_Pagar, sugestoesClientes);
    	
    	//seta opções de danificação
    	ObservableList<String> dadosComboBoxDanificacao_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxDanificacao_Pagar.add("Sim");
    	dadosComboBoxDanificacao_Pagar.add("Não");
    	danificacao_Pagar.setItems(dadosComboBoxDanificacao_Pagar);    	
    	
    	//seta opções de retorno
    	ObservableList<String> dadosComboBoxRetorno_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxRetorno_Pagar.add("Sim");
    	dadosComboBoxRetorno_Pagar.add("Não");
    	retorno_Pagar.setItems(dadosComboBoxRetorno_Pagar);
    	
    	//seta filiais
    	ObservableList<String> dadosComboBoxFiliais_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxFiliais_Pagar.add("RJ");
    	dadosComboBoxFiliais_Pagar.add("SP");
    	dadosComboBoxFiliais_Pagar.add("MG");
    	filiais_Pagar.setItems(dadosComboBoxFiliais_Pagar); 
    	
    	//seta as formas de pagamento
    	ObservableList<String> dadosComboBoxFormaPagamento_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxFormaPagamento_Pagar.add("À vista");
    	dadosComboBoxFormaPagamento_Pagar.add("À prazo");
    	formaDePagamento_Pagar.setItems(dadosComboBoxFormaPagamento_Pagar);
    	
    	//seta crédito ou débito
    	ObservableList<String> dadosComboBoxCreditoDebito_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxCreditoDebito_Pagar.add("Crédito");
    	dadosComboBoxCreditoDebito_Pagar.add("Débito");
    	creditoDebito_Pagar.setItems(dadosComboBoxCreditoDebito_Pagar);
    	
    	//seta o parcelamento
    	ObservableList<Integer> dadosComboBoxParcelamento_Pagar = FXCollections.observableArrayList();
    	dadosComboBoxParcelamento_Pagar.add(1);
    	dadosComboBoxParcelamento_Pagar.add(2);
    	dadosComboBoxParcelamento_Pagar.add(3);
    	dadosComboBoxParcelamento_Pagar.add(4);
    	dadosComboBoxParcelamento_Pagar.add(5);
    	dadosComboBoxParcelamento_Pagar.add(6);
    	dadosComboBoxParcelamento_Pagar.add(7);
    	dadosComboBoxParcelamento_Pagar.add(8);
    	dadosComboBoxParcelamento_Pagar.add(9);
    	dadosComboBoxParcelamento_Pagar.add(10);
    	dadosComboBoxParcelamento_Pagar.add(11);
    	dadosComboBoxParcelamento_Pagar.add(12);
    	parcelamento_Pagar.setItems(dadosComboBoxParcelamento_Pagar);
    	
    	//gera o modal do pagar
    	pagar_Pagar.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(!valor_Pagar.getText().equals(""))
    			{
    				System.out.println("Foi");
    			}
    			else{
    				aviso_Pagar.setText("*Todos os campos disponíveis precisam estar preenchidos");
    			}
    		}
    	});
    	
    	//gera o modal do limpar dados
    	limpar_Pagar.setOnAction((event) -> {
    		Action response = Dialogs.create()
    			      .owner(null)
    			      .title("Aviso!")
    			      .message("Deseja limpar os campos?")
    			      .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			danificacao_Pagar.getSelectionModel().clearSelection();
    			valorDanificacao_Pagar.setText("");
    			retorno_Pagar.getSelectionModel().clearSelection();
    			filiais_Pagar.getSelectionModel().clearSelection();
    			valorRetorno_Pagar.setText("");
    			desconto_Pagar.getSelectionModel().clearSelection();
    			valorDesconto_Pagar.setText("");
    			formaDePagamento_Pagar.getSelectionModel().clearSelection();
    			creditoDebito_Pagar.getSelectionModel().clearSelection();
        		parcelamento_Pagar.getSelectionModel().clearSelection();
        		valor_Pagar.setText("");
        		totalPagar_Pagar.setText("R$ 0.00");
        		aviso_Pagar.setText("");
    		}
    	});
    	// fim lógica do Pagar ----------------------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Cadastrar Cliente ---------------------------------------------------------------------------------------------------------------------
    	//evento outfocus no nome
    	nomeCliente_CadastrarCliente.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {
		        	if(nomeCliente_CadastrarCliente.getText().equals(""))
		        	{
		        		clienteExiste_CadastrarCliente.setText("");
		        		img_clienteExiste_CadastrarCliente.setImage(null);
		        	}
		        	else
		        	{ 
		        		if(mapClientes.containsKey(nomeCliente_CadastrarCliente.getText()))
		        		{
		        			clienteExiste_CadastrarCliente.setText("Cliente já existe");
		        			img_clienteExiste_CadastrarCliente.setImage(new Image("img/error.png"));
		        		}
		        		else
		        		{
		        			clienteExiste_CadastrarCliente.setText("Cliente não existe");
		        			img_clienteExiste_CadastrarCliente.setImage(new Image("img/ok.png"));
		        		}			        	
		        	}
		        }
		    }
    	});
    	
    	//evento outfocus no cpf
    	cpf_CadastrarCliente.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {
		        	if(cpf_CadastrarCliente.getText().equals(""))
		        	{
		        		cpfInvalido_CadastrarCliente.setText("");
		        		img_cpfInvalido_CadastrarCliente.setImage(null);
		        	}
		        	else
		        	{ 
		        		if(cpf_CadastrarCliente.getText().length() == 11)
		        		{
		        			cpfInvalido_CadastrarCliente.setText("CPF válido");
			        		img_cpfInvalido_CadastrarCliente.setImage(new Image("img/ok.png"));
		        		}
		        		else
		        		{
		        			cpfInvalido_CadastrarCliente.setText("CPF inválido");
			        		img_cpfInvalido_CadastrarCliente.setImage(new Image("img/error.png"));
		        		}			        	
		        	}
		        }
		    }
    	});
    	
    	//gera o modal do cadastrar
    	cadastrar_CadastrarCliente.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(!nomeCliente_CadastrarCliente.getText().equals("") && !mapClientes.containsKey(nomeCliente_CadastrarCliente.getText())
    			   && !cpf_CadastrarCliente.getText().equals("") && cpf_CadastrarCliente.getText().length() == 11 
    			   && !idade_CadastrarCliente.getText().equals(""))
    			{
    				System.out.println("Foi");
    			}
    			else{
    				aviso_CadastrarCliente.setText("*Todos os campos precisam estar preenchidos\n*O cliente não pode já estar cadastrado\n*O CPF deve ser válido");
    			}
    		}
    	});
    	
    	//gera o modal do limpar dados
    	limpar_CadastrarCliente.setOnAction((event) -> {
    		Action response = Dialogs.create()
    			      .owner(null)
    			      .title("Aviso!")
    			      .message("Deseja limpar os campos?")
    			      .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			nomeCliente_CadastrarCliente.setText("");
    			cpf_CadastrarCliente.setText("");
    			idade_CadastrarCliente.setText("");
        		clienteExiste_CadastrarCliente.setText("");
        		img_clienteExiste_CadastrarCliente.setImage(null);
        		cpfInvalido_CadastrarCliente.setText("");
        		img_cpfInvalido_CadastrarCliente.setImage(null);
        		aviso_CadastrarCliente.setText("");
    		}
    	});
    	// fim lógica do Cadastrar Cliente ----------------------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Reservar Antecipado ------------------------------------------------------------------------------------------------------------------------------
    	//autocomplete  
    	TextFields.bindAutoCompletion(nomeCliente_ReservarAntecipado, sugestoesClientes);

    	//evento outfocus no nome do cliente
    	nomeCliente_ReservarAntecipado.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {
		        	if(nomeCliente_ReservarAntecipado.getText().equals(""))
		        	{
		        		listaNegra_ReservarAntecipado.setText("");
		        		img_listaNegra_ReservarAntecipado.setImage(null);
		        	}
		        	else
		        	{ 
		        		if(mapClientes.containsKey(nomeCliente_ReservarAntecipado.getText()))
		        		{
		        			if(mapClientes.get(nomeCliente_ReservarAntecipado.getText()).getListaNegra())
				        	{
				        		listaNegra_ReservarAntecipado.setText("Cliente está na lista negra");
				        		img_listaNegra_ReservarAntecipado.setImage(new Image("img/error.png"));
				        	}
				        	else
				        	{
				        		listaNegra_ReservarAntecipado.setText("Cliente não está na lista negra");
				        		img_listaNegra_ReservarAntecipado.setImage(new Image("img/ok.png"));
				        	}
		        		}
		        		else
		        		{
		        			listaNegra_ReservarAntecipado.setText("Cliente não existe");
			        		img_listaNegra_ReservarAntecipado.setImage(new Image("img/error.png"));
		        		}			        	
		        	}
		        }
		    }
    	});
    	
    	//seta filiais existentes
    	ObservableList<String> dadosComboBoxFiliais_ReservarAntecipado = FXCollections.observableArrayList();
    	dadosComboBoxFiliais_ReservarAntecipado.add("RJ");
    	dadosComboBoxFiliais_ReservarAntecipado.add("SP");
    	dadosComboBoxFiliais_ReservarAntecipado.add("MG");
    	filial_ReservarAntecipado.setItems(dadosComboBoxFiliais_ReservarAntecipado);
    	
    	//seta grupos de acordo com a filial escolhida
    	filial_ReservarAntecipado.setOnAction((event) -> {
    		ObservableList<String> dadosComboBoxGrupos_ReservarAntecipado = FXCollections.observableArrayList();
    		
    		int a=0, b=0, c=0, d=0;
    		
    		for (Carro carro : carros){
    			if(carro.getFilial().equals(filial_ReservarAntecipado.getValue()) && a == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("A")){
    				dadosComboBoxGrupos_ReservarAntecipado.add("A");
    				a = 1;
    			}
    			else if(carro.getFilial().equals(filial_ReservarAntecipado.getValue()) && b == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("B")){
    				dadosComboBoxGrupos_ReservarAntecipado.add("B");
    				b = 1;
    			}
    			else if(carro.getFilial().equals(filial_ReservarAntecipado.getValue()) && c == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("C")){
    				dadosComboBoxGrupos_ReservarAntecipado.add("C");
    				c = 1;
    			}
    			else if(carro.getFilial().equals(filial_ReservarAntecipado.getValue()) && d == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("D")){
    				dadosComboBoxGrupos_ReservarAntecipado.add("D");
    				d = 1;
    			}
    		}
    		
    		grupoCarro_ReservarAntecipado.getSelectionModel().clearSelection();
    		carro_ReservarAntecipado.getSelectionModel().clearSelection();
            grupoCarro_ReservarAntecipado.setItems(dadosComboBoxGrupos_ReservarAntecipado);
        });
    	
    	//seta os carros, de acordo com a filial e o grupo escolhido
    	grupoCarro_ReservarAntecipado.setOnAction((event) -> {
    		ObservableList<String> carrosDisponiveis_ReservarAntecipado = FXCollections.observableArrayList();
    		
    		for (Carro carro : carros){
    			if(carro.getFilial().equals(filial_ReservarAntecipado.getValue()) && carro.getDisponibilidade() && carro.getGrupo().equals(grupoCarro_ReservarAntecipado.getValue())){
    				carrosDisponiveis_ReservarAntecipado.add(carro.getNome());
    			}
    		}
    		
    		carro_ReservarAntecipado.getSelectionModel().clearSelection();
    		carro_ReservarAntecipado.setItems(carrosDisponiveis_ReservarAntecipado);
        });
    	
    	//gera o modal do reservar
    	efetuarReserva_ReservarAntecipado.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_ReservarAntecipado.getText())
    			   && !mapClientes.get(nomeCliente_ReservarAntecipado.getText()).getListaNegra()
    			   /*&& !filial_ReservarAntecipado.getValue().equals("") && !grupoCarro_ReservarAntecipado.getValue().equals("")
    			   && !carro_ReservarAntecipado.getValue().equals("")*/)
    			{
    				System.out.println("Foi");
    			}
    			else{
    				aviso_ReservarAntecipado.setText("*Todos os campos precisam estar preenchidos\n*O cliente não pode estar na lista negra");
    			}
    		}
    	});
    	
    	//gera o modal do limpar dados
    	limpar_ReservarAntecipado.setOnAction((event) -> {
    		Action response = Dialogs.create()
    			      .owner(null)
    			      .title("Aviso!")
    			      .message( "Deseja limpar os campos?")
    			      .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			nomeCliente_ReservarAntecipado.setText("");
    			filial_ReservarAntecipado.getSelectionModel().clearSelection();
        		grupoCarro_ReservarAntecipado.getSelectionModel().clearSelection();
        		carro_ReservarAntecipado.getSelectionModel().clearSelection();
        		dataInicio_ReservarAntecipado.setValue(null);
        		dataFim_ReservarAntecipado.setValue(null);
        		listaNegra_ReservarAntecipado.setText("");
        		img_listaNegra_ReservarAntecipado.setImage(null);
        		aviso_ReservarAntecipado.setText("");
    		}
    	});
    	// fim lógica do Reservar Antecipado ------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Alocar Imediato --------------------------------------------------------------------------------------------------------------------
    	//autocomplete  
    	TextFields.bindAutoCompletion(nomeCliente_AlocarImediato, sugestoesClientes);

    	//evento outfocus no nome do cliente
    	nomeCliente_AlocarImediato.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {
		        	if(nomeCliente_AlocarImediato.getText().equals(""))
		        	{
		        		listaNegra_AlocarImediato.setText("");
		        		img_listaNegra_AlocarImediato.setImage(null);
		        	}
		        	else
		        	{ 
		        		if(mapClientes.containsKey(nomeCliente_AlocarImediato.getText()))
		        		{
		        			if(mapClientes.get(nomeCliente_AlocarImediato.getText()).getListaNegra())
				        	{
				        		listaNegra_AlocarImediato.setText("Cliente está na lista negra");
				        		img_listaNegra_AlocarImediato.setImage(new Image("img/error.png"));
				        	}
				        	else
				        	{
				        		listaNegra_AlocarImediato.setText("Cliente não está na lista negra");
				        		img_listaNegra_AlocarImediato.setImage(new Image("img/ok.png"));
				        	}
		        		}
		        		else
		        		{
		        			listaNegra_AlocarImediato.setText("Cliente não existe");
			        		img_listaNegra_AlocarImediato.setImage(new Image("img/error.png"));
		        		}			        	
		        	}
		        }
		    }
    	});
    	
    	//seta filiais existentes
    	ObservableList<String> dadosComboBoxFiliais_AlocarImediato = FXCollections.observableArrayList();
    	dadosComboBoxFiliais_AlocarImediato.add("RJ");
    	dadosComboBoxFiliais_AlocarImediato.add("SP");
    	dadosComboBoxFiliais_AlocarImediato.add("MG");
    	filial_AlocarImediato.setItems(dadosComboBoxFiliais_AlocarImediato);
    	
    	//seta grupos de acordo com a filial escolhida
    	filial_AlocarImediato.setOnAction((event) -> {
    		ObservableList<String> dadosComboBoxGrupos_AlocarImediato = FXCollections.observableArrayList();
    		
    		int a=0, b=0, c=0, d=0;
    		
    		for (Carro carro : carros){
    			if(carro.getFilial().equals(filial_AlocarImediato.getValue()) && a == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("A")){
    				dadosComboBoxGrupos_AlocarImediato.add("A");
    				a = 1;
    			}
    			else if(carro.getFilial().equals(filial_AlocarImediato.getValue()) && b == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("B")){
    				dadosComboBoxGrupos_AlocarImediato.add("B");
    				b = 1;
    			}
    			else if(carro.getFilial().equals(filial_AlocarImediato.getValue()) && c == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("C")){
    				dadosComboBoxGrupos_AlocarImediato.add("C");
    				c = 1;
    			}
    			else if(carro.getFilial().equals(filial_AlocarImediato.getValue()) && d == 0 && carro.getDisponibilidade() && carro.getGrupo().equals("D")){
    				dadosComboBoxGrupos_AlocarImediato.add("D");
    				d = 1;
    			}
    		}
    		
    		grupoCarro_AlocarImediato.getSelectionModel().clearSelection();
    		carro_AlocarImediato.getSelectionModel().clearSelection();
            grupoCarro_AlocarImediato.setItems(dadosComboBoxGrupos_AlocarImediato);
        });
    	
    	//seta os carros, de acordo com a filial e o grupo escolhido
    	grupoCarro_AlocarImediato.setOnAction((event) -> {
    		ObservableList<String> carrosDisponiveis_AlocarImediato = FXCollections.observableArrayList();
    		
    		for (Carro carro : carros){
    			if(carro.getFilial().equals(filial_AlocarImediato.getValue()) && carro.getDisponibilidade() && carro.getGrupo().equals(grupoCarro_AlocarImediato.getValue())){
    				carrosDisponiveis_AlocarImediato.add(carro.getNome());
    			}
    		}
    		
    		carro_AlocarImediato.getSelectionModel().clearSelection();
    		carro_AlocarImediato.setItems(carrosDisponiveis_AlocarImediato);
        });
    	
    	//preenche a data inicial com a data atual
    	dataInicio_AlocarImediato.setValue(localDate);
    	
    	//gera o modal do efetuar locação
    	efetuarAlocacao_AlocarImediato.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_AlocarImediato.getText())
    			   && !mapClientes.get(nomeCliente_AlocarImediato.getText()).getListaNegra()
    			   /*&& !filial_AlocarImediato.getValue().equals("") && !grupoCarro_AlocarImediato.getValue().equals("")
    			   && !carro_AlocarImediato.getValue().equals("")*/)
    			{
    				System.out.println("Foi");
    			}
    			else{
    				aviso_AlocarImediato.setText("*Todos os campos precisam estar preenchidos\n*O cliente não pode estar na lista negra");
    			}
    		}
    	});
    	
    	//gera o modal do limpar dados
    	limpar_AlocarImediato.setOnAction((event) -> {
    		Action response = Dialogs.create()
    			      .owner(null)
    			      .title("Aviso!")
    			      .message("Deseja limpar os campos?")
    			      .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			nomeCliente_AlocarImediato.setText("");
    			filial_AlocarImediato.getSelectionModel().clearSelection();
        		grupoCarro_AlocarImediato.getSelectionModel().clearSelection();
        		carro_AlocarImediato.getSelectionModel().clearSelection();
        		dataFim_AlocarImediato.setValue(null);
        		listaNegra_AlocarImediato.setText("");
        		img_listaNegra_AlocarImediato.setImage(null);
        		aviso_ReservarAntecipado.setText("");
    		}
    	});
    	// fim lógica do Alocar Imediato -------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Vender --------------------------------------------------------------------------------------------------------------------
    	//autocomplete  
    	TextFields.bindAutoCompletion(nomeCliente_Vender, sugestoesClientes);

    	//evento outfocus no nome do cliente
    	nomeCliente_Vender.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {
		        	if(nomeCliente_Vender.getText().equals(""))
		        	{
		        		listaNegra_Vender.setText("");
		        		img_listaNegra_Vender.setImage(null);
		        	}
		        	else
		        	{ 
		        		if(mapClientes.containsKey(nomeCliente_Vender.getText()))
		        		{
		        			if(mapClientes.get(nomeCliente_Vender.getText()).getListaNegra())
				        	{
				        		listaNegra_Vender.setText("Cliente está na lista negra");
				        		img_listaNegra_Vender.setImage(new Image("img/error.png"));
				        	}
				        	else
				        	{
				        		listaNegra_Vender.setText("Cliente não está na lista negra");
				        		img_listaNegra_Vender.setImage(new Image("img/ok.png"));
				        	}
		        		}
		        		else
		        		{
		        			listaNegra_Vender.setText("Cliente não existe");
			        		img_listaNegra_Vender.setImage(new Image("img/error.png"));
		        		}			        	
		        	}
		        }
		    }
    	});

		ObservableList<String> carrosDisponiveis_Vender = FXCollections.observableArrayList();
		
		for (Carro carro : carros){
			if(carro.getQuilometragem() >= 40000 || !carro.getAno().equals("2014")){
				carrosDisponiveis_Vender.add(carro.getNome());
			}
		}
		
		carro_Vender.setItems(carrosDisponiveis_Vender);

    	//gera o modal do vender
    	vender_Vender.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_Vender.getText())
    			   && !mapClientes.get(nomeCliente_Vender.getText()).getListaNegra()
    			   /*&& !filial_Vender.getValue().equals("") && !grupoCarro_Vender.getValue().equals("")
    			   && !carro_Vender.getValue().equals("")*/)
    			{
    				System.out.println("Foi");
    			}
    			else{
    				aviso_Vender.setText("*Todos os campos precisam estar preenchidos\n*O cliente não pode estar na lista negra");
    			}
    		}
    	});
    	
    	//gera o modal do limpar dados
    	limpar_Vender.setOnAction((event) -> {
    		Action response = Dialogs.create()
    			      .owner(null)
    			      .title("Aviso!")
    			      .message("Deseja limpar os campos?")
    			      .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			nomeCliente_Vender.setText("");
        		carro_Vender.getSelectionModel().clearSelection();
        		listaNegra_Vender.setText("");
        		img_listaNegra_Vender.setImage(null);
        		aviso_Vender.setText("");
    		}
    	});
    	// fim lógica do Vender -----------------------------------------------------------------------------------------------------------------------------
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}