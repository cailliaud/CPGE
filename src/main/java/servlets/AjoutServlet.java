package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDao;
import dao.EvaluateurDao;
import dao.SousCategorieDao;
import entities.Competence;
import entities.Souscategorie;
import dao.CompetenceDao;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet(name = "AjoutServlet", urlPatterns = { "/ajout" })
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SousCategorieDao daosouscategorie = new SousCategorieDao();
		List<Souscategorie> souscategories = daosouscategorie.getAllSouscategorie();
		
		request.setAttribute("souscategories",souscategories);

		
		this.getServletContext().getRequestDispatcher("/ajout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etudiant
		String nomE = request.getParameter("nometu");
		String prenomE = request.getParameter("prenometu");
		String loginE = request.getParameter("loginetu");
		String mdpE = request.getParameter("mdpetu");

		request.setAttribute("nomE", nomE);
		request.setAttribute("prenomE", prenomE);
		request.setAttribute("loginE", loginE);
		request.setAttribute("mdpE", mdpE);

		EtudiantDao daoEtudiant = new EtudiantDao();
		daoEtudiant.addStudent(nomE, prenomE, loginE, mdpE);


		// Evaluateur
		EvaluateurDao daoEvaluateur = new EvaluateurDao();
		
		String nomEval = request.getParameter("nomeval");
		String prenomEval = request.getParameter("prenomeval");
		String loginEval = request.getParameter("logineval");
		String mdpEval = request.getParameter("mdpeval");
		
		String estA = request.getParameter("estadmin");
		if (estA != null && nomEval.length()!=0 && prenomEval.length()!=0 && loginEval.length()!=0 && mdpEval.length()!=0) {
			int estAdmin = Integer.parseInt(estA);
			daoEvaluateur.addEvaluateur(nomEval, prenomEval, estAdmin, loginEval,mdpEval);
		}
		
		// request.setAttribute("nomEval", nomEval);
		// request.setAttribute("prenomEval", prenomEval);
		// request.setAttribute("admin", estAdmin);
		// request.setAttribute("loginEval", loginEval);
		// request.setAttribute("mdpEval", mdpEval);

		// compétences
		
		CompetenceDao daoCompetence = new CompetenceDao();
		
		String nomCompetence = request.getParameter("nomcompetence");
		
		String valeur = request.getParameter("valcurseur");
		String ssCategorie = request.getParameter("sscat");
		if (valeur != null || ssCategorie !=null) {
			int valeurCurseur = Integer.parseInt(valeur);
			int idSsCategorie = Integer.parseInt(ssCategorie);
			daoCompetence.addCompetence(nomCompetence, nomCompetence, valeurCurseur,idSsCategorie);
		} 


		// request.setAttribute("nomCompetence", nomCompetence);
		// request.setAttribute("valeurCurseur", valeurCurseur);
		// request.setAttribute("nomCatégorie", ssCategorie);

		this.getServletContext().getRequestDispatcher("/ajout.jsp").forward(request, response);
	}

}
