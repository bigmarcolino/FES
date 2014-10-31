package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Carro;
import model.Cliente;
import model.Motorista;

@SuppressWarnings("unchecked")
public class Controlador {
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public static void init() {
		emf = Persistence.createEntityManagerFactory("VoceAlugaLocal");
		em = emf.createEntityManager();
	}

	public static void close() {
		em.close();
	}

	public static void salvar(Object o) {
		Controlador.init();

		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			Controlador.close();
		}
	}

	public static void alterar(Object o) {
		Controlador.init();

		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			Controlador.close();
		}
	}

	public static void excluir(Object o) {
		Controlador.init();

		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			Controlador.close();
		}
	}

	public static List<Motorista> listaMotoristas() {
		Controlador.init();
		Query query = null;
		List<Motorista> motoristas = null;

		try {
			query = em.createQuery("FROM Motorista");
			motoristas = (List<Motorista>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			Controlador.close();
		}

		return motoristas;
	}

	public static List<Carro> listaCarros() {
		Controlador.init();
		Query query = null;
		List<Carro> carros = null;

		try {
			query = em.createQuery("FROM Carro");
			carros = (List<Carro>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			Controlador.close();
		}

		return carros;
	}

	// consultas HQL
	public static List<Cliente> listaClientes() {
		Controlador.init();
		Query query = null;
		List<Cliente> clientes = null;

		try {
			query = em.createQuery("FROM Cliente");
			clientes = (List<Cliente>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			Controlador.close();
		}

		return clientes;
	}
}