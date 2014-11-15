package controller.view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import model.Carro;
import model.CarroTemLocacao;
import model.CarroTemReserva;
import model.Cliente;
import model.ClienteTemCarro;
import model.Locacao;
import model.Reserva;
import model.Venda;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import controller.DAO;
import controller.MainApp;

public class MainAppController {
	// atributos do acordeon Pagar ------------------------------------------------------------------------------------------------------
	@FXML
    private TextField nomeCliente_Pagar;
	
	@FXML
    private TableView<Carro> tabela_Pagar;
	
	@FXML
    private TableColumn<Carro, String> carroTabela_Pagar;
	
    @FXML
    private TableColumn<Carro, String> placaTabela_Pagar;
    
    @FXML
    private TableColumn<Carro, String> valorTabela_Pagar;
    
    @FXML
    private TableColumn<Carro, String> valorAtrasoTabela_Pagar;
	
	@FXML
    private RadioButton dinheiro_Pagar;
	
	@FXML
    private RadioButton cartao_Pagar;
	
	@FXML
    private TextField valorDanificacao_Pagar;
	
	@FXML
    private TextField valorRetorno_Pagar;
	
	@FXML
    private TextField valorDesconto_Pagar;
	
	@FXML
    private ComboBox<String> formaDePagamento_Pagar;
	
	@FXML
    private ComboBox<String> creditoDebito_Pagar;
	
	@FXML
    private ComboBox<Integer> parcelamento_Pagar;
	
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
    private ImageView img_carro_ReservarAntecipado;
	
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
    private ImageView img_carro_AlocarImediato;
	
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
    private ImageView img_carro_Vender;
	
	@FXML
    private Button vender_Vender;
	
	@FXML
    private Button limpar_Vender;
	
	@FXML
    private Label aviso_Vender;
	// fim dos atributos do acordeon Vender -------------------------------------------------------------------------------------------------------------
	
	private MainApp mainApp;
	
	//quantidade máxima de caracteres num TextField
	private void tamanhoMax(final TextField textField, final Integer length) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > length){
                    textField.setText(oldValue);
                }
            }
        });
    }
	
	//apenas números num TextField
	public void campoNumerico(final TextField textField) {
        textField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = textField.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                }
            }
        });
    }
	
	//apenas números num TextField
	public void campoValor(final TextField textField) {
        textField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    String ch = textField.getText(oldValue.intValue(), oldValue.intValue()+1);
                    if (!(ch.matches("[0-9.]"))) {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                }
            }
        });
    }
	
	//apenas letras num TextField
	public void campoLetras(final TextField textField) {
        textField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    String ch = textField.getText(oldValue.intValue(), oldValue.intValue()+1);
                    if (!(ch.matches("[a-zA-Z ]"))) {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                }
            }
        });
    }
	
	//verifica se já existe um cliente com o cpf passado por parâmetro
	public boolean existenciaCpf(HashMap<String, Cliente> mapClientes, String cpf){
		for (Entry<String, Cliente> entry : mapClientes.entrySet()){
    		if(entry.getValue().getCpf().equals(cpf)){
    			return true;
    		}
    	}
		return false;
	}
	
	public MainAppController() {
    }
	
    @FXML
    private void initialize() {
    	// variáveis globais dos acordeons----------------------------------------------------------------------------------------------------------------    	
    	List<Cliente> clientes = DAO.listaClientes();
    	List<Carro> carros = DAO.listaCarros();
    	
    	Collection<String> sugestoesClientes = new ArrayList<String>();
    	
    	HashMap<String,Cliente> mapClientes = new HashMap<String,Cliente>();
    	HashMap<String,Carro> mapCarros = new HashMap<String,Carro>();

    	for (Cliente cliente : clientes){
    		mapClientes.put(cliente.getNome() + " " + "(" + cliente.getCpf() + ")", cliente);
    		sugestoesClientes.add(cliente.getNome() + " " + "(" + cliente.getCpf() + ")");
    	}
    	
    	for (Carro carro : carros){
    		mapCarros.put(carro.getNome() + " " + "(" + carro.getPlaca() + ")", carro);
    	}
    	// fim das variaveis globais ----------------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Pagar ---------------------------------------------------------------------------------------------------------------------
    	//autocomplete  
    	TextFields.bindAutoCompletion(nomeCliente_Pagar, sugestoesClientes);
    	
    	//tabela de carros
    	nomeCliente_Pagar.focusedProperty().addListener(new ChangeListener<Boolean>()
    	{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {   		        	
		        	if(mapClientes.get(nomeCliente_Pagar.getText()) != null){
		        		ObservableList<Carro> carrosPendentes = FXCollections.observableArrayList();
		        		
		        		// os carros desse cliente que nao tem pagamento
			        	Cliente cliente = mapClientes.get(nomeCliente_Pagar.getText());
			        	
			        	for (ClienteTemCarro ctc : cliente.getClienteTemCarros()){
			        		// vendas do carro
			        		if (ctc.getCarro().getVendas() != null){
			        			for (Venda v : ctc.getCarro().getVendas()){
			        				if(v.getPagamento() == null){
			        					carrosPendentes.add(v.getCarro());
			        				}
			        			}
			        		}

			        		//locacoes do carro
			        		if (ctc.getCarro().getCarroTemLocacaos() != null){
			        			for (CarroTemLocacao ctl :   ctc.getCarro().getCarroTemLocacaos()){
			        				if(ctl.getLocacao().getPagamentos() == null || ctl.getLocacao().getPagamentos().size() == 0){
			        					carrosPendentes.add(ctl.getCarro());
			        				}
			        			}			        				
			        		}

			        		// reservas do carro			        		
			        		if (ctc.getCarro().getCarroTemReservas() != null){
			        			for (CarroTemReserva ctr : ctc.getCarro().getCarroTemReservas()){
			        				if(ctr.getReserva().getPagamentos() == null || ctr.getReserva().getPagamentos().size() == 0){
			        					carrosPendentes.add(ctr.getCarro());
			        				}
			        			}
			        		}
			        	}
			        	
			        	carroTabela_Pagar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
			        	placaTabela_Pagar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
			        	valorTabela_Pagar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValor()));
			        	valorAtrasoTabela_Pagar.setCellValueFactory(cellData -> new SimpleStringProperty("0"));
			        	
			        	tabela_Pagar.setItems(carrosPendentes);
		        	}
		        }
		    }
    	});
    	
    	tabela_Pagar.getSelectionModel().selectedItemProperty().addListener(
    		(observable, oldValue, newValue) -> {
		        if (newValue != null) {
		        	Double soma = Double.parseDouble(newValue.getValor());
		        	
		        	if(!valorRetorno_Pagar.getText().equals(null) && !valorRetorno_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorRetorno_Pagar.getText());
	        		}
	        		
	        		if(!valorDanificacao_Pagar.getText().equals(null) && !valorDanificacao_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorDanificacao_Pagar.getText());
	        		}
	        		
	        		if(!valorDesconto_Pagar.getText().equals(null) && !valorDesconto_Pagar.getText().isEmpty()){
	        			if(soma - Double.parseDouble(valorDesconto_Pagar.getText()) < 0){
		        			soma = Double.parseDouble("0");
		        		}
		        		else{
		        			soma = soma - Double.parseDouble(valorDesconto_Pagar.getText());
		        		}
	        		}
		        	
		            totalPagar_Pagar.setText("R$ " + soma);
		        }
		    }
		);
    	
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
    	
    	for(int k = 1; k < 13; k++){
    		dadosComboBoxParcelamento_Pagar.add(k);
    	}
    	
    	parcelamento_Pagar.setItems(dadosComboBoxParcelamento_Pagar);
    	
    	campoValor(valorDanificacao_Pagar);
    	campoValor(valorRetorno_Pagar);
    	campoValor(valorDesconto_Pagar);
    	
    	ToggleGroup group = new ToggleGroup();
        cartao_Pagar.setToggleGroup(group);
        cartao_Pagar.setSelected(true);
        cartao_Pagar.setUserData("cartão");
        dinheiro_Pagar.setToggleGroup(group);
        dinheiro_Pagar.setUserData("dinheiro");
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        	public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
        		if (group.getSelectedToggle() != null) {
        			if(group.getSelectedToggle().getUserData().toString().equals("dinheiro")){
        				formaDePagamento_Pagar.setDisable(true);
            			creditoDebito_Pagar.setDisable(true);
                		parcelamento_Pagar.setDisable(true);
                		formaDePagamento_Pagar.getSelectionModel().clearSelection();
            			creditoDebito_Pagar.getSelectionModel().clearSelection();
                		parcelamento_Pagar.getSelectionModel().clearSelection();
        			}
        			else{
        				formaDePagamento_Pagar.setDisable(false);
            			creditoDebito_Pagar.setDisable(false);
                		parcelamento_Pagar.setDisable(false);
        			}
        		}
            }
        });
        
        valorDanificacao_Pagar.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {   		        	
	        		Double soma = 0.0;
	        		
	        		if(!(tabela_Pagar.getSelectionModel().getSelectedItem() == null)){
	        			soma = Double.parseDouble(tabela_Pagar.getSelectionModel().getSelectedItem().getValor());
	        		}	
	        			
			        if(!valorDanificacao_Pagar.getText().equals(null) && !valorDanificacao_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorDanificacao_Pagar.getText());
	        		}
	        		
	        		if(!valorRetorno_Pagar.getText().equals(null) && !valorRetorno_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorRetorno_Pagar.getText());
	        		}
	        		
	        		if(!valorDesconto_Pagar.getText().equals(null) && !valorDesconto_Pagar.getText().isEmpty()){
	        			if(soma - Double.parseDouble(valorDesconto_Pagar.getText()) < 0){
		        			soma = Double.parseDouble("0");
		        		}
		        		else{
		        			soma = soma - Double.parseDouble(valorDesconto_Pagar.getText());
		        		}
	        		}

	        		totalPagar_Pagar.setText("R$ " + soma.toString());
		        }
		    }
		});
        
        valorRetorno_Pagar.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {   		        	
		        	Double soma = 0.0;
	        		
	        		if(!(tabela_Pagar.getSelectionModel().getSelectedItem() == null)){
	        			soma = Double.parseDouble(tabela_Pagar.getSelectionModel().getSelectedItem().getValor());
	        		}	
	        			
			        if(!valorDanificacao_Pagar.getText().equals(null) && !valorDanificacao_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorDanificacao_Pagar.getText());
	        		}
	        		
	        		if(!valorRetorno_Pagar.getText().equals(null) && !valorRetorno_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorRetorno_Pagar.getText());
	        		}
	        		
	        		if(!valorDesconto_Pagar.getText().equals(null) && !valorDesconto_Pagar.getText().isEmpty()){
	        			if(soma - Double.parseDouble(valorDesconto_Pagar.getText()) < 0){
		        			soma = Double.parseDouble("0");
		        		}
		        		else{
		        			soma = soma - Double.parseDouble(valorDesconto_Pagar.getText());
		        		}
	        		}

	        		totalPagar_Pagar.setText("R$ " + soma.toString());
		        }
		    }
		});
        
        valorDesconto_Pagar.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (!newPropertyValue)
		        {   		        	
		        	Double soma = 0.0;
	        		
	        		if(!(tabela_Pagar.getSelectionModel().getSelectedItem() == null)){
	        			soma = Double.parseDouble(tabela_Pagar.getSelectionModel().getSelectedItem().getValor());
	        		}	
	        			
			        if(!valorDanificacao_Pagar.getText().equals(null) && !valorDanificacao_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorDanificacao_Pagar.getText());
	        		}
	        		
	        		if(!valorRetorno_Pagar.getText().equals(null) && !valorRetorno_Pagar.getText().isEmpty()){
	        			soma += Double.parseDouble(valorRetorno_Pagar.getText());
	        		}
	        		
	        		if(!valorDesconto_Pagar.getText().equals(null) && !valorDesconto_Pagar.getText().isEmpty()){
	        			if(soma - Double.parseDouble(valorDesconto_Pagar.getText()) < 0){
		        			soma = Double.parseDouble("0");
		        		}
		        		else{
		        			soma = soma - Double.parseDouble(valorDesconto_Pagar.getText());
		        		}
	        		}

	        		totalPagar_Pagar.setText("R$ " + soma.toString());
		        }
		    }
		});

    	//gera o modal do pagar
    	pagar_Pagar.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(!(tabela_Pagar.getSelectionModel().getSelectedItem() == null) && !nomeCliente_Pagar.getText().equals("") &&
    			  ( ( group.getSelectedToggle().getUserData().toString().equals("cartao") && formaDePagamento_Pagar.getSelectionModel().getSelectedIndex() != -1 && creditoDebito_Pagar.getSelectionModel().getSelectedIndex() != -1 &&
    			     parcelamento_Pagar.getSelectionModel().getSelectedIndex() != -1  ) || group.getSelectedToggle().getUserData().toString().equals("dinheiro") ) )
    			{
    				//substituir pela lógica de inserção no banco
    				System.out.println("Foi");
    				
    				// criar objeto pagamento
    				// controlador.salvar(pagemento)
    				
    				// se for venda fazer venda.setPagamento(pagamento)
    				// se for locacao fazer locacao.setIdPagamento(pagamento.getIdPagamento())
    				// se for reserva fazer reserva.setIdPagamento(reserva.getIdPagamento())
    				
    				
    				
    				initialize();
    				
    				nomeCliente_Pagar.setText("");
        			tabela_Pagar.setItems(null);
        			valorDanificacao_Pagar.setText("");
        			valorRetorno_Pagar.setText("");
        			valorDesconto_Pagar.setText("");
        			formaDePagamento_Pagar.getSelectionModel().clearSelection();
        			creditoDebito_Pagar.getSelectionModel().clearSelection();
            		parcelamento_Pagar.getSelectionModel().clearSelection();
            		cartao_Pagar.setSelected(true);
            		totalPagar_Pagar.setText("R$ 0.0");
            		aviso_Pagar.setText("");
    				
    				Dialogs.create()
    		        	.owner(null)
    		        	.title("Aviso!")
    		        	.masthead(null)
    		        	.message("Dados enviados com sucesso!")
    		        	.showInformation();
    			}
    			else{
    				aviso_Pagar.setText("*Um cliente, um carro e as condições de pagamento devem ser selecionados");
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
    			nomeCliente_Pagar.setText("");
    			tabela_Pagar.setItems(null);
    			valorDanificacao_Pagar.setText("");
    			valorRetorno_Pagar.setText("");
    			valorDesconto_Pagar.setText("");
    			formaDePagamento_Pagar.getSelectionModel().clearSelection();
    			creditoDebito_Pagar.getSelectionModel().clearSelection();
        		parcelamento_Pagar.getSelectionModel().clearSelection();
        		cartao_Pagar.setSelected(true);
        		totalPagar_Pagar.setText("R$ 0.0");
        		aviso_Pagar.setText("");
    		}
    	});
    	// fim lógica do Pagar ----------------------------------------------------------------------------------------------------------------------------
    	
    	
    	// lógica do Cadastrar Cliente ---------------------------------------------------------------------------------------------------------------------    	
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
		        			if(existenciaCpf(mapClientes, cpf_CadastrarCliente.getText())){
		        				cpfInvalido_CadastrarCliente.setText("CPF já existe");
				        		img_cpfInvalido_CadastrarCliente.setImage(new Image("img/error.png"));
		        			}
		        			else{
		        				cpfInvalido_CadastrarCliente.setText("CPF válido");
				        		img_cpfInvalido_CadastrarCliente.setImage(new Image("img/ok.png"));
		        			}
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
    	
    	campoLetras(nomeCliente_CadastrarCliente);
    	
    	campoNumerico(cpf_CadastrarCliente);
    	campoNumerico(idade_CadastrarCliente);
    	
    	tamanhoMax(cpf_CadastrarCliente, 11);
    	tamanhoMax(idade_CadastrarCliente, 3);        
    	
    	//gera o modal do cadastrar
    	cadastrar_CadastrarCliente.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(!nomeCliente_CadastrarCliente.getText().equals("") && !cpf_CadastrarCliente.getText().equals("") && cpf_CadastrarCliente.getText().length() == 11 
    			   && !idade_CadastrarCliente.getText().equals("") && !existenciaCpf(mapClientes, cpf_CadastrarCliente.getText()))
    			{
    				Cliente novoCliente = new Cliente();
    				novoCliente.setNome(nomeCliente_CadastrarCliente.getText());
    				novoCliente.setIdade(idade_CadastrarCliente.getText());
    				novoCliente.setCpf(cpf_CadastrarCliente.getText());
    				DAO.salvar(novoCliente);
    				
    				initialize();
    				
    				nomeCliente_CadastrarCliente.setText("");
        			cpf_CadastrarCliente.setText("");
        			idade_CadastrarCliente.setText("");
            		cpfInvalido_CadastrarCliente.setText("");
            		img_cpfInvalido_CadastrarCliente.setImage(null);
            		aviso_CadastrarCliente.setText("");
    				
    				Dialogs.create()
    		        	.owner(null)
    		        	.title("Aviso!")
    		        	.masthead(null)
    		        	.message("Dados enviados com sucesso!")
    		        	.showInformation();
    			}
    			else{
    				aviso_CadastrarCliente.setText("*Todos os campos precisam estar preenchidos\n*O CPF não pode já estar cadastrado\n*O CPF deve ter 11 dígitos");
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
    				carrosDisponiveis_ReservarAntecipado.add(carro.getNome() + " " + "(" + carro.getPlaca() + ")");
    			}
    		}
    		
    		carro_ReservarAntecipado.getSelectionModel().clearSelection();
    		carro_ReservarAntecipado.setItems(carrosDisponiveis_ReservarAntecipado);
        });
    	
    	//permite escolher datas apartir de hoje
    	final Callback<DatePicker, DateCell> dayCellFactoryHoje = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);

                            if (item.isBefore(LocalDate.now().minusDays(1).plusDays(1))){
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }   
                        }
                    };
	            }
	        };
	        
	    dataInicio_ReservarAntecipado.setDayCellFactory(dayCellFactoryHoje);
    	
    	//permite escolher datas apartir de um dia após a data inicial 
    	final Callback<DatePicker, DateCell> dayCellFactoryAmanha = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            if(dataInicio_ReservarAntecipado.getValue() != null){
                            	if (item.isBefore(dataInicio_ReservarAntecipado.getValue().plusDays(1))){
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                } 
                            }  
                        }
                    };
	            }
	        };
    	
	    dataFim_ReservarAntecipado.setDayCellFactory(dayCellFactoryAmanha);
	    
	    carro_ReservarAntecipado.valueProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue ov, String t, String t1) {
	        	if(carro_ReservarAntecipado.getValue() != null){
	        		String nomeImg = mapCarros.get(carro_ReservarAntecipado.getValue()).getModelo().toLowerCase().replaceAll("\\p{Z}","") + ".jpg";
	    			img_carro_ReservarAntecipado.setImage(new Image("img/carros/" + nomeImg));
	        	}	        	
	        }    
		});
    	
    	//gera o modal do reservar
    	efetuarReserva_ReservarAntecipado.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_ReservarAntecipado.getText()) && !mapClientes.get(nomeCliente_ReservarAntecipado.getText()).getListaNegra()
    			   && filial_ReservarAntecipado.getSelectionModel().getSelectedIndex() != -1 && grupoCarro_ReservarAntecipado.getSelectionModel().getSelectedIndex() != -1
    			   && carro_ReservarAntecipado.getSelectionModel().getSelectedIndex() != -1 && dataInicio_ReservarAntecipado.getValue() != null &&
    			   dataFim_ReservarAntecipado.getValue() != null)
    			{
    				Cliente cliente = mapClientes.get(nomeCliente_ReservarAntecipado.getText());
    				Carro carro = mapCarros.get(carro_ReservarAntecipado.getSelectionModel().getSelectedItem());
    				carro.setDisponibilidade(false);
    				DAO.alterar(carro);
    				
    				Date dataInicio = Date.from(dataInicio_ReservarAntecipado.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    				Date dataFim = Date.from(dataFim_ReservarAntecipado.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    				
    				Reserva reserva = new Reserva();
    				reserva.setCliente(cliente);
    				reserva.setIdCarro(carro.getIdCarro());
    				reserva.setDataReserva(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    				reserva.setDataInicio(dataInicio);
    				reserva.setDataFim(dataFim);
    				
    				DAO.salvar(reserva);
    				
    				CarroTemReserva ctr = new CarroTemReserva();
    				ctr.setCarro(carro);
    				ctr.setReserva(reserva);    				
    				DAO.salvar(ctr);
    				
    				ClienteTemCarro ctc = new ClienteTemCarro();
    				ctc.setCarro(carro);
    				ctc.setCliente(cliente);
    				DAO.salvar(ctc);
    				
    				initialize();
    				
    				nomeCliente_ReservarAntecipado.setText("");
        			filial_ReservarAntecipado.getSelectionModel().clearSelection();
            		grupoCarro_ReservarAntecipado.getSelectionModel().clearSelection();
            		carro_ReservarAntecipado.getSelectionModel().clearSelection();
            		dataInicio_ReservarAntecipado.setValue(null);
            		dataFim_ReservarAntecipado.setValue(null);
            		listaNegra_ReservarAntecipado.setText("");
            		img_listaNegra_ReservarAntecipado.setImage(null);
            		img_carro_ReservarAntecipado.setImage(null);
            		aviso_ReservarAntecipado.setText("");
    				
    				Dialogs.create()
    		        	.owner(null)
    		        	.title("Aviso!")
    		        	.masthead(null)
    		        	.message("Dados enviados com sucesso!")
    		        	.showInformation();
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
        		img_carro_ReservarAntecipado.setImage(null);
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
    				carrosDisponiveis_AlocarImediato.add(carro.getNome() + " " + "(" + carro.getPlaca() + ")");
    			}
    		}
    		
    		carro_AlocarImediato.getSelectionModel().clearSelection();
    		carro_AlocarImediato.setItems(carrosDisponiveis_AlocarImediato);
        });
    	
    	//preenche a data inicial com a data atual
    	dataInicio_AlocarImediato.setValue(LocalDate.now());
    	
    	//permite escolher datas a partir de amanhã
    	final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(LocalDate.now().plusDays(1))){
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }   
                        }
                    };
	            }
	        };
    	
	    dataFim_AlocarImediato.setDayCellFactory(dayCellFactory);
	    
	    carro_AlocarImediato.valueProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue ov, String t, String t1) {
	        	if(carro_AlocarImediato.getValue() != null){
	        		String nomeImg = mapCarros.get(carro_AlocarImediato.getValue()).getModelo().toLowerCase().replaceAll("\\p{Z}","") + ".jpg";
	    			img_carro_AlocarImediato.setImage(new Image("img/carros/" + nomeImg));
	        	}	        	
	        }    
		});
	   
    	//gera o modal do efetuar locação
    	efetuarAlocacao_AlocarImediato.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_AlocarImediato.getText()) && !mapClientes.get(nomeCliente_AlocarImediato.getText()).getListaNegra()
    			   && filial_AlocarImediato.getSelectionModel().getSelectedIndex() != -1 && grupoCarro_AlocarImediato.getSelectionModel().getSelectedIndex() != -1
    			   && carro_AlocarImediato.getSelectionModel().getSelectedIndex() != -1 && dataFim_AlocarImediato.getValue() != null)
    			{
    				Cliente cliente = mapClientes.get(nomeCliente_AlocarImediato.getText());
    				Carro carro = mapCarros.get(carro_AlocarImediato.getSelectionModel().getSelectedItem());
    				carro.setDisponibilidade(false);
    				DAO.alterar(carro);
    				
    				Date dataInicio = Date.from(dataInicio_AlocarImediato.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    				Date dataFim = Date.from(dataFim_AlocarImediato.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    				
    				Locacao locacao = new Locacao();
    				locacao.setCliente(cliente);
    				locacao.setIdCarro(carro.getIdCarro());
    				locacao.setDataInicio(dataInicio);
    				locacao.setDataFim(dataFim);
    				
    				DAO.salvar(locacao);
    				
    				CarroTemLocacao ctl = new CarroTemLocacao();
    				ctl.setCarro(carro);
    				ctl.setLocacao(locacao);
    				DAO.salvar(ctl);
    				
    				ClienteTemCarro ctc = new ClienteTemCarro();
    				ctc.setCarro(carro);
    				ctc.setCliente(cliente);
    				DAO.salvar(ctc);
    			
    				
    				initialize();
    				
    				nomeCliente_AlocarImediato.setText("");
        			filial_AlocarImediato.getSelectionModel().clearSelection();
            		grupoCarro_AlocarImediato.getSelectionModel().clearSelection();
            		carro_AlocarImediato.getSelectionModel().clearSelection();
            		dataFim_AlocarImediato.setValue(null);
            		listaNegra_AlocarImediato.setText("");
            		img_listaNegra_AlocarImediato.setImage(null);
            		img_carro_AlocarImediato.setImage(null);
            		aviso_ReservarAntecipado.setText("");
    				
    				Dialogs.create()
    		        	.owner(null)
    		        	.title("Aviso!")
    		        	.masthead(null)
    		        	.message("Dados enviados com sucesso!")
    		        	.showInformation();
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
        		img_carro_AlocarImediato.setImage(null);
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
			if((carro.getQuilometragem() >= 40000 || !carro.getAno().equals("2014")) && carro.getDisponibilidade()){
				carrosDisponiveis_Vender.add(carro.getNome() + " " + "(" + carro.getPlaca() + ")");
			}
		}
		
		carro_Vender.setItems(carrosDisponiveis_Vender);
		
		carro_Vender.valueProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue ov, String t, String t1) {
	        	if(carro_Vender.getValue() != null){
	        		String nomeImg = mapCarros.get(carro_Vender.getValue()).getModelo().toLowerCase().replaceAll("\\p{Z}","") + ".jpg";
	    			img_carro_Vender.setImage(new Image("img/carros/" + nomeImg));
	        	}	        	
	        }    
		});

    	//gera o modal do vender
    	vender_Vender.setOnAction((event) -> {
    		Action response = Dialogs.create()
    		        .owner(null)
    		        .title("Aviso!")
    		        .message("Deseja enviar os dados?")
    		        .showConfirm();

    		if (response == Dialog.ACTION_YES) {
    			if(mapClientes.containsKey(nomeCliente_Vender.getText()) && !mapClientes.get(nomeCliente_Vender.getText()).getListaNegra()
    			   && !(carro_Vender.getSelectionModel().getSelectedIndex() == -1))
    			{
    				ClienteTemCarro ctc = new ClienteTemCarro();
    				Carro carro = mapCarros.get(carro_Vender.getValue());
    				carro.setDisponibilidade(false);
    				DAO.alterar(carro);
    				
    				Cliente cliente = mapClientes.get(nomeCliente_Vender.getText());
    				ctc.setCarro(carro);
    				ctc.setCliente(cliente);
    				DAO.salvar(ctc);
    				
    				Venda venda = new Venda();    				
    				venda.setCarro(carro);
    				DAO.salvar(venda);
    				
    				initialize();
    				
    				nomeCliente_Vender.setText("");
            		carro_Vender.getSelectionModel().clearSelection();
            		listaNegra_Vender.setText("");
            		img_listaNegra_Vender.setImage(null);
            		img_carro_Vender.setImage(null);
            		aviso_Vender.setText("");
    				
    				Dialogs.create()
    		        	.owner(null)
    		        	.title("Aviso!")
    		        	.masthead(null)
    		        	.message("Dados enviados com sucesso!")
    		        	.showInformation();
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
        		img_carro_Vender.setImage(null);
        		aviso_Vender.setText("");
    		}
    	});
    	// fim lógica do Vender -----------------------------------------------------------------------------------------------------------------------------
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}