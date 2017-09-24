package com.emodiz.date.time.diff.client.presenter;

import java.util.Date;

import com.emodiz.date.time.diff.client.api.IView;
import com.emodiz.date.time.diff.client.api.IWidgetPresenter;
import com.emodiz.date.time.diff.client.service.Framework;
import com.emodiz.date.time.diff.client.view.TimePickerView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;

public class TimePickerPresenter extends AbstractPresenter implements IWidgetPresenter {

	public interface ITimePickerView extends IView {

		public void setPresenter(TimePickerPresenter timePickerPresenter);

		public MaterialTimePicker getTimePicker();

		public MaterialButton getCurrentTimeButton();

		public MaterialButton getClearDateButton();

		public Widget getWidgetToShow();
	}

	private ITimePickerView display;

	public TimePickerPresenter(String placeholder) {
		// TODO Auto-generated constructor stub
		display = new TimePickerView(placeholder);
		super.display = display;
		display.setPresenter(this);
		initlializeHandlers();
		Framework.getWidgetRegistrar().registerWidget(this, TimePickerPresenter.class);
	}

	private void initlializeHandlers() {
		display.getCurrentTimeButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				display.getTimePicker().setValue(new Date(), true);

			}
		});
		display.getClearDateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				display.getTimePicker().clear();
				display.getTimePicker().setValue(null, true);
				updateDataManager();
			}
		});

		display.getTimePicker().addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				// TODO Auto-generated method stub
				updateDataManager();
			}

		});

	}

	private void updateDataManager() {
		Framework.getDataManager().setValueOfWidget(getPresenter(), display.getTimePicker().getValue());
	}

	@Override
	public void setErrorOnWidget(String errorMessage) {
		// TODO Auto-generated method stub
		if (null == display.getTimePicker().getValue()) {
			display.getTimePicker().setError(errorMessage);
		}
	}

	@Override
	public void clearErrorOrSuccessOnWidget() {
		// TODO Auto-generated method stub
			display.getTimePicker().clearErrorOrSuccess();
	}

}
