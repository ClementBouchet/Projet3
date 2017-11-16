package com.escalade.beans;

public class Site extends Infopost{

	protected String lieu;
	private int nbrVoies;
	private int nbrSecteurs;
	protected String rocher;
	private Voie voie;
	private String accès;
	protected String région;
	private String secteur;
	private int num;


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public int getNbrSecteurs() {
		return nbrSecteurs;
	}
	public void setNbrSecteurs(int nbrSecteurs) {
		this.nbrSecteurs = nbrSecteurs;
	}
	public String getAccès() {
		return accès;
	}
	public void setAccès(String accès) {
		this.accès = accès;
	}
	public String getRégion() {
		return région;
	}
	public void setRégion(String région) {
		this.région = région;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getNbrVoies() {
		return nbrVoies;
	}
	public void setNbrVoies(int nbrVoies) {
		this.nbrVoies = nbrVoies;
	}
	public String getRocher() {
		return rocher;
	}
	public void setRocher(String rocher) {
		this.rocher = rocher;
	}
	public Voie getVoie() {
		return voie;
	}
	public void setVoie(Voie voie) {
		this.voie = voie;
	}
}
