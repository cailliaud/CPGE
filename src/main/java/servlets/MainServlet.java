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
import entities.Etudiant;
import entities.Evaluateur;


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

		request.setAttribute("etudiants", etudiants);
		request.setAttribute("evaluateurs", evaluateurs);

		this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etudiant
		String nomE = request.getParameter("nometu");
		String prenomE = request.getParameter("prenometu");
		String loginE = request.getParameter("loginetu");
		String mdpE = request.getParameter("mdpetu");
		
		request.setAttribute("nomE", nomE);
		request.setAttribute("prenomE", prenomE);
		request.setAttribute("loginE", loginE);
		request.setAttribute("mdpE", mdpE);
		
		EtudiantDao daoEtudiant = new EtudiantDao();
		daoEtudiant.addStudent(nomE,prenomE,loginE, mdpE);
		
		//Evaluateur
		String nomEval = request.getParameter("nomeval");
		String prenomEval = request.getParameter("prenomeval");
		String estA = request.getParameter("estadmin");
		int estAdmin = Integer.parseInt(estA);
		String loginEval = request.getParameter("logineval");
		String mdpEval = request.getParameter("mdpeval");
		
		request.setAttribute("nomEval", nomEval);
		request.setAttribute("prenomEval", prenomEval);
		request.setAttribute("admin", estAdmin);
		request.setAttribute("loginEval", loginEval);
		request.setAttribute("mdpEval", mdpEval);
		
		EvaluateurDao daoEvaluateur = new EvaluateurDao();
		daoEvaluateur.addEvaluateur(nomEval, prenomEval, estAdmin, loginEval, mdpEval);
		
		this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
	}

}
