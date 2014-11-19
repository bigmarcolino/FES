import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import model.Carro;

import org.junit.Test;

import controller.DAO;

public class testDAO {

	@Test
	public void testSalvar() {
		Carro carro = new Carro();
		
		carro.setGrupo("A");
		carro.setModelo("Picanto");
		carro.setFabricante("Kia");
		carro.setDisponibilidade(true);
		carro.setNecessitaDeConserto(false);
		carro.setQuilometragem(1000.0);
		carro.setUltimaRevisao(new Date(11-11-2012));
		carro.setFilial("RJ");
		carro.setAno("2014");
		carro.setPlaca("GOT1234");
		carro.setValor("25000");
		
		DAO.salvar(carro);
		
		List<Carro> carros = DAO.listaCarros();
	
		assertTrue(carros.contains(carro));
	}

	@Test
	public void testAlterar() {
		List<Carro> carros = DAO.listaCarros();
		
		Carro carro = carros.get(0);		
		Carro carroAux = carro;
		
		carro.setAno("111");
		DAO.alterar(carro);
		
		carros = DAO.listaCarros();
		carro = carros.get(0);
		
		assertFalse(carro.equals(carroAux));
	}

	@Test
	public void testExcluir() {
		Carro carro = new Carro();
		
		carro.setGrupo("B");
		carro.setModelo("Tippo");
		carro.setFabricante("Fiat");
		carro.setDisponibilidade(true);
		carro.setNecessitaDeConserto(false);
		carro.setQuilometragem(1000.0);
		carro.setUltimaRevisao(new Date(11-11-2012));
		carro.setFilial("RJ");
		carro.setAno("2014");
		carro.setPlaca("GGG1234");
		carro.setValor("35000");
		
		DAO.salvar(carro);
		DAO.excluir(carro);
		
		List<Carro> carros = DAO.listaCarros();
		
		assertFalse(carros.contains(carro));
	}
}