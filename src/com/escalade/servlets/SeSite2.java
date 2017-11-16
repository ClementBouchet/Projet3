package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SiteBdd;
import com.escalade.beans.Site;




@WebServlet("/SeSite2")
public class SeSite2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeSite2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("id");
		int iden = Integer.parseInt(ide);
		SiteBdd siteBdd = new SiteBdd();
		Site site = new Site();
		site.setNom(request.getParameter("nom"));
		site.setLieu(request.getParameter("lieu"));
		site.setDescription(request.getParameter("description"));
		siteBdd.modifierSite(iden, site);
		site = siteBdd.afficherSite(iden);
		request.setAttribute("secteurs",siteBdd.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("site",site);
		this.getServletContext().getRequestDispatcher("/WEB-INF/site2.jsp").forward(request, response);
	}

}
