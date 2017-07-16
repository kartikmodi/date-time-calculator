package com.emodiz.date.time.diff.client;

import java.util.List;

public interface IWidgetRegistrar<T> {

	public List<IWidgetPresenter> getAllWidgets();

	public void registerWidget(IWidgetPresenter widget, Class<?> klass);

	public Class<?> getWidgetClass(IWidgetPresenter widget);

	public List<IWidgetPresenter> getAllWidgetsForClass(Class<?> klass);

}
