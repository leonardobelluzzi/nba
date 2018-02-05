package com.usp.belluzzi.nbaweb.cluster.model;

public class StatsSeason {


	public StatsSeason (Team team, int threePoint, int threePointAttempt, int twoPoint, int twoPointAttempt, 
			int freeThrow, int freeThrowAttempt, int offensiveRebound, int defensiveRebound, int assist,int steal, 
			int block, int turnover, int personalFoul, int point){

		this.setTeam(team);
		this.setAssist(assist);
		this.setBlock(block);
		this.setDefensiveRebound(defensiveRebound);
		this.setFreeThrow(freeThrow);
		this.setFreeThrowAttempt(freeThrowAttempt);
		this.setOffensiveRebound(offensiveRebound);
		this.setPersonalFoul(personalFoul);
		this.setPoint(point);
		this.setSteal(steal);
		this.setThreePoint(threePoint);
		this.setThreePointAttempt(threePointAttempt);
		this.setTurnover(turnover);
		this.setTwoPoint(twoPoint);
		this.setTwoPointAttempt(twoPointAttempt);
		this.setGruop(null);
	}
	

	public StatsSeason (String st, String tm, int threePoint, int threePointAttempt, int twoPoint, int twoPointAttempt, 
			int freeThrow, int freeThrowAttempt, int offensiveRebound, int defensiveRebound, int assist,int steal, 
			int block, int turnover, int personalFoul, int point, String a){

		Team team = new Team(st, tm);
		
		this.setTeam(team);
		this.setAssist(assist);
		this.setBlock(block);
		this.setDefensiveRebound(defensiveRebound);
		this.setFreeThrow(freeThrow);
		this.setFreeThrowAttempt(freeThrowAttempt);
		this.setOffensiveRebound(offensiveRebound);
		this.setPersonalFoul(personalFoul);
		this.setPoint(point);
		this.setSteal(steal);
		this.setThreePoint(threePoint);
		this.setThreePointAttempt(threePointAttempt);
		this.setTurnover(turnover);
		this.setTwoPoint(twoPoint);
		this.setTwoPointAttempt(twoPointAttempt);
		this.setGruop(null);
	}


	public StatsSeason() {
		// TODO Auto-generated constructor stub
	}


	private Team team;

	private int threePoint;
	
	private int threePointAttempt;
	
	private int twoPoint;
	
	private int twoPointAttempt;
	
	private int freeThrow;
	
	private int freeThrowAttempt;
	
	private int offensiveRebound;
	
	private int defensiveRebound;
	
	private int assist;
	
	private int steal;
	
	private int block;
	
	private int turnover;
	
	private int personalFoul;
	
	private int point;
	
	private Team gruop;


	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getThreePoint() {
		return threePoint;
	}

	public void setThreePoint(int threePoint) {
		this.threePoint = threePoint;
	}

	public int getThreePointAttempt() {
		return threePointAttempt;
	}

	public void setThreePointAttempt(int threePointAttempt) {
		this.threePointAttempt = threePointAttempt;
	}

	public int getTwoPoint() {
		return twoPoint;
	}

	public void setTwoPoint(int twoPoint) {
		this.twoPoint = twoPoint;
	}

	public int getTwoPointAttempt() {
		return twoPointAttempt;
	}

	public void setTwoPointAttempt(int twoPointAttempt) {
		this.twoPointAttempt = twoPointAttempt;
	}

	public int getFreeThrow() {
		return freeThrow;
	}

	public void setFreeThrow(int freeThrow) {
		this.freeThrow = freeThrow;
	}

	public int getFreeThrowAttempt() {
		return freeThrowAttempt;
	}

	public void setFreeThrowAttempt(int freeThrowAttempt) {
		this.freeThrowAttempt = freeThrowAttempt;
	}

	public int getOffensiveRebound() {
		return offensiveRebound;
	}

	public void setOffensiveRebound(int offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}

	public int getDefensiveRebound() {
		return defensiveRebound;
	}

	public void setDefensiveRebound(int defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getSteal() {
		return steal;
	}

	public void setSteal(int steal) {
		this.steal = steal;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public int getPersonalFoul() {
		return personalFoul;
	}

	public void setPersonalFoul(int personalFoul) {
		this.personalFoul = personalFoul;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public Team getGruop() {
		return gruop;
	}

	public void setGruop(Team gruop) {
		this.gruop = gruop;
	}

	@Override
	public String toString() {
		return "StatsSeason (+" + team.getSeason() +"+,+" + team.getName() + "+," + threePoint + "," + threePointAttempt
				+ "," + twoPoint + "," + twoPointAttempt + "," + freeThrow
				+ "," + freeThrowAttempt + "," + offensiveRebound
				+ "," + defensiveRebound + "," + assist + "," + steal + ","
				+ block + "," + turnover + "," + personalFoul + "," + point + ","
				+ gruop + ");";
	}
	


}