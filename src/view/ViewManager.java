package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Command;
import controller.ConstantList;
import controller.Controller;
import model.RestaurantManager;
import model.Student;

public class ViewManager {

	private PrincipalFrame principalFrame;
	private PanelRestaurant panelRestaurant;
	private DialogInformation diInformation;
	private JLabel labelTime;

	public ViewManager(Controller controller) {
		diInformation = new DialogInformation(controller);
	}

	public void loadFrame(Controller controller) {
		diInformation.setVisible(false);
		principalFrame = new PrincipalFrame();
		panelRestaurant = new PanelRestaurant();
		principalFrame.add(panelRestaurant, BorderLayout.CENTER);
		principalFrame.setJMenuBar(new MenuBarSimulation(controller));
		panelTime(controller);
		principalFrame.revalidate();
	}
	
	public void newSimulation() {
		diInformation.setVisible(true);
		principalFrame.setVisible(false);
	}

	private void panelTime(ActionListener listener) {
		JPanel panel = new JPanel();
		panel.add(UtilityList.createJButton(Command.COMMAND_PLAY.getCommand(), Command.COMMAND_PLAY.getTitle(),
				Command.COMMAND_PLAY.getImage(), listener));
		panel.add(UtilityList.createJButton(Command.COMMAND_STOP.getCommand(), Command.COMMAND_STOP.getTitle(),
				Command.COMMAND_STOP.getImage(), listener));
		panel.add(UtilityList.createJButton(Command.COMMAND_REPORT.getCommand(), Command.COMMAND_REPORT.getTitle(),
				Command.COMMAND_REPORT.getImage(), listener));
		panel.add(UtilityList.createJButton(Command.COMMAND_NEW_SIMULATION.getCommand(), Command.COMMAND_NEW_SIMULATION.getTitle(),
				Command.COMMAND_NEW_SIMULATION.getImage(), listener));
		labelTime = UtilityList.createJLabel(ConstantList.TIME + "0", ConstantList.WORD_FONT, Color.BLACK);
		panel.add(labelTime);
		principalFrame.add(panel, BorderLayout.SOUTH);
	}
	
	public void setTime(int time) {
		labelTime.setText(ConstantList.TIME + time + ConstantList.TIME_UNIT);
		principalFrame.revalidate();
	}
	
	public void loadReport(RestaurantManager manager) {
		new DialogReport(manager);
	}

	public void loadCreditList(ArrayList<Student> list) {
		panelRestaurant.loadCredits(list);
	}

	public void loadLunchList(ArrayList<Student> list) {
		panelRestaurant.loadLunch(list);
	}

	public void loadEatList(ArrayList<Student> list) {
		panelRestaurant.loadEat(list);
	}

	public void loadReturnList(ArrayList<Student> list) {
		panelRestaurant.loadReturn(list);
	}
	
	public int getPersonTime() {
		return diInformation.getPersonTime();
	}

	public int getCreditTime() {
		return diInformation.getCreditTime();
	}

	public int getLunchTime() {
		return diInformation.getLunchTime();
	}
}