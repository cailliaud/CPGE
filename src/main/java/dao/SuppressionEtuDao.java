package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Etudiant;

public class SuppressionEtuDao {
private EntityManager entityManager;

public void EtudiantDao() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPGE_PU");
	entityManager=emf.createEntityManager();
}

public void deleteEtu (String IdEtudiant) {

	Etudiant e = entityManager.find(Etudiant.class, IdEtudiant);
	entityManager.remove(e);
	
			
}

}
