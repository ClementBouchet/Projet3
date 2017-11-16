package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.SiteBdd;
import com.escalade.beans.Site;




@WebServlet("/ModifSite")
public class ModifSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifSite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		int iden = Integer.parseInt(ide);
		SiteBdd siteBdd = new SiteBdd();
		Site site = new Site();
		site = siteBdd.afficherSite(iden);
		//request.setAttribute("secteurs",siteBdd.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("site",site);
		this.getServletContext().getRequestDispatcher("/WEB-INF/modif_site.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
