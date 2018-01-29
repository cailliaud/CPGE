package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEtudiant;

	private String loginEtudiant;

	private String mdpEtudiant;

	private String nomEtudiant;

	private String prenomEtudiant;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="etudiant")
	private List<Evaluation> evaluations;

	public Etudiant() {
	}

	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getLoginEtudiant() {
		return this.loginEtudiant;
	}

	public void setLoginEtudiant(String loginEtudiant) {
		this.loginEtudiant = loginEtudiant;
	}

	public String getMdpEtudiant() {
		return this.mdpEtudiant;
	}

	public void setMdpEtudiant(String mdpEtudiant) {
		this.mdpEtudiant = mdpEtudiant;
	}

	public String getNomEtudiant() {
		return this.nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return this.prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setEtudiant(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setEtudiant(null);

		return evaluation;
	}

}