package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompetenceDao;
import dao.EtudiantDao;
import dao.EvaluateurDao;
import dao.SousCategorieDao;
import entities.Competence;
import entities.Etudiant;
import entities.Evaluateur;
import entities.Souscategorie;


/**
 * Servlet implementation class MainServmet
 */
@WebServlet( name="SuppressionEtuServlet", urlPatterns = {"/suppression"} )
public class SuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionServlet() {
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
		
		String a = "hey";
		request.setAttribute("a", a);
		

		request.setAttribute("etudiants", etudiants);
		request.setAttribute("evaluateurs", evaluateurs);
		request.setAttribute("souscategories",souscategories);
		request.setAttribute("competences", competences);

		this.getServletContext().getRequestDispatcher( "/suppression.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etudiant	
		EtudiantDao daoEtudiant = new EtudiantDao();
		String idE = request.getParameter("supetu");			
		if(idE!=null) {
			int idEtudiant = Integer.parseInt(idE);
			daoEtudiant.deleteStudent(idEtudiant);
		}
		
		//Evaluateur
		EvaluateurDao daoEvaluateur = new EvaluateurDao();
		String id = request.getParameter("supeval");
		if (id!=null)
			{int idEvaluateur = Integer.parseInt(id);
			daoEvaluateur.deleteEval(idEvaluateur);}
		
		//Competence
		CompetenceDao daoCompetence = new CompetenceDao();
		String idC = request.getParameter("supcomp");
		if (idC!=null)
		{
			int idCompetence = Integer.parseInt(idC);
			request.setAttribute("test", idCompetence);
			daoCompetence.deleteCompetence(idCompetence);
		}
		
		this.getServletContext().getRequestDispatcher( "/suppression.jsp" ).forward( request, response );
	}

}
