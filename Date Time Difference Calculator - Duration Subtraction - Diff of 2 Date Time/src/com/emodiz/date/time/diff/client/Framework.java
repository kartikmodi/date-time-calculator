package com.emodiz.date.time.diff.client;

public class Framework {

	private Framework() {
		// TODO Auto-generated constructor stub
	}

	public static IWidgetRegistrar<?> getWidgetRegistrar() {
		return WidgetRegistrar.getInstance();
	}

	 
	public static IDataManager getDataManager(){
		return DataManager.getInstance();
		
	}
	
	public static  IDataValidator getDataValidator() {
		return DataValidator.getInstance();
		
	}
	
	public static IDurationCalculator getDurationCalculator() {
		return DurationCalculator.getInstance();
		
	}
}
