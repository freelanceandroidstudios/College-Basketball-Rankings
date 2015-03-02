package com.menscollegerankings.main;

import java.text.SimpleDateFormat;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

public class Storage {

	private SharedPreferences preferences;
	private Editor editor;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Storage(Context context) {
		setPreferences((PreferenceManager.getDefaultSharedPreferences(context
				.getApplicationContext())));
		setEditor(getPreferences().edit());
	}

	public void storeDataString(String data) {
		getEditor().putString(Keys.STORED_DATA_KEY, data).apply();
	}

	public void storeDownloadDate() {
		getEditor().putString(Keys.STORED_DATE,
				new FormatDate().formatDateForStorage()).apply();
		
		Log.i("stored date", new FormatDate().formatDateForStorage());
	}

	public String getStoredDataString() {
		return getPreferences().getString(Keys.STORED_DATA_KEY, "");
	}

	public String getStoredDownloadDate() {
		return getPreferences().getString(Keys.STORED_DATE, "");
	}

	public boolean compareDownloadDates() {
		
		if (getStoredDownloadDate().equals(
				new FormatDate().formatDateForStorage())) {
			return true;
		}

		return false;
	}

	/**
	 * @return the preferences
	 */
	public SharedPreferences getPreferences() {
		return preferences;
	}

	/**
	 * @param preferences
	 *            the preferences to set
	 */
	public void setPreferences(SharedPreferences preferences) {
		this.preferences = preferences;
	}

	/**
	 * @return the editor
	 */
	public Editor getEditor() {
		return editor;
	}

	/**
	 * @param editor
	 *            the editor to set
	 */
	public void setEditor(Editor editor) {
		this.editor = editor;
	}

}
