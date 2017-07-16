package com.emodiz.date.time.diff.client;

import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractPresenter implements IPresenter{

	protected IView display;
	public Widget getWidgetToShow() {
		return display.getWidgetToShow();
	}

	public IPresenter getPresenter() {
		return this;
	}
	
}
