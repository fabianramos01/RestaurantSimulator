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
		principalFrame.add(panelRestaurant);
		principalFrame.revalidate();
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
}