package entities;

import java.io.Serializable;
import javax.persistence.*;


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

}