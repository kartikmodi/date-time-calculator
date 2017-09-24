package com.emodiz.date.time.diff.client.service;

import java.util.HashMap;
import java.util.Map;

import com.emodiz.date.time.diff.client.api.IDataManager;
import com.emodiz.date.time.diff.client.api.IPresenter;


public class DataManager implements IDataManager {
	private static DataManager instance;
	private Map<IPresenter, Object> widgetVsObjectAndClass;

	private DataManager() {
		widgetVsObjectAndClass = new HashMap<IPresenter, Object>();
	}

	public static DataManager getInstance() {
		if (null == instance) {
			instance = new DataManager();
		}
		return instance;
	}

	@Override
	public Object getValueOfWidget(IPresenter widget) {
		// TODO Auto-generated method stub
		return getWidgetVsObjectAndClass().get(widget);
	}

	@Override
	public void setValueOfWidget(IPresenter widget, Object widgetValue) {
		// TODO Auto-generated method stub
		getWidgetVsObjectAndClass().put(widget, widgetValue);
	}

	private Map<IPresenter, Object> getWidgetVsObjectAndClass() {
		return widgetVsObjectAndClass;
	}

}
