package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.EvaluationDao;
import entities.Evaluation;
import entities.Etudiant;
import bean.Utilisateur;

/**
 * Servlet implementation class ListEvalEtu
 */
@WebServlet( name="ListEvalEtu", urlPatterns = {"/ListEvalEtu"} )
public class ListEvalEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEvalEtu() {
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
		List<Evaluation> evaluations = dao.getEvalEtu(user.getId());
		
		
		
        request.setAttribute("evaluations", evaluations);
        
		this.getServletContext().getRequestDispatcher( "/listEvalEtu.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
