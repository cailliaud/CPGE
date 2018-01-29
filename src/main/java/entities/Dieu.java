package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dieu database table.
 * 
 */
@Entity
@NamedQuery(name="Dieu.findAll", query="SELECT d FROM Dieu d")
public class Dieu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DIEU")
	private int idDieu;

	private String nom;

	@Column(name="URL_IMG")
	private String urlImg;

	//bi-directional many-to-one association to Pouvoir
	@ManyToOne
	@JoinColumn(name="POUVOIR_PRINCIPAL")
	private Pouvoir pouvoir1;

	//bi-directional many-to-one association to Pouvoir
	@ManyToOne
	@JoinColumn(name="POUVOIR_SECONDAIRE")
	private Pouvoir pouvoir2;

	//bi-directional many-to-many association to Race
	@ManyToMany
	@JoinTable(
		name="engendre"
		, joinColumns={
			@JoinColumn(name="ID_DIEU")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_RACE")
			}
		)
	private List<Race> races;

	//bi-directional many-to-one association to Joueur
	@OneToMany(mappedBy="dieu")
	private List<Joueur> joueurs;

	public Dieu() {
	}

	public int getIdDieu() {
		return this.idDieu;
	}

	public void setIdDieu(int idDieu) {
		this.idDieu = idDieu;
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

	public Pouvoir getPouvoir1() {
		return this.pouvoir1;
	}

	public void setPouvoir1(Pouvoir pouvoir1) {
		this.pouvoir1 = pouvoir1;
	}

	public Pouvoir getPouvoir2() {
		return this.pouvoir2;
	}

	public void setPouvoir2(Pouvoir pouvoir2) {
		this.pouvoir2 = pouvoir2;
	}

	public List<Race> getRaces() {
		return this.races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueur addJoueur(Joueur joueur) {
		getJoueurs().add(joueur);
		joueur.setDieu(this);

		return joueur;
	}

	public Joueur removeJoueur(Joueur joueur) {
		getJoueurs().remove(joueur);
		joueur.setDieu(null);

		return joueur;
	}

}