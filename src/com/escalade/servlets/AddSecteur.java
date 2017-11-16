package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SecteurBdd;
import com.escalade.bdd.SiteBdd;
import com.escalade.beans.Secteur;



@WebServlet("/AddSecteur")
public class AddSecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSecteur() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecteurBdd secteurBdd = new SecteurBdd();
		request.setAttribute("secteurs",secteurBdd.recupererSecteur());
		SiteBdd siteBdd = new SiteBdd();
		request.setAttribute("sites",siteBdd.recupererSite());
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsecteur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Secteur secteur = new Secteur();
		secteur.setNom(request.getParameter("nom"));
		secteur.setRocher(request.getParameter("rocher"));
		secteur.setSite(request.getParameter("site"));
		
		SecteurBdd secteurBdd = new SecteurBdd();
		secteurBdd.ajouterSecteur(secteur);		
		request.setAttribute("secteurs",secteurBdd.recupererSecteur());
		
		SiteBdd siteBdd = new SiteBdd();
		request.setAttribute("sites",siteBdd.recupererSite());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsecteur.jsp").forward(request, response);
	}

}
