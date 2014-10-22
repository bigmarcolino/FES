package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Carro;
import model.Motorista;

@SuppressWarnings("unchecked")
public class Controlador {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	public static void init(){
		emf = Persistence.createEntityManagerFactory( "VoceAluga" );
		em = emf.createEntityManager();
	}
	
	public static void close(){
		em.close();
	}
	
	public static void salvar(Object o){
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();

	}
	
	public static void alterar(Object o){
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}
	
	public static void excluir(Object o){
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}
	
	public static List<Motorista> listaMotoristas(){
		Query query = em.createQuery("FROM Motorista");		
		return (List<Motorista>) query.getResultList();		
	}
	
	public static List<Carro> listaCarros(){
		Query query = em.createQuery("FROM Carro"); //procurar consultas em HQL no google caso queira saber mais
		return (List<Carro>) query.getResultList();		
	}
}
