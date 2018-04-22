package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.RestaurantManager;
import view.ViewManager;

public class Controller implements ActionListener, ChangeListener {

	private ViewManager viewManager;
	private RestaurantManager restManager;
	private Timer timerCredit;
	private Timer timerLunch;
	private Timer timerPerson;
	private Timer timerSimulation;
	private double initTime;

	public Controller() {
		restManager = new RestaurantManager();
		viewManager = new ViewManager(this);
	}

	private void start() {
		timeCredit();
		timeLunch();
		timePerson();
		timeSystem();
		timerPerson.start();
		timerSimulation.start();
	}

	private void stop() {
		timerPerson.stop();
		timerCredit.stop();
		timerLunch.stop();
		timerSimulation.stop();
	}
	
	private void timeSystem() {
		timerSimulation = new Timer(ConstantList.MILLIS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManager.setTime((int)(System.currentTimeMillis() - initTime) / ConstantList.MILLIS);
			}
		});
	}

	private void timePerson() {
		timerPerson = new Timer(viewManager.getPersonTime() * ConstantList.MILLIS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restManager.addPersonToSystem();
				validateCreditTime();
				validateLunchTime();
			}
		});
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
		timerLunch = new Timer(viewManager.getLunchTime() * ConstantList.MILLIS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLunchTime();
			}
		});
	}

	private void timeCredit() {
		timerCredit = new Timer(viewManager.getCreditTime() * ConstantList.MILLIS, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateCreditTime();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		switch (Command.valueOf(action.getActionCommand())) {
		case COMMAND_STOP:
			stop();
			break;
		case COMMAND_PLAY:
			start();
			initTime = System.currentTimeMillis();
			break;
		case COMMAND_ACCEPT:
			viewManager.loadFrame(this);
			break;
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}

}