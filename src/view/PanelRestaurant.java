package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;
import model.Student;

public class PanelRestaurant extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelCredits;
	private JPanel panelLunch;

	public PanelRestaurant() {
		setLayout(new GridLayout(1, 6));
		panelCredits = new JPanel();
		add(panelCredits);
		panelLunch = new JPanel();
		add(panelLunch);
	}

	public void loadCredits(ArrayList<Student> list) {
		panelCredits.removeAll();
		panelCredits.updateUI();
		panelCredits.setLayout(new GridLayout(list.size() + 1, 1));
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(ConstantList.STAND_IMG));
		JLabel label = new JLabel(UtilityList.scaledImage(imageIcon, 100, 100));
		panelCredits.add(label);
		imageIcon = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)), 100, 100);
		for (int i = 0; i < list.size(); i++) {
			label = new JLabel(imageIcon);
			label.setText(String.valueOf(list.get(i).getCode()));
			label.setHorizontalTextPosition(JLabel.CENTER);
			panelCredits.add(label);
		}
		repaint();
	}

	public void loadLunch(ArrayList<Student> list) {
		panelLunch.removeAll();
		panelLunch.updateUI();
		panelLunch.setLayout(new GridLayout(list.size(), 1));
		ImageIcon imageIcon = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)),
				100, 100);
		for (int i = 0; i < list.size(); i++) {
			JLabel label = new JLabel(imageIcon);
			label.setText(String.valueOf(list.get(i).getCode()));
			label.setHorizontalTextPosition(JLabel.CENTER);
			panelLunch.add(label);
		}
		repaint();
	}

}
