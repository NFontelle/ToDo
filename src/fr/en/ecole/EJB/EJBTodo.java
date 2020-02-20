package fr.en.ecole.EJB;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.eni.ecole.DAO.ToDoDAO;
import fr.eni.ecole.bean.ToDo;

@Stateless
@LocalBean
public class EJBTodo {

	public void ajouter(ToDo todo) {
		try {
			new ToDoDAO().ajouter(todo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void supprimer(ToDo todo) {
		try {
			new ToDoDAO().supprimer(todo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifier(ToDo todo) {
		try {
			new ToDoDAO().modifier(todo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ToDo> lister(){
		return new ToDoDAO().lister();
	}
	
	public ToDo selectionner(int id) {
		return new ToDoDAO().selectById(id);		
	}
	
	
	
}
