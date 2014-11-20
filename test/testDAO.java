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
		//criei um carro
		Carro carro = new Carro(); 

		//setei os campos do carro criado
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
		
		//salvei o carro no banco
		DAO.salvar(carro);
		
		//carreguei a lista de todos os carros
		List<Carro> carros = DAO.listaCarros();
	
		//verifico se nessa lista contém o carro que criei e salvei
		assertTrue(carros.contains(carro));
	}

	public void testAlterar() {
		List<Carro> carros = DAO.listaCarros();
		
		Carro carro = carros.get(0);		
		Carro carroCopia = DAO.getCarroById(carro.getIdCarro());
		
		carro.setAno("111");
		DAO.alterar(carro);
		
		carros = DAO.listaCarros();
		carro = null;
		for (Carro c : carros)
			if (c.equals(carroCopia)) //olha soh o ID
				carro = c;
		
		assertFalse(carro.ehCompletamenteIgual(carroCopia));
	}

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
		String id = carro.getIdCarro();
		DAO.excluir(carro);
		carro.setIdCarro(id);
		//NAO TESTEI, ver se resolve!!!
		
		List<Carro> carros = DAO.listaCarros();
		
		assertFalse(carros.contains(carro));
	}
}