package fr.eni.ecole.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.en.ecole.EJB.EJBConnection;

@WebServlet({ "/ConnectionServlet", "/Connection" })
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EJBConnection ejbConnection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		connection(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		connection(request, response);
	}

	protected void connection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd;
		String pageTodo = "/ListerServlet";
		String identifiant = request.getParameter("utilisateur");
		String motDePasse = request.getParameter("motDePasse");

		boolean verif = ejbConnection.verifBase(identifiant, motDePasse);

		if (verif == true) {
			
			rd = request.getRequestDispatcher(pageTodo);
			rd.forward(request, response);
	
		}
		if (verif == false) {

			rd = request.getRequestDispatcher(request.getContextPath());
			rd.forward(request, response);
		}
	}
}
