package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.api.GreetingService;
import com.emodiz.date.time.diff.client.api.GreetingServiceAsync;
import com.emodiz.date.time.diff.client.presenter.DateTimeDifferencePresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Date_Time_Difference_Calculator___Duration_Subtraction___Diff_of_2_Date_Time implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("mainDiv").add(new DateTimeDifferencePresenter().getWidgetToShow());

	}
}
