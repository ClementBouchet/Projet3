package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EscaladeAccueil")
public class EscaladeAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EscaladeAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String utilisateur = request.getParameter("utilisateur");
		request.setAttribute("utilisateur", utilisateur);
		HttpSession session = request.getSession();
		session.getAttribute("utilisateur");
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
