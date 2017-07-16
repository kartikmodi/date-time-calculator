package com.emodiz.date.time.diff.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;

public class DatePickerPresenter extends AbstractPresenter implements IWidgetPresenter {
	interface IDatePickerView extends IView {

		public MaterialDatePicker getDatePicker();

		public MaterialButton getTodaysDateButton();

		public MaterialButton getClearDateButton();

		public void setPresenter(DatePickerPresenter datePickerPresenter);

	}

	private IDatePickerView display;

	public DatePickerPresenter(String placeholder) {
		// TODO Auto-generated constructor stub
		display = new DatePickerView(placeholder);
		super.display = display;
		display.setPresenter(this);
		initlializeHandlers();
		Framework.getWidgetRegistrar().registerWidget(this, DatePickerPresenter.class);
	}

	private void initlializeHandlers() {
		display.getTodaysDateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				display.getDatePicker().clear();
				display.getDatePicker().setValue(new Date(), true);

			}
		});
		display.getClearDateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				display.getDatePicker().setValue(null, true);
				updateDataManager();
			}
		});

		display.getDatePicker().addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				// TODO Auto-generated method stub
				updateDataManager();
			}

		});

	}

	private void updateDataManager() {
		Framework.getDataManager().setValueOfWidget(getPresenter(), display.getDatePicker().getDate());
	}

	@Override
	public void setErrorOnWidget(String errorMessage) {
		// TODO Auto-generated method stub
		if (null == display.getDatePicker().getDate()) {
			display.getDatePicker().setError(errorMessage);
		}
	}

	@Override
	public void clearErrorOrSuccessOnWidget() {
		// TODO Auto-generated method stub
		display.getDatePicker().clearErrorOrSuccess();
	}
}
