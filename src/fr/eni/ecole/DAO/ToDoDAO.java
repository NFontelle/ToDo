package fr.eni.ecole.DAO;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import fr.eni.ecole.bean.ToDo;

public class ToDoDAO {

	private DAOUtil daoUtil;

	public ToDoDAO() {
		this.daoUtil = new DAOUtil();
	}
	
	public ArrayList<ToDo> lister() {
		String req = "SELECT t FROM ToDo t";
		return (ArrayList<ToDo>) daoUtil.getEntityManager().createQuery(req, ToDo.class).getResultList();
	}

	public ToDo selectById(int id) {
		return daoUtil.getEntityManager().find(ToDo.class, id);
	}
	
	public void ajouter(ToDo todo) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(todo);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void supprimer(ToDo todo) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(todo);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}

	public void modifier(ToDo todo) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
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
