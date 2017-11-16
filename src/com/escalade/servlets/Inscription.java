package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.beans.Utilisateur;
import com.escalade.forms.Form;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Form form = new Form();
		request.setAttribute("utilisateurs",form.recupererUtilisateurs());	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Form form = new Form();
		Utilisateur utilisateur = new Utilisateur();
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		utilisateur.setIdentifiant(request.getParameter("identifiant"));
		utilisateur.setPassword(password);		
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("password", password);
		request.setAttribute("password2", password2);
		if( !password.equals(password2)) {
			utilisateur.setErreur("Désolé "+utilisateur.getIdentifiant()+", la confirmation de votre mot de passe est incorrecte");
		}
		else {
			
			form.ajouterUtilisateur(utilisateur);
		}
		request.setAttribute("utilisateurs",form.recupererUtilisateurs());
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}
}
	
