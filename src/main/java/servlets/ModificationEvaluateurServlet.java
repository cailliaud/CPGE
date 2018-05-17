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
 * Servlet implementation class ModificationEtu
 */
@WebServlet(name = "ModificationEvaluateurServlet", urlPatterns = { "/modificationEvaluateur" })
public class ModificationEvaluateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationEvaluateurServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EvaluateurDao dao = new EvaluateurDao();
		List<Evaluateur> evaluateurs = dao.getAllEvaluateurModif();
		
		request.setAttribute("evaluateurs", evaluateurs);
		
		this.getServletContext().getRequestDispatcher( "/modifEvaluateur.jsp" ).forward( request, response );
		//this.getServletContext().getRequestDispatcher( "/test.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Evaluateur
		EvaluateurDao daoEvaluateur = new EvaluateurDao();
		String idE = request.getParameter("idEval");
		int idEval = Integer.parseInt(idE);
		String nomEval = request.getParameter("nomeval");
		String prenomEval = request.getParameter("prenomeval");
		
		String loginEval = request.getParameter("logineval");
		String mdpEval = request.getParameter("mdpeval");
		
		String Adm = request.getParameter("estadmin");
		int estAdmin = Integer.parseInt(Adm);
		daoEvaluateur.modifEvaluateur(idEval, nomEval, prenomEval, estAdmin, loginEval, mdpEval);

		request.setAttribute("idEval", idEval);
		this.getServletContext().getRequestDispatcher( "/modifEvaluateur.jsp" ).forward( request, response );
		//this.getServletContext().getRequestDispatcher( "/test.jsp" ).forward( request, response );
	}

}
