package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.*;

public class EvaluationDao {
	private EntityManager entityManager;

	public EvaluationDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager = emf.createEntityManager();
	}

	public List<Evaluation> getAllEvaluation() {
		Query q = entityManager.createNamedQuery("Evaluation.findAll");
		List<Evaluation> evaluations = q.getResultList();
		return evaluations;
	}
	
	/**
		 * Allows to get the list of evaluation of one student 
		 * @param id
		 * @return list of evaluation
		 */
	public List<Evaluation> getEvalEtu(int id ){
		Query q = entityManager.createQuery("from Evaluation where IdEtudiant = :x ");
		q.setParameter("x", id); 
		List<Evaluation> e =q.getResultList();
		return e;
	}
		
		/**
		 * Allows to get the list of the evaluation of one evaluateur
		 * @param id
		 * @return list of evaluation 
		 */
	public List<Evaluation> getEvalEvaluateur(int id ){
		Query q = entityManager.createQuery("from Evaluation where IdEvaluateur = :x ");
		q.setParameter("x", id); 
		List<Evaluation> e =q.getResultList();
		return e;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		/*création d'une transaction*/
		EntityTransaction transaction=entityManager.getTransaction(); 
		
		/*Démarrer la transaction*/
		transaction.begin();
		try {
			entityManager.persist(evaluation);
			transaction.commit(); 
		} catch (Exception ex) {
			/*Annuler la transaction en cas d'exception*/
			transaction.rollback(); 
			ex.printStackTrace();
		}
	}

}
