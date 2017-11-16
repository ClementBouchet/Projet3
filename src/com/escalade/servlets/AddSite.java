package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SiteBdd;
import com.escalade.beans.Site;


@WebServlet("/AddSite")
public class AddSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SiteBdd siteBdd = new SiteBdd();
		request.setAttribute("sites",siteBdd.recupererSite());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Site site = new Site();
		site.setNom(request.getParameter("nom"));
		site.setLieu(request.getParameter("lieu"));
		site.setDescription(request.getParameter("description"));
		
		SiteBdd siteBdd = new SiteBdd();
		siteBdd.ajouterSite(site);
		request.setAttribute("sites",siteBdd.recupererSite());
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsite.jsp").forward(request, response);
	}

}
