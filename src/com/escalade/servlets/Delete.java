package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SecteurBdd;
import com.escalade.bdd.SiteBdd;
import com.escalade.bdd.VoieBdd;



@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		String id = request.getParameter("secteur");
		String ID = request.getParameter("voie");
		if (ide != null) {
		int iden = Integer.parseInt(ide);
		SiteBdd siteBdd = new SiteBdd();
		siteBdd.supprimerSite(iden);}
		else if(id != null){
			int iden = Integer.parseInt(id);
			SecteurBdd secteurBdd = new SecteurBdd();
			secteurBdd.supprimerSecteur(iden);
		}
		else if(ID != null){
			int iden = Integer.parseInt(ID);
			VoieBdd voieBdd = new VoieBdd();
			voieBdd.supprimerVoie(iden);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/deletepage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
