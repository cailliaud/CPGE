package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utilisateur;
import dao.EvaluationDao;
import entities.Etudiant;
import entities.Evaluation;


/**
 * Servlet implementation class ListEvalEvaluateur
 */
@WebServlet( name="ListEvalEvaluateur", urlPatterns = {"/ListEvalEvaluateur"} )
public class ListEvalEvaluateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEvalEvaluateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EvaluationDao dao = new EvaluationDao();
		HttpSession session = request.getSession(); 
	    Utilisateur user = (Utilisateur)session.getAttribute("sessionUtilisateur");
		List<Evaluation> evaluations = dao.getEvalEvaluateur(user.getId());
		
		//List<Etudiant> etudiants= new ArrayList<Etudiant>();
		//Etudiant etu = new Etudiant(); 
		//for(int i=0; i<evaluations.size(); i++){
		//	etu=evaluations.get(i).getEtudiant();
		//	etudiants.add(etu);
		//}
		
		
		
        request.setAttribute("evaluations", evaluations);
		
		this.getServletContext().getRequestDispatcher( "/listEvalEvaluateur.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
