package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escalade.bdd.ComBdd;
import com.escalade.beans.Commentaire;
import com.escalade.beans.Utilisateur;


@WebServlet("/AddCom")
public class AddCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddCom() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ComBdd comBdd = new ComBdd();
		Commentaire com = new Commentaire();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		if (utilisateur != null) {
			com.setAuteur(utilisateur.getIdentifiant());
		
		
			com.setDescription(request.getParameter("description"));
			com.setTypeObjet(request.getParameter("type_objet"));
			com.setNomObjet(request.getParameter("nom_objet"));
			request.setAttribute("com", com);
		
			comBdd.ajouterCom(com);
		
			if (request.getParameter("type_objet").equals("site")) {
				response.sendRedirect(request.getContextPath() + "/SeSite?site=" + request.getParameter("id_objet"));
			}
			else if (request.getParameter("type_objet").equals("secteur")) {
				response.sendRedirect(request.getContextPath() + "/SeSecteur?secteur=" + request.getParameter("id_objet"));
			}
			else if (request.getParameter("type_objet").equals("voie")) {
				response.sendRedirect(request.getContextPath() + "/SeVoie?voie=" + request.getParameter("id_objet"));
			}
		
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/acces_public.jsp").forward(request, response);
		}
	}

}
