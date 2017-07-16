package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.presenter.DateTimeDifferencePresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Date_Time_Difference_Calculator___Duration_Subtraction___Diff_of_2_Date_Time implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("mainDiv").add(new DateTimeDifferencePresenter().getWidgetToShow());

	}
}
