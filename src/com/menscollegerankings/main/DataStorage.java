package com.menscollegerankings.main;

import java.util.ArrayList;

public class DataStorage {

	private  ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<NonRankedTeams> consideration = new ArrayList<NonRankedTeams>();
	private  String updatedTime;
	
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public ArrayList<NonRankedTeams> getConsideration() {
		return consideration;
	}
	public void setConsideration(ArrayList<NonRankedTeams> consideration) {
		this.consideration = consideration;
	}
	
}
