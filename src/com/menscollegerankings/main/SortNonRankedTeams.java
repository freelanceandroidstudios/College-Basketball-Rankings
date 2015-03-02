package com.menscollegerankings.main;

import java.util.Comparator;

public class SortNonRankedTeams implements Comparator<NonRankedTeams> {

	@Override
	public int compare(NonRankedTeams lhs, NonRankedTeams rhs) {
		int lhsP = Integer.parseInt(lhs.getVotes());
		int rhsP = Integer.parseInt(rhs.getVotes());

		if (lhsP < rhsP) {
			return 1;
		} else if (lhsP > rhsP) {
			return -1;
		} else {
			return 0;
		}
	}

}
