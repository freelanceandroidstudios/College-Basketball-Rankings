package com.menscollegerankings.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class StringBufferedReader {
	public StringBufferedReader() {

	}

	public String readerStringStream(HttpResponse response) {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
		} catch (IllegalStateException | IOException e) {

			e.printStackTrace();
		}

		StringBuffer sb = new StringBuffer("");
		String line = "";
		String NL = System.getProperty("line.separator");
		try {
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

}