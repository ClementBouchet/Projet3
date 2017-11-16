package com.escalade.servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.beans.Utilisateur;
import com.escalade.beans.Validation;
import com.escalade.forms.ConnexionForm;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdentifiant(request.getParameter("identifiant"));
		utilisateur.setPassword(request.getParameter("password"));
		
		ConnexionForm form = new ConnexionForm();
		Validation validation = new Validation();
		validation = form.verifyConnexion(utilisateur);
		request.setAttribute("validation", validation);
		request.setAttribute("utilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

}
