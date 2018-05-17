package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.*;

import entities.Etudiant;
import entities.Evaluateur;

public class EtudiantDao {
	;
	private EntityManager entityManager;

	public EtudiantDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
		entityManager = emf.createEntityManager();
	}

	public List<Etudiant> getAllStudents() {
		Query q = entityManager.createNamedQuery("Etudiant.findAll");
		List<Etudiant> joueurs = q.getResultList();
		return joueurs;
	}
	
	public List<Etudiant> getAllStudentsModif() {
		Query q = entityManager.createNamedQuery("EtudiantModif.findAll");
		List<Etudiant> etu = q.getResultList();
		return etu;
	}
	
	public Etudiant getEtudiantById(int IdE) {
		 TypedQuery<Etudiant> query = entityManager.createQuery(
		        "SELECT e FROM Etudiant e WHERE e.idEtudiant = :IdE", Etudiant.class);
		    return query.setParameter("IdE", IdE).getSingleResult();
	} 

	public void addStudent(String nomE, String prenomE, String loginE, String mdpE) {
		Etudiant etu = new Etudiant();
		etu.setNomEtudiant(nomE);
		etu.setPrenomEtudiant(prenomE);
		etu.setLoginEtudiant(loginE);
		etu.setMdpEtudiant(mdpE);
		/* création d'une transaction */
		EntityTransaction transaction = entityManager.getTransaction();
		/* Démarrer la transaction */
		transaction.begin();
		try {
			/* enregistrer l'etudiant e dans la base de données */
			entityManager.persist(etu);
			/* valider la transaction si tout se passe bien */
			transaction.commit();
		} catch (Exception ex) {
			/* Annuler la transaction en cas d'exception */
			transaction.rollback();
			ex.printStackTrace();
		}

	}

	public void deleteStudent(int IdEtudiant) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Etudiant etu = entityManager.find(Etudiant.class, IdEtudiant);
		try {
			entityManager.remove(etu);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}

	}
	
	public void modifStudent(int IdEtudiant, String newNom, String newPrenom, String newLogin, String newMdp) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Etudiant etu = entityManager.find(Etudiant.class, IdEtudiant);
		try {
			etu.setNomEtudiant(newNom);
			etu.setPrenomEtudiant(newPrenom);
			etu.setLoginEtudiant(newLogin);
			etu.setMdpEtudiant(newMdp);
			entityManager.getTransaction();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		
	}
	
	public int loginExistEtu(String login) { 
		Query q = entityManager.createQuery("from Etudiant where loginEtudiant = :x ");
		q.setParameter("x", login); 
		List<Etudiant> e =q.getResultList();
		return e.size();
		}
	
	public int passExistEtu(String mdp) { 
		Query q = entityManager.createQuery("from Etudiant where mdpEtudiant = :x ");
		q.setParameter("x", mdp); 
		List<Etudiant> e =q.getResultList();
		return e.size();
		}
	public int getIdEtu(String login) {
		int x; 
		Query q = entityManager.createQuery("from Etudiant where loginEtudiant = :x ");
		q.setParameter("x", login); 
		List<Etudiant> e =q.getResultList();
		x = e.get(0).getIdEtudiant();
		return x; 
	}
}
