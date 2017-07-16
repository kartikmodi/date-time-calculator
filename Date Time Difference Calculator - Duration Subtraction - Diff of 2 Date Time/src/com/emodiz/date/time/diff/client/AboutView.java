package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.AboutPresenter.IAboutView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AboutView extends Composite implements IAboutView {

	private static AboutViewUiBinder uiBinder = GWT.create(AboutViewUiBinder.class);

	interface AboutViewUiBinder extends UiBinder<Widget, AboutView> {
	}
	private AboutPresenter aboutPresenter;

	public AboutView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(AboutPresenter aboutPresenter) {
		// TODO Auto-generated method stub
		this.aboutPresenter = aboutPresenter;
	}

	@Override
	public Widget getWidgetToShow() {
		// TODO Auto-generated method stub
		return this;
	}
}
