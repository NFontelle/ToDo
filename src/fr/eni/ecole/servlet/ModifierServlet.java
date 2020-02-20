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
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/ModifierServlet")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EJBTodo ejbToDo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String modifOk = request.getParameter("modifOk");
		String texte = request.getParameter("modif");
		String enregistre = request.getParameter("enregistre");
		String annule = request.getParameter("annule");
		String idString = request.getParameter("id");
		RequestDispatcher dispatcher;

		int idInt = Integer.parseInt(idString);
		ToDo todo = ejbToDo.selectionner(idInt);

		if (enregistre != null) {
			if (modifOk != null) {
				todo.setContenu(texte);
				ejbToDo.modifier(todo);
				dispatcher = request.getRequestDispatcher("liste.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("modification.jsp");
				dispatcher.forward(request, response);
			}
		} 
		if (annule != null){

			dispatcher = request.getRequestDispatcher("liste.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
