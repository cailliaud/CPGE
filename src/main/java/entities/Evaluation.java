package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evaluation database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluation.findAll", query="SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEvaluation;

	private String commG;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int note;

	private String sujet;

	private String type;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="IdEtudiant")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="IdMatiere")
	private Matiere matiere;

	//bi-directional many-to-one association to Evalue
	@OneToMany(mappedBy="evaluation")
	private List<Evalue> evalues;

	public Evaluation() {
	}

	public int getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getCommG() {
		return this.commG;
	}

	public void setCommG(String commG) {
		this.commG = commG;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getSujet() {
		return this.sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Evalue> getEvalues() {
		return this.evalues;
	}

	public void setEvalues(List<Evalue> evalues) {
		this.evalues = evalues;
	}

	public Evalue addEvalue(Evalue evalue) {
		getEvalues().add(evalue);
		evalue.setEvaluation(this);

		return evalue;
	}

	public Evalue removeEvalue(Evalue evalue) {
		getEvalues().remove(evalue);
		evalue.setEvaluation(null);

		return evalue;
	}

}