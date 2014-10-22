package controller;

import java.util.List;

import model.Carro;
import model.ClienteTemMotorista;
import model.Motorista;

public class Teste {

	
	public static void main(String[] args) {
		Controlador.init();
		/*em.getTransaction().begin();
		Motorista m = new Motorista();
		m.setNome("Luis Antônio");
		m.setIdade("39");
		em.persist(m);
		 em.getTransaction().commit();*/
		/*em.getTransaction().begin();
		for (Motorista motorista : listaMotoristas())
			if (motorista.getIdade().equals("39"))
				em.remove(motorista);
		em.getTransaction().commit();*/
		/*
		Motorista x = null;
		for (Motorista motorista : listaMotoristas()){
			System.out.println(motorista.getIdMotorista() + ": " +motorista.getNome() + ", " + motorista.getIdade());
			if (motorista.getIdade().equals("43")){
				motorista.setIdade("47");
				x = motorista;
			}
		}
		em.getTransaction().begin();
		em.merge(x);
		em.getTransaction().commit();
		*/
		List<Motorista> motos = Controlador.listaMotoristas();
		for (Motorista motorista : motos) {
			System.out.println(motorista.getIdMotorista() + ": " + motorista.getNome() + ", " + motorista.getIdade() + ", "
					+ motorista.getDataLicenca());
			System.out.println("Clientes:");
			for (ClienteTemMotorista ctm : motorista.getClienteTemMotoristas())
				System.out.println(ctm.getCliente().getNome());
			System.out.println("---");
		}

		List<Carro> carros = Controlador.listaCarros();
		for (Carro carro : carros)
			System.out.println(carro.getFabricante() + " " + carro.getModelo());
		
		Controlador.close();
		
	}
}
