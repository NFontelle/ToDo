package fr.en.ecole.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import fr.eni.ecole.DAO.UtilisateurDAO;
import fr.eni.ecole.bean.Utilisateurs;

@Stateless
@LocalBean
public class EJBConnection {

	public boolean verifBase(String identifiant, String motDePasse) {

		Utilisateurs utilisateur = new UtilisateurDAO().rechercher(identifiant, motDePasse);
		if (utilisateur == null) {
			return false;
		}
		return true;
	}

}
