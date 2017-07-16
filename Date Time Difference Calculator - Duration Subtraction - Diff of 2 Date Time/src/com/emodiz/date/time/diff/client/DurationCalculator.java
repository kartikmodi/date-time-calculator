package com.emodiz.date.time.diff.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DurationCalculator implements IDurationCalculator {
	private static DurationCalculator instance;
	private Map<TimeUnit, Long> unitVsDifference;

	private DurationCalculator() {
		unitVsDifference = new LinkedHashMap<TimeUnit, Long>();
	}

	public static DurationCalculator getInstance() {
		if (null == instance) {
			instance = new DurationCalculator();
		}
		return instance;

	}

	@Override
	public void subtractDate(Date firstDate, Date secondDate) {
		// TODO Auto-generated method stub
		computeDiff(firstDate, secondDate);

	}

	@Override
	public void subtractTime(Date firstTime, Date secondTime) {
		// TODO Auto-generated method stub
		computeDiff(firstTime, secondTime);

	}

	@Override
	public void subtractDateAndTime(Date firstDate, Date firstTime, Date secondDate, Date secondTime) {
		// TODO Auto-generated method stub
		Date firstDateTime = combineDateObjects(firstDate, firstTime);
		Date secondDateTime = combineDateObjects(secondDate, secondTime);
		computeDiff(firstDateTime, secondDateTime);
	}

	private void computeDiff(Date date1, Date date2) {
		// clearing map
		getUnitVsDifference().clear();
		long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
		List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
		Collections.reverse(units);
		long milliesRest = diffInMillies;
		for (TimeUnit unit : units) {
			long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
			long diffInMilliesForUnit = unit.toMillis(diff);
			milliesRest = milliesRest - diffInMilliesForUnit;
			if (diff != 0L)
				getUnitVsDifference().put(unit, diff);
		}
	}

	/*
	 * public Date combineDateObjects(Date date, Date time) {
	 * 
	 * return new Date(date.getYear(), date.getMonth(), date.getDay(),
	 * time.getHours(), time.getMinutes(), time.getSeconds());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Calendar dateCal = GregorianCalendar.getInstance();
	 * dateCal.setTime(date);
	 * 
	 * Calendar timeCal = GregorianCalendar.getInstance();
	 * timeCal.setTime(time);
	 * 
	 * Calendar dateTimeCal = GregorianCalendar.getInstance();
	 * dateTimeCal.set(Calendar.DAY_OF_MONTH,
	 * dateCal.get(Calendar.DAY_OF_MONTH)); dateTimeCal.set(Calendar.MONTH,
	 * dateCal.get(Calendar.MONTH)); dateTimeCal.set(Calendar.YEAR,
	 * dateCal.get(Calendar.YEAR)); dateTimeCal.set(Calendar.HOUR,
	 * timeCal.get(Calendar.HOUR)); dateTimeCal.set(Calendar.MINUTE,
	 * timeCal.get(Calendar.MINUTE));
	 * 
	 * return dateTimeCal.getTime(); }
	 */

	public Date combineDateObjects(Date date, Date time) {
		long sum = date.getTime() + time.getTime();
		return new Date(sum);
	}

	@Override
	public Map<TimeUnit, Long> getUnitVsDifference() {
		return unitVsDifference;
	}

}
