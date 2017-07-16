package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.TimePickerPresenter.ITimePickerView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;

public class TimePickerView extends Composite implements ITimePickerView{

	private static TimePickerViewUiBinder uiBinder = GWT.create(TimePickerViewUiBinder.class);
	private TimePickerPresenter timePickerPresenter;
	interface TimePickerViewUiBinder extends UiBinder<Widget, TimePickerView> {
	}


	@UiField
	MaterialTimePicker timePicker;
	public MaterialTimePicker getTimePicker() {
		return timePicker;
	}

	public MaterialButton getCurrentTimeButton() {
		return currentTime;
	}

	public MaterialButton getClearDateButton() {
		return clearDate;
	}

	@UiField
	MaterialButton currentTime, clearDate;
	
	public TimePickerView(String placeholder) {
		initWidget(uiBinder.createAndBindUi(this));
		timePicker.setPlaceholder(placeholder);
	}

	@Override
	public void setPresenter(TimePickerPresenter timePickerPresenter) {
		// TODO Auto-generated method stub
		this.timePickerPresenter= timePickerPresenter;
	}

	@Override
	public Widget getWidgetToShow() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
