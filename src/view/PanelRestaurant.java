package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
		loadCredits(null);
		add(panelCredits);
		panelLunch = new JPanel();
		loadLunch(null);
		add(panelLunch);
	}

	public void loadCredits(ArrayList<Student> list) {
		panelCredits.removeAll();
		panelCredits.updateUI();
		if (list != null) {
			panelCredits.setLayout(new GridLayout(list.size() + 1, 1));
		} else {
			panelCredits.setLayout(new GridLayout(1, 1));
		}
		panelCredits.setBorder(BorderFactory.createTitledBorder(ConstantList.CREDITS_QUEUE));
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(ConstantList.STAND_IMG));
		JLabel label = new JLabel(UtilityList.scaledImage(imageIcon, 100, 100));
		panelCredits.add(label);
		loadPanelList(panelCredits, list);
		repaint();
	}

	public void loadLunch(ArrayList<Student> list) {
		panelLunch.removeAll();
		panelLunch.updateUI();
		panelLunch.setBorder(BorderFactory.createTitledBorder(ConstantList.LUNCH_QUEUE));
		if (list != null) {
			panelLunch.setLayout(new GridLayout(list.size(), 1));
			loadPanelList(panelLunch, list);
			repaint();
		}
	}
	
	private void loadPanelList(JPanel panel, ArrayList<Student> list) {
		if (list != null) {
			ImageIcon imageIcon = UtilityList
					.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)), 100, 100);
			for (int i = 0; i < list.size(); i++) {
				JLabel label = new JLabel(imageIcon);
				label.setText(String.valueOf(list.get(i).getCode()));
				label.setHorizontalTextPosition(JLabel.CENTER);
				panel.add(label);
			}
		}
	}
}
