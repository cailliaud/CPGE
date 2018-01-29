package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metier database table.
 * 
 */
@Entity
@NamedQuery(name="Metier.findAll", query="SELECT m FROM Metier m")
public class Metier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_METIER")
	private int idMetier;

	private String nom;

	//bi-directional many-to-one association to Joueur
	@OneToMany(mappedBy="metier")
	private List<Joueur> joueurs;

	public Metier() {
	}

	public int getIdMetier() {
		return this.idMetier;
	}

	public void setIdMetier(int idMetier) {
		this.idMetier = idMetier;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueur addJoueur(Joueur joueur) {
		getJoueurs().add(joueur);
		joueur.setMetier(this);

		return joueur;
	}

	public Joueur removeJoueur(Joueur joueur) {
		getJoueurs().remove(joueur);
		joueur.setMetier(null);

		return joueur;
	}

}