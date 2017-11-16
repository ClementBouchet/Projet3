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




@WebServlet("/ModifSecteur")
public class ModifSecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifSecteur() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("secteur");
		int iden = Integer.parseInt(ide);
		SecteurBdd secteurBdd = new SecteurBdd();
		Secteur secteur = new Secteur();
		secteur = secteurBdd.afficherSecteur(iden);
		SiteBdd siteBdd = new SiteBdd();
		request.setAttribute("sites",siteBdd.recupererSite());
		//request.setAttribute("secteurs",siteBdd.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("secteur",secteur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/modif_secteur.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
