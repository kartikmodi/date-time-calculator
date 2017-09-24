package com.emodiz.date.time.diff.client.api;

import java.util.Date;
import java.util.Map;

import com.emodiz.date.time.diff.client.lib.TimeUnit;

public interface IDurationCalculator {
	public void subtractDate(Date firstDate, Date secondDate);

	public void subtractTime(Date firstTime, Date secondTime);

	public void subtractDateAndTime(Date firstDate, Date firstTime, Date secondDate, Date secondTime);

	public Map<TimeUnit, Long> getUnitVsDifference();
}
