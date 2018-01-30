package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the souscategorie database table.
 * 
 */
@Entity
@NamedQuery(name="Souscategorie.findAll", query="SELECT s FROM Souscategorie s")
public class Souscategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSousCategorie;

	private int idCategorie;

	private String nomSousCategorie;

	public Souscategorie() {
	}

	public int getIdSousCategorie() {
		return this.idSousCategorie;
	}

	public void setIdSousCategorie(int idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomSousCategorie() {
		return this.nomSousCategorie;
	}

	public void setNomSousCategorie(String nomSousCategorie) {
		this.nomSousCategorie = nomSousCategorie;
	}

}