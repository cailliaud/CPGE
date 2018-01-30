package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMatiere;

	private String nomMatiere;

	public Matiere() {
	}

	public int getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

}