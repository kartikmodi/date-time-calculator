package com.emodiz.date.time.diff.client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.emodiz.date.time.diff.client.api.IDataValidator;
import com.emodiz.date.time.diff.client.api.IDurationCalculator;
import com.emodiz.date.time.diff.client.api.IWidgetPresenter;
import com.emodiz.date.time.diff.client.presenter.DatePickerPresenter;
import com.emodiz.date.time.diff.client.presenter.TimePickerPresenter;

import gwt.material.design.client.ui.MaterialToast;

public class DataValidator implements IDataValidator {
	private static DataValidator instance;
	private Boolean datePickerValues;
	private Boolean timePickerValues;
	private Boolean datePickerAttempted;
	private Boolean timePickerAttempted;
	private List<IWidgetPresenter> datePickerWidgets;
	private List<IWidgetPresenter> timePickerWidgets;
	private IDurationCalculator durationCalculator;

	private DataValidator() {
		durationCalculator = Framework.getDurationCalculator();
	}

	private void resetWidgetStates() {
		datePickerValues = Boolean.TRUE;
		timePickerValues = Boolean.TRUE;
		datePickerAttempted = Boolean.FALSE;
		timePickerAttempted = Boolean.FALSE;

	}

	public static DataValidator getInstance() {
		if (null == instance) {
			instance = new DataValidator();
		}
		return instance;
	}

	private List<Date> getDatePickerWidgetValues() {
		List<Date> dateValues = new ArrayList<Date>();
		for (IWidgetPresenter widget : datePickerWidgets) {
			dateValues.add((Date) Framework.getDataManager().getValueOfWidget(widget));
		}
		return dateValues;
	}

	private List<Date> getTimePickerWidgetValues() {
		List<Date> timeValues = new ArrayList<Date>();
		for (IWidgetPresenter widget : timePickerWidgets) {
			timeValues.add((Date) Framework.getDataManager().getValueOfWidget(widget));
		}
		return timeValues;
	}

	@Override
	public Boolean validateData() {
		resetWidgetStates();
		// TODO Auto-generated method stub
		loadDataForValidation();

		if (datePickerAttempted && !timePickerAttempted) {
			if (datePickerValues) {
				// call date diff calculator
				Date firstDate = getDatePickerWidgetValues().get(0);
				Date secondDate = getDatePickerWidgetValues().get(1);
				durationCalculator.subtractDate(firstDate, secondDate);
				return true;
			} else {
				// validation error on date pickers
				showErrorOnWidgetGroup(datePickerWidgets, "Please fill date here.");
				return false;
			}
		} else if (!datePickerAttempted && timePickerAttempted) {
			if (timePickerValues) {
				// call time diff calculator
				durationCalculator.subtractTime(getTimePickerWidgetValues().get(0), getTimePickerWidgetValues().get(1));
				return true;
			} else {
				// validation error on time pickers
				showErrorOnWidgetGroup(timePickerWidgets, "Please fill time here.");
				return false;
			}
		} else if (timePickerAttempted && datePickerAttempted) {
			if (datePickerValues && timePickerValues) {
				// call date and time diff calculator
				durationCalculator.subtractDateAndTime(getDatePickerWidgetValues().get(0),
						getTimePickerWidgetValues().get(0), getDatePickerWidgetValues().get(1),
						getTimePickerWidgetValues().get(1));
				return true;
			} else {
				// validation error on date and time pickers both
				showErrorOnWidgetGroup(datePickerWidgets, "Please fill date here.");
				showErrorOnWidgetGroup(timePickerWidgets, "Please fill time here.");
				return false;
			}
		} else if (!timePickerAttempted && !datePickerAttempted) {
			// validation error on date pickers with proper message
			MaterialToast.fireToast("Please fill either date or time fields.", "rounded");
			return false;
		}
		return false;
	}

	private void showErrorOnWidgetGroup(List<IWidgetPresenter> widgets, String errorMessage) {
		for (IWidgetPresenter widget : widgets) {
			widget.setErrorOnWidget(errorMessage);
		}
	}

	private void loadDataForValidation() {
		datePickerWidgets = Framework.getWidgetRegistrar().getAllWidgetsForClass(DatePickerPresenter.class);
		for (IWidgetPresenter widget : datePickerWidgets) {
			widget.clearErrorOrSuccessOnWidget();
			if (null == Framework.getDataManager().getValueOfWidget(widget)) {
				datePickerValues = Boolean.FALSE;
			} else {
				datePickerAttempted = Boolean.TRUE;
			}
		}

		timePickerWidgets = Framework.getWidgetRegistrar().getAllWidgetsForClass(TimePickerPresenter.class);
		for (IWidgetPresenter widget : timePickerWidgets) {
			widget.clearErrorOrSuccessOnWidget();
			if (null == Framework.getDataManager().getValueOfWidget(widget)) {
				timePickerValues = Boolean.FALSE;
			} else {
				timePickerAttempted = Boolean.TRUE;
			}
		}
	}
}
