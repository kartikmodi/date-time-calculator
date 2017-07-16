package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.DatePickerPresenter.IDatePickerView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;

public class DatePickerView extends Composite implements IDatePickerView {

	private static DatePickerViewUiBinder uiBinder = GWT.create(DatePickerViewUiBinder.class);
	private DatePickerPresenter datePickerPresenter;
	interface DatePickerViewUiBinder extends UiBinder<Widget, DatePickerView> {
	}

	@UiField
	MaterialDatePicker datePicker;
	@UiField
	MaterialButton todaysDate, clearDate;
	
	public DatePickerView(String placeholder) {
		initWidget(uiBinder.createAndBindUi(this));
		datePicker.setPlaceholder(placeholder);
	}

	@Override
	public void setPresenter(DatePickerPresenter datePickerPresenter) {
		// TODO Auto-generated method stub
		this.datePickerPresenter = datePickerPresenter;
	}

	@Override
	public MaterialDatePicker getDatePicker() {
		// TODO Auto-generated method stub
		return datePicker;
	}

	@Override
	public MaterialButton getTodaysDateButton() {
		// TODO Auto-generated method stub
		return todaysDate;
	}

	@Override
	public MaterialButton getClearDateButton() {
		// TODO Auto-generated method stub
		return clearDate;
	}

	@Override
	public Widget getWidgetToShow() {
		// TODO Auto-generated method stub
		return this;
	}


}
