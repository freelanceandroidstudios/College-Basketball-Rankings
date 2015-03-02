package com.menscollegerankings.main;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TeamRow extends LinearLayout {

	LayoutInflater inflater;
	int position;
	DataStorage dataStorage;

	public TeamRow(Context context, int i, DataStorage dataStorage) {
		super(context);
		this.inflater = (LayoutInflater) getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		this.position = i;
		this.dataStorage = dataStorage;

		setUpView(); // inflates the view for each row
		mapViewElements(); // converts xml to java variables and assigns data
	}

	public Team getItem(int position) {
		return dataStorage.getTeams().get(position);
	}

	private void mapViewElements() {

		TextView rank = (TextView) this.findViewById(R.id.rankTV);
		TextView name = (TextView) this.findViewById(R.id.teamNameTV);
		TextView winsLosses = (TextView) this.findViewById(R.id.winsLossesTV);
		TextView previousRank = (TextView) this
				.findViewById(R.id.previousRankTextView);

		rank.setText(getItem(position).getRank() + ".");
		name.setText(getItem(position).getName());
		winsLosses.setText(getItem(position).getWins() + "-"
				+ getItem(position).getLosses());
		setPreviousRank(previousRank, getItem(position).getPreviousRank(),
				getItem(position).getRank());
		
		if(position % 2 != 0 ){
			this.setBackgroundColor(Color.parseColor("#F1F1F1"));
		}

	}

	private void setPreviousRank(TextView previousRank, String previous,
			String current) {

		int pRank;
		int cRank;
		// parse string rank into integer value
		try {
			pRank = Integer.parseInt(previous);
			cRank = Integer.parseInt(current);

			if (pRank > cRank) { // team went up the ap
				int diff = pRank - cRank;
				previousRank.setText("+" + diff);
				previousRank.setTextColor(Color.parseColor("#00ff00"));
			} else if (cRank > pRank) { // team went down the ap
				int diff = cRank - pRank;
				previousRank.setText("-" + diff);
				previousRank.setTextColor(Color.parseColor("#ff0000"));
			}
		} catch (NumberFormatException nfe) {
			// no previous rank tag
			Log.e("NFE", nfe.getMessage().toString());
			previousRank.setVisibility(View.INVISIBLE);
		} catch (Exception ex) {
			Log.e("Exception", ex.getMessage().toString());
		}

	}

	private void setUpView() {
		inflater.inflate(R.layout.ranking_list_view_row, this, true);

	}

}
