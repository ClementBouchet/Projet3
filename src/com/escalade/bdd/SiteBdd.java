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
import com.escalade.beans.Site;

public class SiteBdd {
	private Connection connexion;
	private String result;
	private String critere;
	private String comSQL;
	public List<Site> rechercheSite(HttpServletRequest request) {
		
		List<Site> sites = new ArrayList<Site>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
				
		try {
			
			if (critere != "") { 
				comSQL = "SELECT * FROM Site WHERE nom LIKE '%"+result+"%' AND lieu LIKE '%"+critere+"%';";
				statement = connexion.prepareStatement(comSQL);}
			
			else {
				comSQL = "SELECT * FROM Site WHERE nom LIKE '%"+result+"%' OR lieu LIKE '%"+result+"%';";
				statement = connexion.prepareStatement(comSQL);}
			
			resultat = statement.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				int id = resultat.getInt("id");
				Site site = new Site();
				site.setNom(nom);
				site.setLieu(lieu);
				site.setNum(id);
				
				sites.add(site);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sites;
	}
	
 	public Site afficherSite(int id) {
		Site site = new Site();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		String comSQL = "SELECT id, nom, lieu, description FROM Site WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setInt(1, id);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				String description = resultat.getString("description");
				site.setNom(nom);
				site.setLieu(lieu);
				site.setDescription(description);
				site.setNum(id);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return site;
	}
 	
 	public void modifierSite(int id, Site site) {
		
		PreparedStatement statement = null;
		
		loadDatabase();
		String comSQL = "UPDATE Site SET nom=?, lieu =?, description=? WHERE id=?;";
		
		try {
			
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, site.getNom());
			statement.setString(2, site.getLieu());
			statement.setString(3, site.getDescription());
			statement.setInt(4, id);
			statement.executeUpdate();
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
 	public void supprimerSite(int id) {
	
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Site WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Site> recupererSite(){
		
		List<Site> sites = new ArrayList<Site>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, lieu FROM Site;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				int id = resultat.getInt("id");
				
				Site site = new Site();
				site.setNom(nom);
				site.setLieu(lieu);
				site.setNum(id);
				
				sites.add(site);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sites;
		
	}
	
	public void ajouterSite(Site site) {
		
		loadDatabase();
		String comSQL = "INSERT INTO Site(nom,lieu,description) VALUES(?,?,?);";
		try {
			
			PreparedStatement preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setString(1, site.getNom());
			preparedStatement.setString(2, site.getLieu());
			preparedStatement.setString(3, site.getDescription());
			preparedStatement.executeUpdate();
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

	public List<Secteur> recupererSecteur(int ide){
		//Affiche tous les secteurs du site
		List<Secteur> secteurs = new ArrayList<Secteur>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, site FROM Secteur WHERE site_id = "+ide+";");
			
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
	
}