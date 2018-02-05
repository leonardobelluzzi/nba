package com.usp.belluzzi.nbaweb.cluster.model;

public class Team {
	
	public Team (String season, String name){
		this.setName(name);
		this.setSeason(season);
	}
	
	private String name;
	
	private String season;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return this.getSeason() + "-" + this.getName();
	}
	
	

}
