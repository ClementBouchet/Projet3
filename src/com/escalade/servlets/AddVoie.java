package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SecteurBdd;
import com.escalade.bdd.VoieBdd;
import com.escalade.beans.Voie;



@WebServlet("/AddVoie")
public class AddVoie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddVoie() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoieBdd voieBdd = new VoieBdd();
		request.setAttribute("voies",voieBdd.recupererVoie());
		SecteurBdd secteurBdd = new SecteurBdd();
		request.setAttribute("secteurs",secteurBdd.recupererSecteur());
		this.getServletContext().getRequestDispatcher("/WEB-INF/addvoie.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Voie voie = new Voie();
		voie.setNom(request.getParameter("nom"));
		voie.setSecteur(request.getParameter("secteur"));
		voie.setLongueur(Long.parseLong(request.getParameter("longueur")));
		voie.setCotation(request.getParameter("cotation"));
		
		
		VoieBdd voieBdd = new VoieBdd();
		voieBdd.ajouterVoie(voie);		
		request.setAttribute("voies",voieBdd.recupererVoie());
		
		SecteurBdd secteurBdd = new SecteurBdd();
		request.setAttribute("secteurs",secteurBdd.recupererSecteur());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addvoie.jsp").forward(request, response);
	}

}
