package dao;

import java.util.List;

import javax.persistence.*;

import entities.Etudiant;
import entities.Souscategorie;

public class SousCategorieDao {
private EntityManager entityManager;
	
	public SousCategorieDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager=emf.createEntityManager();
	}
	public List<Souscategorie> getAllSouscategorie(){
		Query q = entityManager.createNamedQuery("Souscategorie.findAll");
		List<Souscategorie> souscategorie =  q.getResultList();
		return souscategorie;
	}
}
