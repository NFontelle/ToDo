package fr.eni.ecole.DAO;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import fr.eni.ecole.bean.ToDo;

public class ToDoDAO {

	public static ArrayList<ToDo> Lister() {
		String req = "SELECT Objet(t) From ToDo t";
		return (ArrayList<ToDo>) DAOUtil.getEntityManager().createQuery(req, ToDo.class).getResultList();
	}

	public static void ajouter(ToDo todo) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(todo);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public static void supprimer(ToDo todo) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(todo);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}

	public static void modifier(ToDo todo) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(todo);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}

}
