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
	private Timer timerLunch;

	public Controller() {
		restManager = new RestaurantManager();
		viewManager = new ViewManager(this);
		timeCredit();
		timePerson();
		timeLunch();
	}

	private void timePerson() {
		Timer timer = new Timer(10000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restManager.addPersonToSystem();
				validateCreditTime();
				validateLunchTime();
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
	
	private void validateLunchTime() {
		if (!restManager.getLunchQueue().isEmpty()) {
			if (timerLunch.isRunning()) {
				restManager.addToEat();
				viewManager.loadLunchList(restManager.getLunchQueue());
				viewManager.loadEatList(restManager.getEatList());
			} else {
				timeLunch();
				timerLunch.start();
			}
		} else {
			if (timerLunch != null) {
				timerLunch.stop();
			}
		}
	}

	private void timeLunch() {
		timerLunch = new Timer(11000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLunchTime();
			}
		});
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