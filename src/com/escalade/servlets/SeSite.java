package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.ComBdd;
import com.escalade.bdd.SiteBdd;
import com.escalade.beans.Commentaire;
import com.escalade.beans.Site;




@WebServlet("/SeSite")
public class SeSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeSite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		int iden = Integer.parseInt(ide);
		SiteBdd siteBdd = new SiteBdd();
		ComBdd comBdd = new ComBdd();
		Site site = new Site();
		site = siteBdd.afficherSite(iden);
		request.setAttribute("secteurs",siteBdd.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("site",site);
		request.setAttribute("coms", comBdd.afficherCom(site.getNom(), "site"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/site.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
