package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the joueur database table.
 * 
 */
@Entity
@NamedQuery(name="Joueur.findAll", query="SELECT j FROM Joueur j")
public class Joueur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JOUEUR")
	private int idJoueur;

	private int age;

	@Lob
	private String description;

	private String nom;

	private int poids;

	private String sexe;

	private int taille;



	//bi-directional many-to-one association to Dieu
	@ManyToOne
	@JoinColumn(name="ID_DIEU")
	private Dieu dieu;

	//bi-directional many-to-one association to Metier
	@ManyToOne
	@JoinColumn(name="ID_METIER")
	private Metier metier;

	//bi-directional many-to-one association to Race
	@ManyToOne
	@JoinColumn(name="ID_RACE")
	private Race race;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="ID_UTI")
	private Utilisateur utilisateur;

	public Joueur() {
	}

	public int getIdJoueur() {
		return this.idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoids() {
		return this.poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}



	

	public Dieu getDieu() {
		return this.dieu;
	}

	public void setDieu(Dieu dieu) {
		this.dieu = dieu;
	}

	public Metier getMetier() {
		return this.metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}