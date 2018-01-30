package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Evaluateur;

public class EvaluateurDao {
private EntityManager entityManager;
	
	public EvaluateurDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager=emf.createEntityManager();
	}
	public List<Evaluateur> getAllEvaluateur(){
		Query q = entityManager.createNamedQuery("Evaluateur.findAll");
		List<Evaluateur> evaluateurs =  q.getResultList();
		return evaluateurs;
	}

	
	

}
