package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String nomCompetence;

	private int valeurMaxCurseur;

	//bi-directional many-to-one association to Souscategorie
	@ManyToOne
	@JoinColumn(name="IdSousCategorie")
	private Souscategorie souscategorie;

	//bi-directional many-to-one association to Evalue
	@OneToMany(mappedBy="competence")
	private List<Evalue> evalues;

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

	public Souscategorie getSouscategorie() {
		return this.souscategorie;
	}

	public void setSouscategorie(Souscategorie souscategorie) {
		this.souscategorie = souscategorie;
	}

	public List<Evalue> getEvalues() {
		return this.evalues;
	}

	public void setEvalues(List<Evalue> evalues) {
		this.evalues = evalues;
	}

	public Evalue addEvalue(Evalue evalue) {
		getEvalues().add(evalue);
		evalue.setCompetence(this);

		return evalue;
	}

	public Evalue removeEvalue(Evalue evalue) {
		getEvalues().remove(evalue);
		evalue.setCompetence(null);

		return evalue;
	}

}