package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.RestaurantManager;
import view.ViewManager;

public class Controller implements ActionListener {

	private ViewManager viewManager;
	private RestaurantManager restManager;
	private Timer timerCredit;

	public Controller() {
		viewManager = new ViewManager(this);
		restManager = new RestaurantManager();
		viewManager.loadRestaurantPanel();
		timeCredit();
		timerCredit.stop();
		timePerson();
	}

	private void timePerson() {
		Timer timer = new Timer(10000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restManager.addPersonToSystem();
				validateCreditTime();
				viewManager.loadCreditList(restManager.getCreditQueue());
				viewManager.loadLunchList(restManager.getLunchQueue());
			}
		});
		timer.start();
	}

	private void validateCreditTime() {
		if (!restManager.getCreditQueue().isEmpty()) {
			if (timerCredit.isRunning()) {
				restManager.buyCredit();
				viewManager.loadCreditList(restManager.getCreditQueue());
				viewManager.loadLunchList(restManager.getLunchQueue());
			} else {
				timeCredit();
				timerCredit.start();
			}
		} else {
			if (timerCredit != null) {
				timerCredit.stop();
			}
		}
	}

	private void timeCredit() {
		timerCredit = new Timer(7000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateCreditTime();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		switch (Command.valueOf(action.getActionCommand())) {
		case COMMAND_CANCEL:
			break;
		case COMMAND_PLAY:
			break;
		}
	}

}