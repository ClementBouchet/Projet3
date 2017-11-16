package com.escalade.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.escalade.beans.Secteur;



public class SecteurBdd {
	private Connection connexion;
	private String result;
	private String critere;
	private String comSQL;
	
public List<Secteur> rechercheSecteur(HttpServletRequest request) {
		//Affiche la liste des secteurs correspondants à la recherche
		List<Secteur> secteurs = new ArrayList<Secteur>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
		if (critere != "")
			comSQL = "SELECT * FROM Secteur INNER JOIN Site ON Site.id = Secteur.site_id WHERE Secteur.nom LIKE '%"+result+"%' AND Site.lieu LIKE '%"+critere+"%';" ;
		else
			comSQL = "SELECT * FROM Secteur WHERE nom LIKE '%"+result+"%' OR site LIKE '%"+result+"%';";
		try {
			
			statement = connexion.prepareStatement(comSQL);
			//statement.setString(1, result);
			//statement.setString(2, result);
			resultat = statement.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				int id = resultat.getInt("id");
				Secteur secteur = new Secteur();
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setNum(id);
				secteurs.add(secteur);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secteurs;
	}
	
 	public Secteur afficherSecteur(int id) {
 		//Affiche les informations dans la page de détail
 		Secteur secteur = new Secteur();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		String comSQL = "SELECT id, nom, site, rocher FROM Secteur WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setInt(1, id);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				String rocher = resultat.getString("rocher");
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setRocher(rocher);
				secteur.setNum(id);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secteur;
	}
	
	public void supprimerSecteur(int id) {
		//Pour supprimer un secteur de la base de données
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Secteur WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Secteur> recupererSecteur(){
		//Affiche tous les secteurs de la base de données dans la page pour ajouter des secteurs
		List<Secteur> secteurs = new ArrayList<Secteur>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, site FROM Secteur;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				int id = resultat.getInt("id");
				
				Secteur secteur = new Secteur();
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setNum(id);
				
				secteurs.add(secteur);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secteurs;
		
	}
	
	public void ajouterSecteur(Secteur secteur) {
		//Permet d'ajouter un nouveau secteur dans la base de données
		loadDatabase();
		String comSQL = "INSERT INTO Secteur(nom,site,rocher,site_id) "
				+ "SELECT ?,?,?, id FROM Site WHERE nom = ?;";
		try {
			
			PreparedStatement preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setString(1, secteur.getNom());
			preparedStatement.setString(2, secteur.getSite());
			preparedStatement.setString(3, secteur.getRocher());
			preparedStatement.setString(4, secteur.getSite());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifierSecteur(int id, Secteur secteur) {
		
		PreparedStatement statement = null;
		
		loadDatabase();
		String comSQL = "UPDATE Secteur SET nom=?, site =?, rocher=? WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, secteur.getNom());
			statement.setString(2, secteur.getSite());
			statement.setString(3, secteur.getRocher());
			statement.setInt(4, id);
			statement.executeUpdate();
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
