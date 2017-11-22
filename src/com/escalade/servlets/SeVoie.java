package com.escalade.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.bdd.VoieBdd;
import com.escalade.beans.Voie;




@WebServlet("/SeVoie")
public class SeVoie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeVoie() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("voie");
		int iden = Integer.parseInt(ide);
		VoieBdd voieBdd = new VoieBdd();
		Voie voie = new Voie();
		voie = voieBdd.afficherVoie(iden);
		request.setAttribute("iden",iden);
		request.setAttribute("voie",voie);
		request.setAttribute("nom", voie.getNom());
		this.getServletContext().getRequestDispatcher("/WEB-INF/voie.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
