package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDao;
import entities.Etudiant;

/**
 * Servlet implementation class ModificationEtu
 */
@WebServlet(name = "ModificationServlet", urlPatterns = { "/modificationEtudiant" })
public class ModificationEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationEtu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EtudiantDao dao = new EtudiantDao();
		List<Etudiant> etudiants = dao.getAllStudentsModif();
		
		request.setAttribute("etudiants", etudiants);
		
		this.getServletContext().getRequestDispatcher( "/modifEtu.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		// Etudiant
		EtudiantDao daoEtudiant = new EtudiantDao();
		String idE = request.getParameter("idE");	
		int idEtudiant = Integer.parseInt(idE);
		String nomE = request.getParameter("nometu");
		String prenomE = request.getParameter("prenometu");
		String loginE = request.getParameter("loginetu");
		String mdpE = request.getParameter("mdpetu");
		
		daoEtudiant.modifStudent(idEtudiant, nomE, prenomE, loginE, mdpE);

		request.setAttribute("idE",idEtudiant);
		request.setAttribute("nomE", nomE);
		request.setAttribute("prenomE", prenomE);
		request.setAttribute("loginE", loginE);
		request.setAttribute("mdpE", mdpE);

		this.getServletContext().getRequestDispatcher( "/modifEtu.jsp" ).forward( request, response );
	}

}
