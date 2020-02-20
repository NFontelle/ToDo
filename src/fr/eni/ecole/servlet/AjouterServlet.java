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
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
@EJB
private EJBTodo ejbToDo;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajouter(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ajouter(request, response);
	}

	protected void ajouter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String contenu = request.getParameter("contenu");

		String pageTodo = "ListerServlet";
		RequestDispatcher rd;

		ToDo todo = new ToDo();
		todo.setContenu(contenu);
		ejbToDo.ajouter(todo);
		
		response.sendRedirect(pageTodo);
	}
	
}
