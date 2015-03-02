package com.menscollegerankings.main;

import java.util.Comparator;

public class SortRankings implements Comparator<Team> {

	public SortRankings() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Team lhs, Team rhs) {
		Team aTeam = lhs;
		Team bTeam = rhs;

		if (Integer.parseInt(aTeam.getRank()) < Integer.parseInt(bTeam
				.getRank())) {
			return -1;
		} else {
			return 1;
		}
	}

}
