package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluateur database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Evaluateur.findAll", query="SELECT e FROM Evaluateur e"),
	@NamedQuery(name="EvaluateurModif.findAll",query="SELECT e FROM Evaluateur e ORDER BY e.nomEvaluateur")})
public class Evaluateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEvaluateur;

	private int estAdmin;

	private String loginEvaluateur;

	private String mdpEvaluateur;

	private String nomEvaluateur;

	private String prenomEvaluateur;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="evaluateur")
	private List<Evaluation> evaluations;

	public Evaluateur() {
		super();
	}

	public int getIdEvaluateur() {
		return this.idEvaluateur;
	}

	public void setIdEvaluateur(int idEvaluateur) {
		this.idEvaluateur = idEvaluateur;
	}

	public int getEstAdmin() {
		return this.estAdmin;
	}

	public void setEstAdmin(int estAdmin) {
		this.estAdmin = estAdmin;
	}

	public String getLoginEvaluateur() {
		return this.loginEvaluateur;
	}

	public void setLoginEvaluateur(String loginEvaluateur) {
		this.loginEvaluateur = loginEvaluateur;
	}

	public String getMdpEvaluateur() {
		return this.mdpEvaluateur;
	}

	public void setMdpEvaluateur(String mdpEvaluateur) {
		this.mdpEvaluateur = mdpEvaluateur;
	}

	public String getNomEvaluateur() {
		return this.nomEvaluateur;
	}

	public void setNomEvaluateur(String nomEvaluateur) {
		this.nomEvaluateur = nomEvaluateur;
	}

	public String getPrenomEvaluateur() {
		return this.prenomEvaluateur;
	}

	public void setPrenomEvaluateur(String prenomEvaluateur) {
		this.prenomEvaluateur = prenomEvaluateur;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setEvaluateur(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setEvaluateur(null);

		return evaluation;
	}

}