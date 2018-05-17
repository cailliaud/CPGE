package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EvaluateurDao;
import entities.Evaluateur;

/**
 * Servlet implementation class ListEvaluateurs
 */

@WebServlet( name="ListEvaluateurs", urlPatterns = {"/ListEvaluateurs"} )
public class ListEvaluateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEvaluateurs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EvaluateurDao dao = new EvaluateurDao();
		List<Evaluateur> evaluateur = dao.getAllEvaluateurModif(); 
        request.setAttribute("evaluateur", evaluateur);
		this.getServletContext().getRequestDispatcher( "/consultEvaluateur.jsp" ).forward( request, response );	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
