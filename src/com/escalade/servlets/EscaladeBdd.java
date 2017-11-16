package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.escalade.bdd.SecteurBdd;
import com.escalade.bdd.SiteBdd;
import com.escalade.forms.Form;

@WebServlet("/EscaladeBdd")
public class EscaladeBdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EscaladeBdd() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("recherche");
		String critere1 = request.getParameter("critere1");
		SiteBdd siteBdd = new SiteBdd();
		SecteurBdd secteurBdd = new SecteurBdd();
		request.setAttribute("secteurs",secteurBdd.rechercheSecteur(request));
		request.setAttribute("sites",siteBdd.rechercheSite(request));
		request.setAttribute("mot", search);
		request.setAttribute("mot2", critere1);
		this.getServletContext().getRequestDispatcher("/WEB-INF/affichagebdd.jsp").forward(request, response);
	
	}

}
