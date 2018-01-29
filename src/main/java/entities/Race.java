package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the race database table.
 * 
 */
@Entity
@NamedQuery(name="Race.findAll", query="SELECT r FROM Race r")
public class Race implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RACE")
	private int idRace;

	private String information;

	private String nom;

	@Column(name="URL_IMG")
	private String urlImg;

	//bi-directional many-to-many association to Dieu
	@ManyToMany(mappedBy="races")
	private List<Dieu> dieus;

	//bi-directional many-to-one association to Joueur
	@OneToMany(mappedBy="race")
	private List<Joueur> joueurs;

	public Race() {
	}

	public int getIdRace() {
		return this.idRace;
	}

	public void setIdRace(int idRace) {
		this.idRace = idRace;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrlImg() {
		return this.urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public List<Dieu> getDieus() {
		return this.dieus;
	}

	public void setDieus(List<Dieu> dieus) {
		this.dieus = dieus;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueur addJoueur(Joueur joueur) {
		getJoueurs().add(joueur);
		joueur.setRace(this);

		return joueur;
	}

	public Joueur removeJoueur(Joueur joueur) {
		getJoueurs().remove(joueur);
		joueur.setRace(null);

		return joueur;
	}

}