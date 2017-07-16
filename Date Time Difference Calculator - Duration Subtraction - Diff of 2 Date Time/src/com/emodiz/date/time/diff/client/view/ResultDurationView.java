package com.emodiz.date.time.diff.client.view;

import com.emodiz.date.time.diff.client.presenter.ResultDurationPresenter;
import com.emodiz.date.time.diff.client.presenter.ResultDurationPresenter.IResultDurationView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class ResultDurationView extends Composite implements IResultDurationView {

	private static ResultDurationViewUiBinder uiBinder = GWT.create(ResultDurationViewUiBinder.class);
	private ResultDurationPresenter resultDurationPresenter;
	interface ResultDurationViewUiBinder extends UiBinder<Widget, ResultDurationView> {
	}
	
	@UiField
	MaterialTextBox resultTextBox;

	public ResultDurationView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget getWidgetToShow() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void setPresenter(ResultDurationPresenter resultDurationPresenter) {
		// TODO Auto-generated method stub
		this.resultDurationPresenter = resultDurationPresenter;
	}

	@Override
	public MaterialTextBox getResultTextBox() {
		// TODO Auto-generated method stub
		return resultTextBox;
	}

}
