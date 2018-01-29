package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the evalue database table.
 * 
 */
@Embeddable
public class EvaluePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idEvaluation;

	@Column(insertable=false, updatable=false)
	private int idCompetence;

	public EvaluePK() {
	}
	public int getIdEvaluation() {
		return this.idEvaluation;
	}
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	public int getIdCompetence() {
		return this.idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EvaluePK)) {
			return false;
		}
		EvaluePK castOther = (EvaluePK)other;
		return 
			(this.idEvaluation == castOther.idEvaluation)
			&& (this.idCompetence == castOther.idCompetence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEvaluation;
		hash = hash * prime + this.idCompetence;
		
		return hash;
	}
}