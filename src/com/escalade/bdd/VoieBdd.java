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

import com.escalade.beans.Voie;



public class VoieBdd {
	private Connection connexion;
	private String result;
	private String critere;
	private String comSQL;
	
public List<Voie> rechercheVoie(HttpServletRequest request) {
		//Affiche la liste des secteurs correspondants à la recherche
		List<Voie> voies = new ArrayList<Voie>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
		if (critere != "")
			comSQL = "SELECT * FROM Voie WHERE nom LIKE '%"+result+"%' AND lieu LIKE '%"+critere+"%';";
		else
			comSQL = "SELECT * FROM Voie WHERE nom LIKE '%"+result+"%' OR secteur LIKE '%"+result+"%' OR site LIKE '%"+result+"%';";
		try {
			
			statement = connexion.prepareStatement(comSQL);
			//statement.setString(1, result);
			//statement.setString(2, result);
			resultat = statement.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String secteur = resultat.getString("secteur");
				long longueur = resultat.getLong("longueur");
				int id = resultat.getInt("id");
				String site = resultat.getString("site");
				String cotation = resultat.getString("cotation");
				Voie voie = new Voie();
				voie.setNom(nom);
				voie.setSecteur(secteur);
				voie.setLongueur(longueur);
				voie.setNum(id);
				voie.setCotation(cotation);
				voie.setSite(site);
				
				voies.add(voie);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voies;
	}
	
 	public Voie afficherVoie(int id) {
 		//Affiche les informations dans la page de détail
 		Voie voie = new Voie();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		String comSQL = "SELECT * FROM Voie WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setInt(1, id);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String secteur = resultat.getString("secteur");
				long longueur = resultat.getLong("longueur");
				String site = resultat.getString("site");
				String cotation = resultat.getString("cotation");
				voie.setNom(nom);
				voie.setSecteur(secteur);
				voie.setLongueur(longueur);
				voie.setNum(id);
				voie.setCotation(cotation);
				voie.setSite(site);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voie;
	}
	
	public void supprimerVoie(int id) {
		//Pour supprimer un secteur de la base de données
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Voie WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Voie> recupererVoie(){
		//Affiche toutes les voies de la base de données dans la page pour ajouter des voies
		List<Voie> voies = new ArrayList<Voie>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, longueur, secteur, cotation FROM Voie;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String secteur = resultat.getString("secteur");
				long longueur = resultat.getLong("longueur");
				int id = resultat.getInt("id");
				String cotation = resultat.getString("cotation");
				
				Voie voie = new Voie();
				
				voie.setNom(nom);
				voie.setSecteur(secteur);
				voie.setLongueur(longueur);
				voie.setNum(id);
				voie.setCotation(cotation);
				
				voies.add(voie);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voies;
		
	}
	
	public void ajouterVoie(Voie voie) {
		//Permet d'ajouter un nouveau secteur dans la base de données
		loadDatabase();
		String comSQL = "INSERT INTO Voie(nom,secteur,longueur,cotation,secteur_id) "
				+ "SELECT ?,?,?,?, id FROM Secteur WHERE nom = ?;";
		try {
			
			PreparedStatement preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setString(1, voie.getNom());
			preparedStatement.setString(2, voie.getSecteur());
			preparedStatement.setLong(3, voie.getLongueur());
			preparedStatement.setString(4, voie.getCotation());
			preparedStatement.setString(5, voie.getSecteur());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifierVoie(int id, Voie voie) {
		
		PreparedStatement statement = null;
		
		loadDatabase();
		String comSQL = "UPDATE Voie SET nom=?, secteur =?, longueur=?, cotation=? WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, voie.getNom());
			statement.setString(2, voie.getSecteur());
			statement.setLong(3, voie.getLongueur());
			statement.setString(4, voie.getCotation());
			statement.setInt(5, id);
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
