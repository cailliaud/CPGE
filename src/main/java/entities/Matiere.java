package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMatiere;

	private String nomMatiere;

	//bi-directional many-to-one association to Evaluateur
	@OneToMany(mappedBy="matiere")
	private List<Evaluateur> evaluateurs;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="matiere")
	private List<Evaluation> evaluations;

	public Matiere() {
	}

	public int getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public List<Evaluateur> getEvaluateurs() {
		return this.evaluateurs;
	}

	public void setEvaluateurs(List<Evaluateur> evaluateurs) {
		this.evaluateurs = evaluateurs;
	}

	public Evaluateur addEvaluateur(Evaluateur evaluateur) {
		getEvaluateurs().add(evaluateur);
		evaluateur.setMatiere(this);

		return evaluateur;
	}

	public Evaluateur removeEvaluateur(Evaluateur evaluateur) {
		getEvaluateurs().remove(evaluateur);
		evaluateur.setMatiere(null);

		return evaluateur;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setMatiere(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setMatiere(null);

		return evaluation;
	}

}