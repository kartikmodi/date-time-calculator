package com.emodiz.date.time.diff.client;

import com.emodiz.date.time.diff.client.DateTimeDifferencePresenter.IDateTimeDifferenceView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

public class DateTimeDifferenceView extends Composite implements IDateTimeDifferenceView {

	private static DateTimeDifferenceViewUiBinder uiBinder = GWT.create(DateTimeDifferenceViewUiBinder.class);
	private DateTimeDifferencePresenter dateTimeDifferencePresenter;

	interface DateTimeDifferenceViewUiBinder extends UiBinder<Widget, DateTimeDifferenceView> {
	}

	@UiField
	MaterialContainer contentContainer;
	MaterialPanel dateTimeCalculatorPanel;
	MaterialPanel aboutPanel;
	@UiField
	MaterialLink dateTimeCalculatorLink, aboutLink;
	private MaterialButton calculateDuration;

	public DateTimeDifferenceView() {
		initWidget(uiBinder.createAndBindUi(this));
		dateTimeCalculatorPanel = new MaterialPanel();
		aboutPanel = new MaterialPanel();
		initializeDatePickers();
		initializeTimePickers();
		initializeCalculateDurationButton();
		initializeResult();
		initlializeAbout();
		contentContainer.add(dateTimeCalculatorPanel);
		contentContainer.add(aboutPanel);
		navigationHandlers();
	}

	private void initlializeAbout() {
		AboutPresenter aboutPresenter = new AboutPresenter();
		MaterialRow aboutRow = new MaterialRow();
		MaterialColumn aboutColumn = new MaterialColumn(12, 12, 12);
		aboutColumn.add(aboutPresenter.getWidgetToShow());
		aboutRow.add(aboutColumn);
		aboutPanel.add(aboutRow);
		aboutPanel.setVisible(false);
	}

	private void navigationHandlers() {
		dateTimeCalculatorLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				aboutPanel.setVisible(false);
				dateTimeCalculatorPanel.setVisible(true);
			}
		});
		aboutLink.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				dateTimeCalculatorPanel.setVisible(false);
				aboutPanel.setVisible(true);
			}
		});
	}

	private void initializeResult() {
		IResultDurationPresenter resultDurationPresenter = new ResultDurationPresenter();
		MaterialRow resultRow = new MaterialRow();
		MaterialColumn resultColumn = new MaterialColumn(12, 12, 12);
		resultColumn.add(resultDurationPresenter.getWidgetToShow());
		resultRow.add(resultColumn);
		dateTimeCalculatorPanel.add(resultRow);

	}

	private void initializeCalculateDurationButton() {
		calculateDuration = new MaterialButton("Calculate Duration");
		MaterialRow calculateDurationRow = new MaterialRow();
		MaterialColumn dummyColumn = new MaterialColumn(4, 4, 4);
		MaterialColumn calculateDurationColumn = new MaterialColumn(4, 4, 4);
		calculateDurationColumn.add(calculateDuration);
		calculateDurationRow.add(dummyColumn);
		calculateDurationRow.add(calculateDurationColumn);
		dateTimeCalculatorPanel.add(calculateDurationRow);
	}

	private void initializeDatePickers() {
		DatePickerPresenter startDatePicker = new DatePickerPresenter("Start Date");
		DatePickerPresenter endDatePicker = new DatePickerPresenter("End Date");
		MaterialRow datePickerRow = new MaterialRow();
		MaterialColumn dummyColumn = new MaterialColumn(4, 4, 4);
		MaterialColumn startDatePickerColumn = new MaterialColumn(4, 4, 4);
		startDatePickerColumn.add(startDatePicker.getWidgetToShow());
		MaterialColumn endDatePickerColumn = new MaterialColumn(4, 4, 4);
		endDatePickerColumn.add(endDatePicker.getWidgetToShow());
		datePickerRow.add(dummyColumn);
		datePickerRow.add(startDatePickerColumn);
		datePickerRow.add(dummyColumn);
		datePickerRow.add(endDatePickerColumn);
		dateTimeCalculatorPanel.add(datePickerRow);
	}

	private void initializeTimePickers() {
		TimePickerPresenter startTimePicker = new TimePickerPresenter("Start Time");
		TimePickerPresenter endTimePicker = new TimePickerPresenter("End Time");
		MaterialRow timePickerRow = new MaterialRow();
		MaterialColumn dummyColumn = new MaterialColumn(4, 4, 4);
		MaterialColumn startTimePickerColumn = new MaterialColumn(4, 4, 4);
		startTimePickerColumn.add(startTimePicker.getWidgetToShow());
		MaterialColumn endTimePickerColumn = new MaterialColumn(4, 4, 4);
		endTimePickerColumn.add(endTimePicker.getWidgetToShow());
		timePickerRow.add(dummyColumn);
		timePickerRow.add(startTimePickerColumn);
		timePickerRow.add(dummyColumn);
		timePickerRow.add(endTimePickerColumn);
		dateTimeCalculatorPanel.add(timePickerRow);
	}

	@Override
	public Widget getWidgetToShow() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public MaterialButton getCalculateDurationButton() {
		// TODO Auto-generated method stub
		return calculateDuration;
	}

	@Override
	public void setPresenter(DateTimeDifferencePresenter dateTimeDifferencePresenter) {
		// TODO Auto-generated method stub
		this.dateTimeDifferencePresenter = dateTimeDifferencePresenter;
	}

}
