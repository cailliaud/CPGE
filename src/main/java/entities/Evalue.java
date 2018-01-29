package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evalue database table.
 * 
 */
@Entity
@NamedQuery(name="Evalue.findAll", query="SELECT e FROM Evalue e")
public class Evalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EvaluePK id;

	private int curseur;

	//bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name="IdCompetence")
	private Competence competence;

	//bi-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="IdEvaluation")
	private Evaluation evaluation;

	public Evalue() {
	}

	public EvaluePK getId() {
		return this.id;
	}

	public void setId(EvaluePK id) {
		this.id = id;
	}

	public int getCurseur() {
		return this.curseur;
	}

	public void setCurseur(int curseur) {
		this.curseur = curseur;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Evaluation getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}