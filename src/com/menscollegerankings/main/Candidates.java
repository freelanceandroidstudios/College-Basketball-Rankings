package com.menscollegerankings.main;

/*
 * Custom objects used to store each candidate team's information
 */

public class Candidates {

	private String name;
	private String rank;
	private String market;
	private String wins;
	private String losses;
	private String previousRank;
	private String points;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @return the market
	 */
	public String getMarket() {
		return market;
	}

	/**
	 * @return the wins
	 */
	public String getWins() {
		return wins;
	}

	/**
	 * @return the losses
	 */
	public String getLosses() {
		return losses;
	}

	/**
	 * @return the previousRank
	 */
	public String getPreviousRank() {
		return previousRank;
	}

	/**
	 * @return the points
	 */
	public String getPoints() {
		return points;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @param market
	 *            the market to set
	 */
	public void setMarket(String market) {
		this.market = market;
	}

	/**
	 * @param wins
	 *            the wins to set
	 */
	public void setWins(String wins) {
		this.wins = wins;
	}

	/**
	 * @param losses
	 *            the losses to set
	 */
	public void setLosses(String losses) {
		this.losses = losses;
	}

	/**
	 * @param previousRank
	 *            the previousRank to set
	 */
	public void setPreviousRank(String previousRank) {
		this.previousRank = previousRank;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(String points) {
		this.points = points;
	}

}
