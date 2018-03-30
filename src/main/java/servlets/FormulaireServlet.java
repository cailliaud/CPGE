package servlets;

import java.io.IOException;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.*;
import entities.*;

import java.sql.Date;

/**
 * Servlet implementation class formulaireServlet
 */
@WebServlet(name = "FormulaireServlet", urlPatterns = { "/formulaireServlet" })
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormulaireServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompetenceDao daocomp = new CompetenceDao();
		List<Competence> competences = daocomp.getAllCompetence();

		request.setAttribute("competences", competences);

		EtudiantDao etudao = new EtudiantDao();
		List<Etudiant> etudiants = etudao.getAllStudents();
		request.setAttribute("etudiants", etudiants);
		
		EvaluateurDao evaluateurdao = new EvaluateurDao();
		List<Evaluateur> evaluateurs = evaluateurdao.getAllEvaluateur();
		request.setAttribute("evaluateurs",evaluateurs);

		this.getServletContext().getRequestDispatcher("/formulaire_evaluation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomSujet =  (request.getParameter("nomSujet").equals(""))?"Unknow Title" :request.getParameter("nomSujet") ;

		/** Curseur organisationIdées **/

		String curseurOrganisationId = request.getParameter("curseurOrganisationIdees");
		int curseurOrganisationIdees=(!curseurOrganisationId.equals("")) ?Integer.parseInt(curseurOrganisationId):0;

		/** Commentaire organisationIdées **/
		String commentaireOrganisationIdees = request.getParameter("commentaireOrganisationIdees");

		/** Points organisation idées **/
		String pointsOrganisationId = request.getParameter("pointsOrganisationIdees");
		int pointsOrganisationIdees = (!pointsOrganisationId.equals("")) ?Integer.parseInt(pointsOrganisationId):0;

		/** curseur connaissance scientifique **/

		String curseurConnaissancesS = request.getParameter("curseurConnaissancesScientifiques");
		int curseurConnaissancesScientifiques = (!curseurConnaissancesS.equals("")) ? Integer.parseInt(curseurConnaissancesS) : 0;

		/** commentaire connaissance scientifique **/
		String commentaireConnaissanceScientifiques = request.getParameter("commentaireConnaissancesScientifiques");
		request.setAttribute("commentaireConnaissancesScientifiques", commentaireConnaissanceScientifiques);

		/** points connaissances scientifiques **/
		String pointsConnaissancesS = request.getParameter("pointsConnaissancesScientifiques");
		int pointsConnaissancesScientifiques =  (!pointsConnaissancesS.equals("")) ? Integer.parseInt(pointsConnaissancesS):0;
		/** curseur entretien expose **/
		String curseurEntretienE = request.getParameter("curseurEntretienExpose");
		int curseurEntretienExpose = (!curseurEntretienE.equals("")) ? Integer.parseInt(curseurEntretienE):0;

		/** commentaire entretien expose **/
		String commentaireEntretienExpose = request.getParameter("commentaireEntretienExpose");
		request.setAttribute("commentaireEntretienExpose", commentaireEntretienExpose);

		/** points entretien expose **/

		String pointsEntretienE = request.getParameter("pointsEntretienExpose");
		int pointsEntretienExpose= (!pointsEntretienE.equals("")) ?Integer.parseInt(pointsEntretienE):0;

		/** curseur analyse de doc **/
		String curseurAnalyseD = request.getParameter("curseurAnalyseDoc");
		int curseurAnalyseDoc = (!curseurAnalyseD.equals(""))? Integer.parseInt(curseurAnalyseD): 0;


		/** commentaire analyse Doc **/
		String commentaireAnalyseDoc = request.getParameter("commentaireAnalyseDoc");
		

		/** points analyse doc **/
		String pointsAnalyseD = request.getParameter("pointsAnalyseDoc");
		int pointsAnalyseDoc = (!pointsAnalyseD.equals(""))? Integer.parseInt(pointsAnalyseD):0;
		

		/** curseur communication Orale **/
		String curseurComO = request.getParameter("curseurComOrale");
		int curseurComOrale=(!curseurComO.equals("")) ?Integer.parseInt(curseurComO):0;
		
		/** commentaire communication orale **/
		String commentaireComOrale = request.getParameter("commentaireComOrale");
		

		/** points communication orale **/
		String pointsComO = request.getParameter("pointsComOrale");
		int pointsComOrale= (!pointsComO.equals(""))?Integer.parseInt(pointsComO):0;
		/** curseur communication ecrite **/

		String curseurComE = request.getParameter("curseurComEcrite");
		int curseurComEcrite =  (!curseurComE.equals("")) ? Integer.parseInt(curseurComE):0;

		/** commentaire communication ecrite **/
		String commentaireComEcrite = request.getParameter("commentaireComEcrite");
		

		/** points communication ecrite **/
		String pointsComE = request.getParameter("pointsComEcrite");
		int pointsComEcrite=(!pointsComE.equals("")) ? Integer.parseInt(pointsComE):0;



		/** date de l'évaluation **/

		String dateEvalString = request.getParameter("dateEvaluation");

		java.sql.Date dateEvaluation =null;
		try {
			dateEvaluation = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateEvalString).getTime());
		} catch (ParseException e) {
			System.out.println(e);
		}

		/** identifiant de l'étudiant **/
		String idE = request.getParameter("idEtudiant");
		int idEtudiant = (!idE.equals("")) ? Integer.parseInt(idE):0;

		/** identifiant de l'évaluateur **/
		String idEv = request.getParameter("idEvaluateur");
		int idEvaluateur = (!idEv.equals("")) ? Integer.parseInt(idEv):0;
		
		/** commentaire global **/
		String commentaireGlobal = request.getParameter("commentaireGlobal");
		request.setAttribute("commentaireGlobal", commentaireGlobal);
		
		EvaluationDao daoEvaluation=new EvaluationDao();
		
		EtudiantDao daoEtudiant = new EtudiantDao();
		Etudiant etu = daoEtudiant.getEtudiantById(idEtudiant);
		
		EvaluateurDao daoEvaluateur = new EvaluateurDao();
		Evaluateur evaluateur = daoEvaluateur.getEvaluateurById(idEvaluateur);
		
		
		Evaluation evaluation = new Evaluation(commentaireAnalyseDoc, commentaireComEcrite, commentaireComOrale,
				commentaireConnaissanceScientifiques, commentaireEntretienExpose, commentaireGlobal, commentaireOrganisationIdees,
				curseurAnalyseDoc, curseurComEcrite, curseurComOrale, curseurConnaissancesScientifiques, curseurEntretienExpose, curseurOrganisationIdees,
				dateEvaluation,etu,evaluateur, nomSujet, pointsAnalyseDoc, pointsComEcrite, pointsComOrale, pointsConnaissancesScientifiques,
				pointsEntretienExpose, pointsOrganisationIdees);
		
		daoEvaluation.addEvaluation(evaluation);

	}

}
