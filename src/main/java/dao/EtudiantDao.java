package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Etudiant;

public class EtudiantDao {
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

}
