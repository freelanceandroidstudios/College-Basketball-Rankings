package com.menscollegerankings.main;

import com.menscollegerankings.main.LoadingFragment.DataExecution;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class GetRankings extends AsyncTask<Context, Void, Void> {

	private String result; // string with data stream to return
	private String testString; // API key
	private DataExecution dataExecutionInterface; // interface to callback after
													// completion safetly

	public GetRankings(String testString, DataExecution dataExecutionInterface) {
		setTestString(testString);
		setDataExecutionInterface(dataExecutionInterface);
	}

	@Override
	protected Void doInBackground(Context... params) {

		Storage storage = new Storage(params[0]);
		if (storage.getPreferences().getBoolean(Keys.FIRST_RUN, true) == true) {
			// first run download data and store data and date
			Log.i(getClass().getSimpleName(), "First Run");
			HttpGetData httpGetData = new HttpGetData(getTestString());
			httpGetData.executeHttp();
			setResult(httpGetData.getResult());
			// store date
			storage.storeDownloadDate();
			storage.storeDataString(getResult());
			if(getResult() != null)
				storage.getEditor().putBoolean(Keys.FIRST_RUN, false).apply();
		} else if (!storage.compareDownloadDates()) {
			Log.i(getClass().getSimpleName(), "Downloaded");
			HttpGetData httpGetData = new HttpGetData(getTestString());
			httpGetData.executeHttp();
			setResult(httpGetData.getResult());
			// store date
			storage.storeDownloadDate();
			storage.storeDataString(getResult());
		} else {
			Log.i(getClass().getSimpleName(), "From Storage");
			setResult(storage.getStoredDataString());
		}

		return null;

	}

	@Override
	protected void onPostExecute(Void r) {
		super.onPostExecute(r);
		// pop interface to callback to fragment with data string
		getDataExecutionInterface().onDataCompleted(getResult());

	}

	/**
	 * @return the testString
	 */
	public String getTestString() {
		return testString;
	}

	/**
	 * @param testString
	 *            the testString to set
	 */
	public void setTestString(String testString) {
		this.testString = testString;
	}

	/**
	 * @return the dataExecutionInterface
	 */
	public DataExecution getDataExecutionInterface() {
		return dataExecutionInterface;
	}

	/**
	 * @param dataExecutionInterface
	 *            the dataExecutionInterface to set
	 */
	public void setDataExecutionInterface(DataExecution dataExecutionInterface) {
		this.dataExecutionInterface = dataExecutionInterface;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}
