package com.menscollegerankings.main;

import java.text.ParseException;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class APFragment extends Fragment {

	private XMLParser parser;
	private TextView titleTV, considerationTV, rankTV, teamNameTV, recordTV,
			updated;
	private LinearLayout layout, considerationLayout;

	public APFragment() {
		// android empty constructor for orientation changes
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get the arguments sent from calling activity
		String result = getArguments().getString(Keys.DATA_KEY);
		parseXMLString(result);
	
	}

	/**
	 * @param result
	 *            parsed response string into custom class objects
	 */
	private void parseXMLString(String result) {
		try {
			parser = new XMLParser(result);
			parser.parseXMLRankings();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// inflate custom XMl view
		View view = inflater.inflate(R.layout.ap_fragment, container, false);

		assignVariables(view);
		underlineTextViews(); // underlines specific textview's text

		// add each team row to main layout
		for (int i = 0; i < parser.getDataStorage().getTeams().size(); i++) {
			layout.addView(
					new TeamRow(getActivity(), i, parser.getDataStorage()),
					layout.getChildCount() - 5);
		}

		// add each inflated team row to main layout
		for (int i = 0; i < parser.getDataStorage().getConsideration().size(); i++) {
			considerationLayout.addView(new CanidatesTableRow(getActivity(), i,
					parser.getDataStorage()), considerationLayout
					.getChildCount());
		}

		setUpdatedTime();

		return view;
	}

	/**
	 * converts a string date and time to custom date and time
	 */
	private void setUpdatedTime() {

		if (parser.getDataStorage().getUpdatedTime() != null
				|| parser.getDataStorage().getUpdatedTime() != "") {
			try {
				updated.setText("Updated: "
						+ new FormatDate(parser.getDataStorage()
								.getUpdatedTime()).formatDate());

			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception ex) {

			}
		}
	}

	/**
	 * underlines textviews text
	 */
	private void underlineTextViews() {

		getRankTV().setPaintFlags(
				rankTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		getTeamNameTV().setPaintFlags(
				teamNameTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		getRecordTV().setPaintFlags(
				recordTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
	}

	/**
	 * @param view
	 *            converts XMl view elements to java type objects
	 */
	private void assignVariables(View view) {

		setUpdated((TextView) view.findViewById(R.id.updatedTextView));
		setConsiderationLayout((LinearLayout) view
				.findViewById(R.id.canidatesLayout));
		setTitleTV((TextView) view.findViewById(R.id.titleTextView));
		setLayout((LinearLayout) view.findViewById(R.id.rankingsLinearLayout));
		setConsiderationTV((TextView) view
				.findViewById(R.id.considerationTextView));

		setRankTV((TextView) view.findViewById(R.id.rankInfoTV));
		setTeamNameTV((TextView) view.findViewById(R.id.teamNameInfoTV));
		setRecordTV((TextView) view.findViewById(R.id.recordInfoTextView));
	}

	/**
	 * @return the parser
	 */
	public XMLParser getParser() {
		return parser;
	}

	/**
	 * @return the titleTV
	 */
	public TextView getTitleTV() {
		return titleTV;
	}

	/**
	 * @return the considerationTV
	 */
	public TextView getConsiderationTV() {
		return considerationTV;
	}

	/**
	 * @return the rankTV
	 */
	public TextView getRankTV() {
		return rankTV;
	}

	/**
	 * @return the teamNameTV
	 */
	public TextView getTeamNameTV() {
		return teamNameTV;
	}

	/**
	 * @return the recordTV
	 */
	public TextView getRecordTV() {
		return recordTV;
	}

	/**
	 * @return the updated
	 */
	public TextView getUpdated() {
		return updated;
	}

	/**
	 * @return the layout
	 */
	public LinearLayout getLayout() {
		return layout;
	}

	/**
	 * @return the considerationLayout
	 */
	public LinearLayout getConsiderationLayout() {
		return considerationLayout;
	}

	/**
	 * @param parser
	 *            the parser to set
	 */
	public void setParser(XMLParser parser) {
		this.parser = parser;
	}

	/**
	 * @param titleTV
	 *            the titleTV to set
	 */
	public void setTitleTV(TextView titleTV) {
		this.titleTV = titleTV;
	}

	/**
	 * @param considerationTV
	 *            the considerationTV to set
	 */
	public void setConsiderationTV(TextView considerationTV) {
		this.considerationTV = considerationTV;
	}

	/**
	 * @param rankTV
	 *            the rankTV to set
	 */
	public void setRankTV(TextView rankTV) {
		this.rankTV = rankTV;
	}

	/**
	 * @param teamNameTV
	 *            the teamNameTV to set
	 */
	public void setTeamNameTV(TextView teamNameTV) {
		this.teamNameTV = teamNameTV;
	}

	/**
	 * @param recordTV
	 *            the recordTV to set
	 */
	public void setRecordTV(TextView recordTV) {
		this.recordTV = recordTV;
	}

	/**
	 * @param updated
	 *            the updated to set
	 */
	public void setUpdated(TextView updated) {
		this.updated = updated;
	}

	/**
	 * @param layout
	 *            the layout to set
	 */
	public void setLayout(LinearLayout layout) {
		this.layout = layout;
	}

	/**
	 * @param considerationLayout
	 *            the considerationLayout to set
	 */
	public void setConsiderationLayout(LinearLayout considerationLayout) {
		this.considerationLayout = considerationLayout;
	}
}
