package com.escalade.beans;


import java.util.List;


public class Recherche {
	
	List<Integer> nbrPages;
	List<Site> sites;
	
	public List<Integer> getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(List<Integer> nbrPages) {
		this.nbrPages = nbrPages;
	}
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

}
