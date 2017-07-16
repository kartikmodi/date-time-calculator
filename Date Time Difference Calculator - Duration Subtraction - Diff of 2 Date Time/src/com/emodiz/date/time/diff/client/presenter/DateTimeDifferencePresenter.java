package com.emodiz.date.time.diff.client.presenter;

import com.emodiz.date.time.diff.client.api.IView;
import com.emodiz.date.time.diff.client.handler.CalculateDurationHandler;
import com.emodiz.date.time.diff.client.view.DateTimeDifferenceView;

import gwt.material.design.client.ui.MaterialButton;

public class DateTimeDifferencePresenter extends AbstractPresenter {
	public interface IDateTimeDifferenceView extends IView {

		public MaterialButton getCalculateDurationButton();

		public void setPresenter(DateTimeDifferencePresenter dateTimeDifferencePresenter);

	}
	private IDateTimeDifferenceView display;

	public DateTimeDifferencePresenter() {
		// TODO Auto-generated constructor stub
		display = new DateTimeDifferenceView();
		super.display = display;
		display.setPresenter(this);
		initlializeHandlers();
	}

	private void initlializeHandlers() {
		// TODO Auto-generated method stub
		display.getCalculateDurationButton().addClickHandler(new CalculateDurationHandler());
	}

}
