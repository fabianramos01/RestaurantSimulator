package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.RestaurantManager;
import view.ViewManager;

public class Controller implements ActionListener{

	private ViewManager viewManager;
	private RestaurantManager restManager;
	
	public Controller() {
		viewManager = new ViewManager(this);
		restManager = new RestaurantManager();
		viewManager.loadRestaurantPanel();
		init();
	}
	
	private void init() {
		Timer timer = new Timer(10000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restManager.addPersonToSystem();
				viewManager.loadCreditList(restManager.getCreditQueue());
				viewManager.loadLunchList(restManager.getLunchQueue());
			}
		});
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}