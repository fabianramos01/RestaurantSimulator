package view;

import java.util.ArrayList;

import controller.Controller;
import model.Student;

public class ViewManager {

	private PrincipalFrame principalFrame;
	private PanelRestaurant panelRestaurant;
	
	public ViewManager(Controller controller) {
		principalFrame = new PrincipalFrame();
		panelRestaurant = new PanelRestaurant();
	}
	
	public void loadRestaurantPanel() {
		principalFrame.add(panelRestaurant);
		principalFrame.repaint();
	}
	
	public void loadCreditList(ArrayList<Student> list) {
		panelRestaurant.loadCredits(list);
	}
	
	public void loadLunchList(ArrayList<Student> list) {
		panelRestaurant.loadLunch(list);
	}
}