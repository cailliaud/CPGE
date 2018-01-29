package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pouvoir database table.
 * 
 */
@Entity
@NamedQuery(name="Pouvoir.findAll", query="SELECT p FROM Pouvoir p")
public class Pouvoir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_POUVOIR")
	private int idPouvoir;

	private String nom;

	//bi-directional many-to-one association to Dieu
	@OneToMany(mappedBy="pouvoir1")
	private List<Dieu> dieus1;

	//bi-directional many-to-one association to Dieu
	@OneToMany(mappedBy="pouvoir2")
	private List<Dieu> dieus2;

	public Pouvoir() {
	}

	public int getIdPouvoir() {
		return this.idPouvoir;
	}

	public void setIdPouvoir(int idPouvoir) {
		this.idPouvoir = idPouvoir;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Dieu> getDieus1() {
		return this.dieus1;
	}

	public void setDieus1(List<Dieu> dieus1) {
		this.dieus1 = dieus1;
	}

	public Dieu addDieus1(Dieu dieus1) {
		getDieus1().add(dieus1);
		dieus1.setPouvoir1(this);

		return dieus1;
	}

	public Dieu removeDieus1(Dieu dieus1) {
		getDieus1().remove(dieus1);
		dieus1.setPouvoir1(null);

		return dieus1;
	}

	public List<Dieu> getDieus2() {
		return this.dieus2;
	}

	public void setDieus2(List<Dieu> dieus2) {
		this.dieus2 = dieus2;
	}

	public Dieu addDieus2(Dieu dieus2) {
		getDieus2().add(dieus2);
		dieus2.setPouvoir2(this);

		return dieus2;
	}

	public Dieu removeDieus2(Dieu dieus2) {
		getDieus2().remove(dieus2);
		dieus2.setPouvoir2(null);

		return dieus2;
	}

}