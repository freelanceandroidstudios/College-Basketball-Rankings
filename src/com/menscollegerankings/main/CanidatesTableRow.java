package com.menscollegerankings.main;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.TableRow;
import android.widget.TextView;

public class CanidatesTableRow extends TableRow {

	private LayoutInflater inflater;
	private int i;
	private DataStorage dataStorage;

	public CanidatesTableRow(Context context, int i, DataStorage dataStorage) {
		super(context);
		setInflater((LayoutInflater) getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE));
		setI(i);
		setDataStorage(dataStorage);

		getInflater().inflate(R.layout.consideration_tablerow, this, true);

		assignVariables();
		
		//checks if the row index is even / color background of row on even indexes
		if (i % 2 != 0) {
			this.setBackgroundColor(Color.parseColor("#F1F1F1"));
		}

	}

	private void assignVariables() {
		
		TextView teamName = (TextView) this
				.findViewById(R.id.team_name_consideration);
		TextView votes = (TextView) this.findViewById(R.id.votes_consideration);

		assignData(teamName, votes);

	}

	/**
	 * @param teamName
	 * @param votes
	 */
	private void assignData(TextView teamName, TextView votes) {
		teamName.setText(this.dataStorage.getConsideration().get(i).getName());
		votes.setText(this.dataStorage.getConsideration().get(i).getVotes());
	}

	/**
	 * @return the inflater
	 */
	public LayoutInflater getInflater() {
		return inflater;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @return the dataStorage
	 */
	public DataStorage getDataStorage() {
		return dataStorage;
	}

	/**
	 * @param inflater the inflater to set
	 */
	public void setInflater(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * @param dataStorage the dataStorage to set
	 */
	public void setDataStorage(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
	}

}
