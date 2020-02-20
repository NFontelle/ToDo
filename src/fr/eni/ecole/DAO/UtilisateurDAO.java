package fr.eni.ecole.DAO;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.eni.ecole.bean.Utilisateurs;

public class UtilisateurDAO {
	
	private DAOUtil daoUtil;

	public UtilisateurDAO() {
		this.daoUtil = new DAOUtil();
	}
	
	public ArrayList<Utilisateurs> Lister() {
		String req = "SELECT Objet(u) From utilisateur u";
		return (ArrayList<Utilisateurs>) daoUtil.getEntityManager().createQuery(req, Utilisateurs.class).getResultList();
	}

	public void ajouter(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(utilisateur);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void supprimer(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(utilisateur);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}

	public void modifier(Utilisateurs utilisateur) throws SQLException {
		EntityManager em = daoUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(utilisateur);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
	}	
	public Utilisateurs rechercher(String identifiant, String motDePasse) {
		String requete = "select u from Utilisateur u where u.identifiant like :identifiant and u.motDePasse like :motDePasse";
		TypedQuery<Utilisateurs> tq = daoUtil.getEntityManager().createQuery(requete, Utilisateurs.class);	
		tq.setParameter("identifiant",identifiant);
		tq.setParameter("motDePasse", motDePasse);
		Utilisateurs u;
		try {
			u = tq.getSingleResult();
			return u;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
