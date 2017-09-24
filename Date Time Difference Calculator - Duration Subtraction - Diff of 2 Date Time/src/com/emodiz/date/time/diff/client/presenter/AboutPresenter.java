package com.emodiz.date.time.diff.client.presenter;

import com.emodiz.date.time.diff.client.api.IView;
import com.emodiz.date.time.diff.client.view.AboutView;

public class AboutPresenter extends AbstractPresenter {
	public interface IAboutView extends IView {

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
