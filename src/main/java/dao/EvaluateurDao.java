package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public List<Evaluateur> getAllEvaluateurModif() {
		Query q = entityManager.createNamedQuery("EvaluateurModif.findAll");
		List<Evaluateur> evaluateurs = q.getResultList();
		return evaluateurs;
	}
	
	public Evaluateur getEvaluateurById(int IdEvaluateur) {
		 TypedQuery<Evaluateur> query = entityManager.createQuery(
		        "SELECT e FROM Evaluateur e WHERE e.idEvaluateur = :IdEvaluateur", Evaluateur.class);
		    return query.setParameter("IdEvaluateur", IdEvaluateur).getSingleResult();
	} 
	
	public void addEvaluateur(String nomEval, String prenomEval, int estAdmin, String loginEval, String mdpEval) {
		Evaluateur evaluateur = new Evaluateur();
		evaluateur.setNomEvaluateur(nomEval);
		evaluateur.setPrenomEvaluateur(prenomEval);
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
	public void deleteEval (int IdEvaluateur) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Evaluateur eval = entityManager.find(Evaluateur.class, IdEvaluateur);
		try {
			entityManager.remove(eval);
			transaction.commit();
		} catch (Exception ex ) {
			transaction.rollback();
			ex.printStackTrace();
		}
		
	}
	
	public void modifEvaluateur(int IdEvaluateur, String newNom, String newPrenom, int newadmin, String newLogin, String newMdp) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Evaluateur eval = entityManager.find(Evaluateur.class, IdEvaluateur);
		try {
			eval.setNomEvaluateur(newNom);
			eval.setPrenomEvaluateur(newPrenom);
			eval.setEstAdmin(newadmin);
			eval.setLoginEvaluateur(newLogin);
			eval.setMdpEvaluateur(newMdp);
			entityManager.getTransaction();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		
	}
	
	public int loginExistEvaluateur(String login) { 
		Query q = entityManager.createQuery("from Evaluateur where loginEvaluateur = :x ");
		q.setParameter("x", login); 
		List<Evaluateur> e =q.getResultList();
		return e.size();
		}
	
	public int passExistEvaluateur(String mdp) { 
		Query q = entityManager.createQuery("from Evaluateur where mdpEvaluateur = :x ");
		q.setParameter("x", mdp); 
		List<Evaluateur> e =q.getResultList();
		return e.size();
		}
	public boolean isAdmin(String login) {
		Query q = entityManager.createQuery("from Evaluateur where loginEvaluateur = :x ");
		q.setParameter("x", login);
		boolean b; 
		List<Evaluateur> e =q.getResultList();
		if (e.size()==1) {
			if (e.get(0).getEstAdmin()==1) 
			{b=true;}
			else {b=false;}
			} 
		else {b=false;}
		return b; 
		}
	
	public int getIdEval(String login) {
		int x; 
		Query q = entityManager.createQuery("from Evaluateur where loginEvaluateur = :x ");
		q.setParameter("x", login); 
		List<Evaluateur> e =q.getResultList();
		x = e.get(0).getIdEvaluateur();
		return x; 
	}
	
	

}
