package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entities.*;


/**
 * Servlet implementation class MainServmet
 */
@WebServlet( name="AccueilServlet", urlPatterns = {"/index"} )
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EtudiantDao dao = new EtudiantDao();
		List<Etudiant> etudiants = dao.getAllStudents();
		
		EvaluateurDao daoevaluateur = new EvaluateurDao();
		List<Evaluateur> evaluateurs = daoevaluateur.getAllEvaluateur();
		
		SousCategorieDao daosouscategorie = new SousCategorieDao();
		List<Souscategorie> souscategories = daosouscategorie.getAllSouscategorie();
		
		CompetenceDao daocompetence = new CompetenceDao();
		List<Competence> competences = daocompetence.getAllCompetence();
		
		EvaluationDao daoevaluation = new EvaluationDao();
		List<Evaluation> evaluations = daoevaluation.getAllEvaluation();
		

		request.setAttribute("etudiants", etudiants);
		request.setAttribute("evaluateurs", evaluateurs);
		request.setAttribute("souscategories",souscategories);
		request.setAttribute("competences", competences);
		request.setAttribute("evaluations", evaluations);

		this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etudiant
		//String nomE = request.getParameter("nometu");
		//String prenomE = request.getParameter("prenometu");
		//String loginE = request.getParameter("loginetu");
		//String mdpE = request.getParameter("mdpetu");
		
		//String idE = request.getParameter("supetu");		
		//int idEtudiant = Integer.parseInt(idE);
		
		//request.setAttribute("nomE", nomE);
		//request.setAttribute("prenomE", prenomE);
		//request.setAttribute("loginE", loginE);
		//request.setAttribute("mdpE", mdpE);
		
		//EtudiantDao daoEtudiant = new EtudiantDao();
		//daoEtudiant.addStudent(nomE,prenomE,loginE, mdpE);
		//daoEtudiant.deleteStudent(idEtudiant);
		
		//Evaluateur
		//String nomEval = request.getParameter("nomeval");
		//String prenomEval = request.getParameter("prenomeval");
		//String estA = request.getParameter("estadmin");
		//int estAdmin = Integer.parseInt(estA);
		//int estAdmin = 1;
		//String loginEval = request.getParameter("logineval");
		//String mdpEval = request.getParameter("mdpeval");
		
		//String id = request.getParameter("supeval");		
		//int idEvaluateur = Integer.parseInt(id);

		
		//request.setAttribute("nomEval", nomEval);
		//request.setAttribute("prenomEval", prenomEval);
		//request.setAttribute("admin", estAdmin);
		//request.setAttribute("loginEval", loginEval);
		//request.setAttribute("mdpEval", mdpEval);
		
		//EvaluateurDao daoEvaluateur = new EvaluateurDao();
		//daoEvaluateur.addEvaluateur(nomEval, prenomEval, estAdmin, loginEval, mdpEval);
		//daoEvaluateur.deleteEval(idEvaluateur);
		
		//compétences
		//String nomCompetence = request.getParameter("nomcompetence");
		//String valeur = request.getParameter("valcurseur");
		//int valeurCurseur = Integer.parseInt(valeur);
		//int valeurCurseur = 1;
		//String ssCategorie = request.getParameter("sscat");
		//int idSsCategorie = Integer.parseInt(ssCategorie);
		//int idSsCategorie = 1;
		
		//request.setAttribute("nomCompetence", nomCompetence);
		//request.setAttribute("valeurCurseur", valeurCurseur);
		//request.setAttribute("nomCatégorie", ssCategorie);
		
		//CompetenceDao daoCompetence = new CompetenceDao();
		//daoCompetence.addCompetence(nomCompetence, nomCompetence, valeurCurseur, idSsCategorie);
		
		this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
	}

}
