package dao;

import java.util.List;

import javax.persistence.*;

import entities.*;

public class CompetenceDao {
private EntityManager entityManager;
	
	public CompetenceDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager=emf.createEntityManager();
	}
	public List<Competence> getAllCompetence(){
		Query q = entityManager.createNamedQuery("Competence.findAll");
		List<Competence> competences =  q.getResultList();
		return competences;
	}
	
	public void addCompetence(String nomC, String com, int curseur, int idSC) {
		Competence competence = new Competence();
		competence.setNomCompetence(nomC);
		competence.setCommentaire(com);
		competence.setValeurMaxCurseur(curseur);
		competence.setIdSousCategorie(idSC);
		/*création d'une transaction*/
		EntityTransaction transaction=entityManager.getTransaction(); 
		/*Démarrer la transaction*/
		transaction.begin();
		try {
			/*enregistrer l'etudiant e dans la base de données*/
			entityManager.persist(competence); 
			/*valider la transaction si tout se passe bien*/
			transaction.commit(); 
		} catch (Exception ex) {
			/*Annuler la transaction en cas d'exception*/
			transaction.rollback(); 
			ex.printStackTrace();
		}
		
	}
	
	public void deleteCompetence(int IdCompetence) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Competence comp = entityManager.find(Competence.class, IdCompetence);
		try {
			entityManager.remove(comp);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}

	}
}
