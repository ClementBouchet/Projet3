package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.ComBdd;
import com.escalade.bdd.SecteurBdd;

import com.escalade.beans.Secteur;





@WebServlet("/SeSecteur")
public class SeSecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeSecteur() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("secteur");
		int iden = Integer.parseInt(ide);
		SecteurBdd secteurBdd = new SecteurBdd();
		ComBdd comBdd = new ComBdd();
		Secteur secteur = new Secteur();
		secteur = secteurBdd.afficherSecteur(iden);
		request.setAttribute("iden",iden);
		request.setAttribute("secteur",secteur);
		request.setAttribute("coms", comBdd.afficherCom(secteur.getNom(), "secteur"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/secteur.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
