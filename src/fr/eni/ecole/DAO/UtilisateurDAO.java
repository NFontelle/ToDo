package fr.eni.ecole.DAO;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



import fr.eni.ecole.bean.Utilisateurs;

public class UtilisateurDAO {
	public static ArrayList<Utilisateurs> Lister() {
		String req = "SELECT Objet(u) From utilisateur u";
		return (ArrayList<Utilisateurs>) DAOUtil.getEntityManager().createQuery(req, Utilisateurs.class).getResultList();
	}

	public static void ajouter(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(utilisateur);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public static void supprimer(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(utilisateur);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}

	public static void modifier(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(utilisateur);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}	
}
