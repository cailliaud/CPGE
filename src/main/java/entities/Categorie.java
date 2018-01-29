package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategorie;

	private String nomCategorie;

	//bi-directional many-to-one association to Souscategorie
	@OneToMany(mappedBy="categorie")
	private List<Souscategorie> souscategories;

	public Categorie() {
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Souscategorie> getSouscategories() {
		return this.souscategories;
	}

	public void setSouscategories(List<Souscategorie> souscategories) {
		this.souscategories = souscategories;
	}

	public Souscategorie addSouscategory(Souscategorie souscategory) {
		getSouscategories().add(souscategory);
		souscategory.setCategorie(this);

		return souscategory;
	}

	public Souscategorie removeSouscategory(Souscategorie souscategory) {
		getSouscategories().remove(souscategory);
		souscategory.setCategorie(null);

		return souscategory;
	}

}