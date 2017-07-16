package com.emodiz.date.time.diff.client.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emodiz.date.time.diff.client.api.IWidgetPresenter;
import com.emodiz.date.time.diff.client.api.IWidgetRegistrar;



public class WidgetRegistrar<T> implements IWidgetRegistrar<T> {
	private static WidgetRegistrar<?> instance;
	private Map<IWidgetPresenter, Class<?>> classVsWidget;
	private Map<Class<?>, List<IWidgetPresenter>> classVsWidgets;

	private Map<Class<?>, List<IWidgetPresenter>> getClassVsWidgets() {
		return classVsWidgets;
	}

	private WidgetRegistrar() {
		classVsWidget = new HashMap<IWidgetPresenter, Class<?>>();
		classVsWidgets = new HashMap<Class<?>, List<IWidgetPresenter>>();
	}

	public static <T> WidgetRegistrar<?> getInstance() {
		if (null == instance) {
			instance = new WidgetRegistrar<Object>();
		}
		return instance;
	}

	@Override
	public void registerWidget(IWidgetPresenter widget, Class<?> klass) {
		// TODO Auto-generated method stub
		getWidgetVsClass().put(widget, klass);
		if(getClassVsWidgets().containsKey(klass)){
			List<IWidgetPresenter>  widgets = getClassVsWidgets().get(klass);
			widgets.add(widget);
		}
		else{			
			getClassVsWidgets().put(klass, new ArrayList<IWidgetPresenter>(Arrays.asList(widget)));	
		}
	}

	private Map<IWidgetPresenter, Class<?>> getWidgetVsClass() {
		return classVsWidget;
	}

	@Override
	public Class<?> getWidgetClass(IWidgetPresenter widget) {
		// TODO Auto-generated method stub
		return getWidgetVsClass().get(widget);
	}

	@Override
	public List<IWidgetPresenter> getAllWidgets() {
		// TODO Auto-generated method stub
		return new ArrayList<IWidgetPresenter>(getWidgetVsClass().keySet());

	}

	@Override
	public List<IWidgetPresenter> getAllWidgetsForClass(Class<?> klass) {
		// TODO Auto-generated method stub
		return  getClassVsWidgets().get(klass);
	}

}