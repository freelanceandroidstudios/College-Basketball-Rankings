package com.menscollegerankings.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoadingFragment extends Fragment {

	interface DataExecution {
		void onDataCompleted(String result);
	}

	private String test;
	private GetRankings getRankingsThread;
	private String result;

	public LoadingFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTest(getResources().getString(R.string.AP_KEY)); // attach API key

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//setup Asynctaks thread class
		setGetRankingsThread(new GetRankings(getTest(),dataExecutionInterface));
		getGetRankingsThread().execute(getActivity());

		return inflater.inflate(R.layout.loading_dialog, null, false); // inflate

	}

	DataExecution dataExecutionInterface = new DataExecution() {

		@Override
		public void onDataCompleted(String result) {

			if (result != null) {
				APFragment fragment = new APFragment();
				Bundle bundle = new Bundle();
				bundle.putString(Keys.DATA_KEY, result);
				fragment.setArguments(bundle);
				FragmentManager manager = getActivity()
						.getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				transaction.setCustomAnimations(android.R.anim.fade_in,
						android.R.anim.fade_out);
				transaction.replace(R.id.frag_container, fragment).commit();
			} else {
				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	};

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}

	/**
	 * @return the getRankingsThread
	 */
	public GetRankings getGetRankingsThread() {
		return getRankingsThread;
	}

	/**
	 * @param getRankingsThread
	 *            the getRankingsThread to set
	 */
	public void setGetRankingsThread(GetRankings getRankingsThread) {
		this.getRankingsThread = getRankingsThread;
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
