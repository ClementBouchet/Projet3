package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EscaladeResultat")
public class EscaladeResultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EscaladeResultat() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat = request.getParameter("recherche");
		request.setAttribute("resultat", resultat);
		this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
		
	}

}
