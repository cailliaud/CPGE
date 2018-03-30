package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	private String comAnaDoc;

	private String comComEcrite;

	private String comComOrale;

	private String comCompSc;

	private String comEntretien;

	private String comGlobal;

	private String comOrgaIdee;

	private int curseurAnaDoc;

	private int curseurComEcrite;

	private int curseurComOrale;

	private int curseurCompSc;

	private int curseurEntretien;

	private int curseurOrgaIdee;

	@Temporal(TemporalType.DATE)
	private Date dateEvaluation;

	private String nomSujet;

	private int pointsAnaDoc;

	private int pointsComEcrite;

	private int pointsComOrale;

	private int pointsCompSc;

	private int pointsEntretien;

	private int pointsOrgaIdee;

	private int pointsTotal;

	private String type;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEtudiant")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Evaluateur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEvaluateur")
	private Evaluateur evaluateur;

	public Evaluation() {
		super();
	}
	public Evaluation(String comAnaDoc, String comComEcrite, String comComOrale, String comCompSc, String comEntretien,
			String comGlobal, String comOrgaIdee, int curseurAnaDoc, int curseurComEcrite,
			int curseurComOrale, int curseurCompSc, int curseurEntretien, int curseurOrgaIdee, Date dateEvaluation,
			Etudiant etu, Evaluateur evaluateur,
			String nomSujet, int pointsAnaDoc, int pointsComEcrite,
			int pointsComOrale, int pointsCompSc, int pointsEntretien, int pointsOrgaIdee) {
		this.comAnaDoc = comAnaDoc;
		this.comComEcrite = comComEcrite;
		this.comComOrale = comComOrale;
		this.comCompSc = comCompSc;
		this.comEntretien = comEntretien;
		this.comGlobal = comGlobal;
		this.comOrgaIdee = comOrgaIdee;
		this.curseurAnaDoc = curseurAnaDoc;
		this.curseurComEcrite = curseurComEcrite;
		this.curseurComOrale = curseurComOrale;
		this.curseurCompSc = curseurCompSc;
		this.curseurEntretien = curseurEntretien;
		this.curseurOrgaIdee = curseurOrgaIdee;
		this.dateEvaluation = dateEvaluation;
		this.etudiant = etu;
		this.evaluateur = evaluateur;
		this.nomSujet = nomSujet;
		this.pointsAnaDoc = pointsAnaDoc;
		this.pointsComEcrite = pointsComEcrite;
		this.pointsComOrale = pointsComOrale;
		this.pointsCompSc = pointsCompSc;
		this.pointsEntretien = pointsEntretien;
		this.pointsOrgaIdee = pointsOrgaIdee;
		
		calculPointsTotal();
	}

	public int getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getComAnaDoc() {
		return this.comAnaDoc;
	}

	public void setComAnaDoc(String comAnaDoc) {
		this.comAnaDoc = comAnaDoc;
	}

	public String getComComEcrite() {
		return this.comComEcrite;
	}

	public void setComComEcrite(String comComEcrite) {
		this.comComEcrite = comComEcrite;
	}

	public String getComComOrale() {
		return this.comComOrale;
	}

	public void setComComOrale(String comComOrale) {
		this.comComOrale = comComOrale;
	}

	public String getComCompSc() {
		return this.comCompSc;
	}

	public void setComCompSc(String comCompSc) {
		this.comCompSc = comCompSc;
	}

	public String getComEntretien() {
		return this.comEntretien;
	}

	public void setComEntretien(String comEntretien) {
		this.comEntretien = comEntretien;
	}

	public String getComGlobal() {
		return this.comGlobal;
	}

	public void setComGlobal(String comGlobal) {
		this.comGlobal = comGlobal;
	}

	public String getComOrgaIdee() {
		return this.comOrgaIdee;
	}

	public void setComOrgaIdee(String comOrgaIdee) {
		this.comOrgaIdee = comOrgaIdee;
	}

	public int getCurseurAnaDoc() {
		return this.curseurAnaDoc;
	}

	public void setCurseurAnaDoc(int curseurAnaDoc) {
		this.curseurAnaDoc = curseurAnaDoc;
	}

	public int getCurseurComEcrite() {
		return this.curseurComEcrite;
	}

	public void setCurseurComEcrite(int curseurComEcrite) {
		this.curseurComEcrite = curseurComEcrite;
	}

	public int getCurseurComOrale() {
		return this.curseurComOrale;
	}

	public void setCurseurComOrale(int curseurComOrale) {
		this.curseurComOrale = curseurComOrale;
	}

	public int getCurseurCompSc() {
		return this.curseurCompSc;
	}

	public void setCurseurCompSc(int curseurCompSc) {
		this.curseurCompSc = curseurCompSc;
	}

	public int getCurseurEntretien() {
		return this.curseurEntretien;
	}

	public void setCurseurEntretien(int curseurEntretien) {
		this.curseurEntretien = curseurEntretien;
	}

	public int getCurseurOrgaIdee() {
		return this.curseurOrgaIdee;
	}

	public void setCurseurOrgaIdee(int curseurOrgaIdee) {
		this.curseurOrgaIdee = curseurOrgaIdee;
	}

	public Date getDateEvaluation() {
		return this.dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public String getNomSujet() {
		return this.nomSujet;
	}

	public void setNomSujet(String nomSujet) {
		this.nomSujet = nomSujet;
	}

	public int getPointsAnaDoc() {
		return this.pointsAnaDoc;
	}

	public void setPointsAnaDoc(int pointsAnaDoc) {
		this.pointsAnaDoc = pointsAnaDoc;
	}

	public int getPointsComEcrite() {
		return this.pointsComEcrite;
	}

	public void setPointsComEcrite(int pointsComEcrite) {
		this.pointsComEcrite = pointsComEcrite;
	}

	public int getPointsComOrale() {
		return this.pointsComOrale;
	}

	public void setPointsComOrale(int pointsComOrale) {
		this.pointsComOrale = pointsComOrale;
	}

	public int getPointsCompSc() {
		return this.pointsCompSc;
	}
	
private void calculPointsTotal() {
		
		pointsTotal = (20*(pointsAnaDoc + pointsComEcrite + pointsComOrale + pointsCompSc + pointsEntretien + pointsOrgaIdee))/30;

	}

	public void setPointsCompSc(int pointsCompSc) {
		this.pointsCompSc = pointsCompSc;
	}

	public int getPointsEntretien() {
		return this.pointsEntretien;
	}

	public void setPointsEntretien(int pointsEntretien) {
		this.pointsEntretien = pointsEntretien;
	}

	public int getPointsOrgaIdee() {
		return this.pointsOrgaIdee;
	}

	public void setPointsOrgaIdee(int pointsOrgaIdee) {
		this.pointsOrgaIdee = pointsOrgaIdee;
	}

	public int getPointsTotal() {
		return this.pointsTotal;
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
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

	public Evaluateur getEvaluateur() {
		return this.evaluateur;
	}

	public void setEvaluateur(Evaluateur evaluateur) {
		this.evaluateur = evaluateur;
	}

}