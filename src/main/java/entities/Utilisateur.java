package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_UTI")
	private int idUti;

	private String login;

	private String password;

	//bi-directional many-to-one association to Joueur
	@OneToMany(mappedBy="utilisateur")
	private List<Joueur> joueurs;

	public Utilisateur() {
	}

	public int getIdUti() {
		return this.idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueur addJoueur(Joueur joueur) {
		getJoueurs().add(joueur);
		joueur.setUtilisateur(this);

		return joueur;
	}

	public Joueur removeJoueur(Joueur joueur) {
		getJoueurs().remove(joueur);
		joueur.setUtilisateur(null);

		return joueur;
	}

}