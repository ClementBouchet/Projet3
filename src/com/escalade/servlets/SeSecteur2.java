package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SecteurBdd;

import com.escalade.beans.Secteur;





@WebServlet("/SeSecteur2")
public class SeSecteur2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeSecteur2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("id");
		int iden = Integer.parseInt(ide);
		SecteurBdd secteurBdd = new SecteurBdd();
		Secteur secteur = new Secteur();
		secteur.setNom(request.getParameter("nom"));
		secteur.setLieu(request.getParameter("lieu"));
		secteur.setDescription(request.getParameter("description"));
		secteurBdd.modifierSecteur(iden, secteur);
		secteur = secteurBdd.afficherSecteur(iden);
		//request.setAttribute("secteurs",secteurBdd.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("secteur",secteur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/secteur2.jsp").forward(request, response);
	}

}
