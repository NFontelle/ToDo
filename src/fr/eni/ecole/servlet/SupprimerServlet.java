package fr.eni.ecole.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.en.ecole.EJB.EJBTodo;
import fr.eni.ecole.bean.ToDo;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBTodo ejbToDo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		supprimer(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		supprimer(request, response);
	}

	protected void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		RequestDispatcher dispatcher;
		int idInt = Integer.parseInt(idString);
		ToDo todo = ejbToDo.selectionner(idInt);
		String pageTodo = "ListerServlet";
		ejbToDo.supprimer(todo);
		
		response.sendRedirect(pageTodo);

		
	}
	
	
}
