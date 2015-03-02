package com.menscollegerankings.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * EXAMPLE OF DATE 
 * effective_time="2014-12-15T17:30:00+00:00"
 */

/*
 * Example of date object 
 * Wed Feb 25 21:20:15 EST 2015
 */

public class FormatDate {

	private SimpleDateFormat storageFormat = new SimpleDateFormat("MMddyyyy");

	String dString;

	public FormatDate(String s) {
		this.dString = s;
	}

	public FormatDate() {
	}

	public String formatDateForStorage() {

		Date date = new Date();
		return getStorageFormat().format(date);

	}

	public String formatDate() throws ParseException {

		String oldstring = this.dString;
		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.parse(oldstring);

		String newstring = new SimpleDateFormat("MM-dd-yyyy").format(date);

		return newstring;
	}

	/**
	 * @return the storageFormat
	 */
	public SimpleDateFormat getStorageFormat() {
		return storageFormat;
	}

	/**
	 * @param storageFormat the storageFormat to set
	 */
	public void setStorageFormat(SimpleDateFormat storageFormat) {
		this.storageFormat = storageFormat;
	}

}
