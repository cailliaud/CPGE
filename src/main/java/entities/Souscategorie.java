package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String nomSousCategorie;

	//bi-directional many-to-one association to Competence
	@OneToMany(mappedBy="souscategorie")
	private List<Competence> competences;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="IdCategorie")
	private Categorie categorie;

	public Souscategorie() {
	}

	public int getIdSousCategorie() {
		return this.idSousCategorie;
	}

	public void setIdSousCategorie(int idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}

	public String getNomSousCategorie() {
		return this.nomSousCategorie;
	}

	public void setNomSousCategorie(String nomSousCategorie) {
		this.nomSousCategorie = nomSousCategorie;
	}

	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Competence addCompetence(Competence competence) {
		getCompetences().add(competence);
		competence.setSouscategorie(this);

		return competence;
	}

	public Competence removeCompetence(Competence competence) {
		getCompetences().remove(competence);
		competence.setSouscategorie(null);

		return competence;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}