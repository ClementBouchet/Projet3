package com.escalade.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.escalade.beans.Commentaire;

public class ComBdd {

	private Connection connexion;
	private String comSQL;
	
	public void ajouterCom(Commentaire commentaire){
		
		loadDatabase();
		PreparedStatement prepStatement = null;
		
		comSQL = "INSERT INTO Commentaire (auteur, description, type_objet, nom_objet, id_objet)"
				+ "SELECT ?,?,?,?, id FROM "+commentaire.getTypeObjet()+" WHERE nom = ?";
		
		try {
			prepStatement = connexion.prepareStatement(comSQL);
			prepStatement.setString(1, commentaire.getAuteur());
			prepStatement.setString(2, commentaire.getDescription());
			prepStatement.setString(3, commentaire.getTypeObjet());
			prepStatement.setString(4, commentaire.getNomObjet());
			
			prepStatement.setString(5, commentaire.getNomObjet());
			
			prepStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
                if (prepStatement != null)
                    prepStatement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
		
		
	}
	
	public List<Commentaire> afficherCom(String nomSite, String typeObjet) {
		List<Commentaire> coms= new ArrayList<Commentaire>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		String comSQL = "SELECT id, auteur, description FROM Commentaire WHERE type_objet=? AND nom_objet=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, typeObjet);
			statement.setString(2, nomSite);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String auteur = resultat.getString("auteur");
				String description = resultat.getString("description");
				int id = resultat.getInt("id");
				Commentaire com = new Commentaire();
				com.setAuteur(auteur);
				com.setDescription(description);
				com.setIdObjet(id);
				
				coms.add(com);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		
		return coms;
	}
	
	private void loadDatabase() {
		//Chargement du Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "dolphin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
