package com.emodiz.date.time.diff.client.handler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.emodiz.date.time.diff.client.api.ICalculateDurationHandler;
import com.emodiz.date.time.diff.client.api.IResultDurationPresenter;
import com.emodiz.date.time.diff.client.api.IWidgetPresenter;
import com.emodiz.date.time.diff.client.lib.TimeUnit;
import com.emodiz.date.time.diff.client.presenter.ResultDurationPresenter;
import com.emodiz.date.time.diff.client.service.Framework;
import com.google.gwt.event.dom.client.ClickEvent;

public class CalculateDurationHandler implements ICalculateDurationHandler {

	private Boolean isValidated = Boolean.FALSE;

	@Override
	public void handleCalculateDurationEvent() {
		// TODO Auto-generated method stub
		validateDataFromUser();
		if (isValidated) {
			displayResult();
		}
	}

	private void displayResult() {
		// TODO Auto-generated method stub
		Map<TimeUnit, Long> unitVsDifference = Framework.getDurationCalculator().getUnitVsDifference();
		StringBuilder resultLabel = new StringBuilder();
		Iterator<Entry<TimeUnit, Long>> it = unitVsDifference.entrySet().iterator();

		while (it.hasNext()) {
			Entry<TimeUnit, Long> pair = it.next();
			resultLabel.append(pair.getValue()).append(" ")
					.append(Character.toUpperCase(pair.getKey().toString().charAt(0)))
					.append(pair.getKey().toString().toLowerCase().substring(1));
			if (it.hasNext())
				resultLabel.append(", ");
		}

		List<IWidgetPresenter> widgets = Framework.getWidgetRegistrar()
				.getAllWidgetsForClass(ResultDurationPresenter.class);
		for (IWidgetPresenter widget : widgets) {
			IResultDurationPresenter resultDurationPresenter = (IResultDurationPresenter) widget;
			resultDurationPresenter.setTextAndVisibleOnLabel(resultLabel.toString(), true);
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		handleCalculateDurationEvent();
	}

	private void validateDataFromUser() {
		isValidated = Framework.getDataValidator().validateData();
	}
}
