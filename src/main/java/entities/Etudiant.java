package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e"),
	@NamedQuery(name="EtudiantModif.findAll", query="SELECT e FROM Etudiant e ORDER BY e.nomEtudiant"),
	@NamedQuery(name="TheEtudiant",query="SELECT e FROM Etudiant e ")})
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEtudiant;

	@OneToMany(mappedBy="etudiant")
	private Collection<Evaluation> evaluations;
	
	private String loginEtudiant;

	private String mdpEtudiant;

	private String nomEtudiant;

	private String prenomEtudiant;

	public Etudiant() {
		super();
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