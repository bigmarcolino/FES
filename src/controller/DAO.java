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
public class DAO {
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
		DAO.init();

		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			DAO.close();
		}
	}

	public static void alterar(Object o) {
		DAO.init();

		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			DAO.close();
		}
	}

	public static void excluir(Object o) {
		DAO.init();

		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			return;
		} finally {
			DAO.close();
		}
	}

	public static List<Motorista> listaMotoristas() {
		DAO.init();
		Query query = null;
		List<Motorista> motoristas = null;

		try {
			query = em.createQuery("FROM Motorista");
			motoristas = (List<Motorista>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			DAO.close();
		}

		return motoristas;
	}

	public static List<Carro> listaCarros() {
		DAO.init();
		Query query = null;
		List<Carro> carros = null;

		try {
			query = em.createQuery("FROM Carro");
			carros = (List<Carro>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			DAO.close();
		}

		return carros;
	}

	// consultas HQL
	public static List<Cliente> listaClientes() {
		DAO.init();
		Query query = null;
		List<Cliente> clientes = null;

		try {
			query = em.createQuery("FROM Cliente");
			clientes = (List<Cliente>) query.getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			DAO.close();
		}

		return clientes;
	}
}