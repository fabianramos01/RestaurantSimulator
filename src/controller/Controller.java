package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
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

	public Controller() {
		restManager = new RestaurantManager();
		viewManager = new ViewManager(this);
	}
	
	private void init() {
		viewManager.loadFrame();
		timeCredit();
		timePerson();
		timeLunch();
	}

	private void timePerson() {
		Timer timer = new Timer(viewManager.getPersonTime()*1000, new ActionListener() {

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
		timerLunch = new Timer(viewManager.getLunchTime()*1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLunchTime();
			}
		});
	}
	
	private void timeCredit() {
		timerCredit = new Timer(viewManager.getCreditTime()*1000, new ActionListener() {

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
			init();
			break;
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider) e.getSource();
		System.out.println(slider.getValue());
	}

}