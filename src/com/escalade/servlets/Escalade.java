package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.beans.Secteur;
import com.escalade.beans.Site;
import com.escalade.beans.Voie;


@WebServlet("/Escalade")
public class Escalade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Escalade() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Site site = new Site();
		site.setNom("La pente raide");
		site.setAuteur("Clem");
		site.setDate("2 juillet 2017");
		site.setDescription("Ce site est simplement le plus difficile que j'ai jamais fait. "
				+ "J'ai frolé la mort plusieurs fois");

		request.setAttribute("sites", site);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");	
		request.setAttribute("nom", nom);
		this.getServletContext().getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
	}

}
