package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.*;

import entities.Etudiant;



public class EtudiantDao {;
	private EntityManager entityManager;
	
	public EtudiantDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager=emf.createEntityManager();
	}
	public List<Etudiant> getAllStudents(){
		Query q = entityManager.createNamedQuery("Etudiant.findAll");
		List<Etudiant> joueurs =  q.getResultList();
		return joueurs;
	}
	
	public void addStudent(String nomE, String prenomE, String loginE, String mdpE) {
		Etudiant etu = new Etudiant();
		etu.setNomEtudiant(nomE);
		etu.setPrenomEtudiant(prenomE);
		etu.setLoginEtudiant(loginE);
		etu.setMdpEtudiant(mdpE);
		/*création d'une transaction*/
		EntityTransaction transaction=entityManager.getTransaction(); 
		/*Démarrer la transaction*/
		transaction.begin();
		try {
			/*enregistrer l'etudiant e dans la base de données*/
			entityManager.persist(etu); 
			/*valider la transaction si tout se passe bien*/
			transaction.commit(); 
		} catch (Exception ex) {
			/*Annuler la transaction en cas d'exception*/
			transaction.rollback(); 
			ex.printStackTrace();
		}
		
	}

}
