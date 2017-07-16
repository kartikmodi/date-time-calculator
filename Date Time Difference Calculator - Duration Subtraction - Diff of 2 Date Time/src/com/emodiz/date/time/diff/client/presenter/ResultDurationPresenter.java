package com.emodiz.date.time.diff.client.presenter;

import com.emodiz.date.time.diff.client.api.IResultDurationPresenter;
import com.emodiz.date.time.diff.client.api.IView;
import com.emodiz.date.time.diff.client.service.Framework;
import com.emodiz.date.time.diff.client.view.ResultDurationView;
import com.google.gwt.dom.client.Style.Unit;

import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class ResultDurationPresenter extends AbstractPresenter implements IResultDurationPresenter{
	public interface IResultDurationView extends IView {

		public void setPresenter(ResultDurationPresenter resultDurationPresenter);

		public MaterialTextBox getResultTextBox();

	}

	private IResultDurationView display;

	public ResultDurationPresenter() {
		// TODO Auto-generated constructor stub
		display = new ResultDurationView();
		setTextAndVisibleOnLabel("", false);
		display.getResultTextBox().setFontSize(1.5, Unit.EM);
		super.display = display;
		display.setPresenter(this);
		Framework.getWidgetRegistrar().registerWidget(this, ResultDurationPresenter.class);
	}

	@Override
	public void setTextAndVisibleOnLabel(String text, Boolean isVisible) {
		if(text.equals("")){
			text = "0 Days";
		}
		display.getResultTextBox().setText(text);
		display.getResultTextBox().setVisible(isVisible);
	}

	@Override
	public void setErrorOnWidget(String errorMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearErrorOrSuccessOnWidget() {
		// TODO Auto-generated method stub
		
	}
	
	
}