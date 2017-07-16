package com.emodiz.date.time.diff.client;

public class AboutPresenter extends AbstractPresenter {
	interface IAboutView extends IView {

		public void setPresenter(AboutPresenter aboutPresenter);

	}
	private IAboutView display;
	
	public AboutPresenter() {
		// TODO Auto-generated constructor stub
		display = new AboutView();
		super.display = display;
		display.setPresenter(this);
		initlializeHandlers();
	}

	private void initlializeHandlers() {
		
	}
		
}
