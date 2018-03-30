package bean;

public class Utilisateur {

	private int id; 
	private String login;
    private String motDePasse;
    private String profil; 
    private String nom;
    private String prenom;

    public String getNom() {
    	return nom;
        }
    
    public String getPrenom() {
    	return prenom;
        }
    
    public void setLogin(String login) {
	this.login = login;
    }
    public String getLogin() {
	return login;
    }

    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
	return motDePasse;
    }
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    
	
}
