package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCompetence;

	private String commentaire;

	private int idSousCategorie;

	private String nomCompetence;

	private int valeurMaxCurseur;

	public Competence() {
	}

	public int getIdCompetence() {
		return this.idCompetence;
	}

	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getIdSousCategorie() {
		return this.idSousCategorie;
	}

	public void setIdSousCategorie(int idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}

	public String getNomCompetence() {
		return this.nomCompetence;
	}

	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}

	public int getValeurMaxCurseur() {
		return this.valeurMaxCurseur;
	}

	public void setValeurMaxCurseur(int valeurMaxCurseur) {
		this.valeurMaxCurseur = valeurMaxCurseur;
	}

}