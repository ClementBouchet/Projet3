package com.escalade.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.escalade.beans.Utilisateur;

public class Form {
	private String result;
	private Connection connexion;
	public String getResultat() {
		return result;
	}

	public void setResultat(String resultat) {
		this.result = resultat;
	}

	public void traiterResultat( HttpServletRequest request) {
		
		result = request.getParameter("recherche");
	}

    
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT identifiant, password FROM Utilisateur;");

            // Récupération des données
            while (resultat.next()) {
                String identifiant = resultat.getString("identifiant");
                String password = resultat.getString("password");
                
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdentifiant(identifiant);
                utilisateur.setPassword(password);
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "dolphin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Utilisateur(identifiant, password) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getIdentifiant());
            preparedStatement.setString(2, utilisateur.getPassword());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

