package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evaluateur database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluateur.findAll", query="SELECT e FROM Evaluateur e")
public class Evaluateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEvaluateur;

	private int estAdmin;

	private String loginEvaluateur;

	private String mdpEvaluateur;

	private String nomEvaluateur;

	private String prenomEvaluateur;

	public Evaluateur() {
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

}