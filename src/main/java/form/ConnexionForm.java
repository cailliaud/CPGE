package form;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Utilisateur;
import dao.EtudiantDao;
import dao.EvaluateurDao;

public final class ConnexionForm {
    private static final String CHAMP_LOGIN  = "login";
    private static final String CHAMP_PASS   = "motdepasse";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        /* R�cup�ration des champs du formulaire */
        String login = getValeurChamp( request, CHAMP_LOGIN );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Utilisateur utilisateur = new Utilisateur();
        EvaluateurDao dao = new EvaluateurDao();
        EtudiantDao daoEtu = new EtudiantDao(); 

        /* Validation du champ email. */
        try {
            validationLogin( login );
        } catch ( Exception e ) {
            setErreur( CHAMP_LOGIN, e.getMessage() );
        }
        utilisateur.setLogin( login );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setMotDePasse( motDePasse );
        /* Mise en place du profil et recuperation de l'ID dans la session */
        if(isEtu(login)==true) {
        	utilisateur.setProfil("Etudiant");
        	utilisateur.setId(daoEtu.getIdEtu(login));
        }
        else if (isEvaluateur(login)==true) {
        	utilisateur.setProfil("Evaluateur"); 
        	utilisateur.setId(dao.getIdEval(login));
        }
        else if (dao.isAdmin(login)==true) {
        	utilisateur.setProfil("Administrateur");
        	utilisateur.setId(dao.getIdEval(login));
        }

        /* Initialisation du r�sultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s de la connexion.";
        } else {
            resultat = "�chec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationLogin( String log ) throws Exception {
    	EtudiantDao dao = new EtudiantDao();
    	EvaluateurDao daoEva = new EvaluateurDao();
        if ( dao.loginExistEtu(log)!=1 && daoEva.loginExistEvaluateur(log)!=1)  {
            throw new Exception( "Vous n'�tes pas enregistr�"+dao.loginExistEtu(log) );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String mdp ) throws Exception {
    	EtudiantDao daoEtu = new EtudiantDao();
    	EvaluateurDao daoEva = new EvaluateurDao();
        if ( daoEtu.passExistEtu(mdp)==0 && daoEva.passExistEvaluateur(mdp)==0 ) {
            throw new Exception( "Ce mot de passe n'est pas le bon" );
        }
    }
    /**
     * Retourne vrai ou faux si c'est un etudiant via le login en param�tre 
     * @param log
     * @return b
     */
    public boolean isEtu( String log ) {
    	EtudiantDao dao = new EtudiantDao();
    	boolean b;
    	if (dao.loginExistEtu(log)!=1) {
    		b=false;
    	}
    	else {
    		b=true;
    	}
    	return b; 
    }
    /**
     * Retourne vrai ou faux si c'est un evaluateur via le login en param�tre 
     * @param log
     * @return b
     */
    public boolean isEvaluateur( String log ) {
    	EvaluateurDao dao = new EvaluateurDao();
    	boolean b;
    	if (dao.loginExistEvaluateur(log)==1 && dao.isAdmin(log)==false) {
    		b=true;
    	}
    	else {
    		b=false;
    	}
    	return b; 
    }

    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}