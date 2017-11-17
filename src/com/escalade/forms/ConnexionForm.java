package com.escalade.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.escalade.beans.Utilisateur;
import com.escalade.beans.Validation;



public class ConnexionForm {
	
	private Connection connexion;


	public Validation verifyConnexion(Utilisateur utilisateur) {
		
		Validation validation = new Validation();
		
		loadDatabase();
		String validId = null;
		String valid = null;
		String identifiantTry = utilisateur.getIdentifiant();
		String passwordTry = utilisateur.getPassword();
		String password = null;
		String identifiant = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sqlRequest = "SELECT identifiant, password FROM Utilisateur WHERE identifiant = ?;";
			statement = connexion.prepareStatement(sqlRequest);
			statement.setString(1, identifiantTry);
			result = statement.executeQuery();	
			if (result.first()) {				
				password = result.getString("password");
				identifiant = result.getString("identifiant");	
				if (identifiant.equals(identifiantTry)) {
					validId = "ok";
				
					if (password.equals(passwordTry)) {
						valid = "ok";
					}
					else {
						valid = "notok";
					}
				}
				else validId = "notok";
			}
			else {
				validId = "notok";			
			}
			validation.setIdent(validId);
			validation.setPass(valid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validation;
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
