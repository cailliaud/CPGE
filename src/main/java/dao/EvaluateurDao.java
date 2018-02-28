package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Etudiant;
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
	
	public void addEvaluateur(String nomEval, String prenomEval, int estAdmin, String loginEval, String mdpEval) {
		int value = 0;
		Evaluateur evaluateur = new Evaluateur();
		evaluateur.setNomEvaluateur(nomEval);
		evaluateur.setPrenomEvaluateur(prenomEval);
		/*if (estAdmin=="estadmin") {
			value=1;
		}
		else if (estAdmin=="pasadmin") {
			value=0;
		}*/
		evaluateur.setEstAdmin(estAdmin);
		evaluateur.setLoginEvaluateur(loginEval);
		evaluateur.setMdpEvaluateur(mdpEval);
		/*création d'une transaction*/
		EntityTransaction transaction=entityManager.getTransaction(); 
		/*Démarrer la transaction*/
		transaction.begin();
		try {
			/*enregistrer l'etudiant e dans la base de données*/
			entityManager.persist(evaluateur); 
			/*valider la transaction si tout se passe bien*/
			transaction.commit(); 
		} catch (Exception ex) {
			/*Annuler la transaction en cas d'exception*/
			transaction.rollback(); 
			ex.printStackTrace();
		}
		
	}

	
	

}
