package com.escalade.beans;

public class Site extends Infopost{

	protected String lieu;
	private int nbrVoies;
	private int nbrSecteurs;
	protected String rocher;
	private Voie voie;
	private String acc�s;
	protected String r�gion;
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
	public String getAcc�s() {
		return acc�s;
	}
	public void setAcc�s(String acc�s) {
		this.acc�s = acc�s;
	}
	public String getR�gion() {
		return r�gion;
	}
	public void setR�gion(String r�gion) {
		this.r�gion = r�gion;
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
