package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Joueur;

public class JoueurDao {
	private EntityManager entityManager;
	
	public JoueurDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager=emf.createEntityManager();
	}
	public List<Joueur> getAllJoueur(){
		Query q = entityManager.createNamedQuery("Joueur.findAll");
		return q.getResultList();
	}

}
