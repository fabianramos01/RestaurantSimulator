package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private JPanel panelEat;

	public PanelRestaurant() {
		setLayout(new BorderLayout());
		panelCredits = new JPanel();
		loadCredits(null);
		add(panelCredits, BorderLayout.NORTH);
		panelLunch = new JPanel();
		loadLunch(null);
		add(panelLunch, BorderLayout.WEST);
		panelEat = new JPanel();
		add(panelEat, BorderLayout.CENTER);
	}

	public void loadCredits(ArrayList<Student> list) {
		panelCredits.removeAll();
		panelCredits.updateUI();
		panelCredits.setBorder(BorderFactory.createTitledBorder(ConstantList.CREDITS_QUEUE));
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(ConstantList.STAND_IMG));
		JLabel label = new JLabel(UtilityList.scaledImage(imageIcon, 100, 100));
		panelCredits.add(label);
		loadPanelList(panelCredits, UtilityList
				.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_CREDIT_IMG)), 100, 100), list);
		repaint();
	}

	public void loadLunch(ArrayList<Student> list) {
		panelLunch.removeAll();
		panelLunch.updateUI();
		panelLunch.setBorder(BorderFactory.createTitledBorder(ConstantList.LUNCH_QUEUE));
		if (list != null) {
			panelLunch.setLayout(new GridLayout(list.size(), 1));
			loadPanelList(panelLunch,
					UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)), 100, 100),
					list);
		}
		repaint();
	}
	
	public void loadEat(ArrayList<Student> list) {
		panelEat.removeAll();
		panelEat.updateUI();
		panelEat.setLayout(new GridLayout(15,15));
		for (Student student : list) {
			panelEat.add(UtilityList.createJLabel(student.toString(), ConstantList.WORD_FONT, Color.BLACK));
		}
		repaint();
	}

	private void loadPanelList(JPanel panel, ImageIcon image, ArrayList<Student> list) {
		if (list != null) {
			for (Student student : list) {
				JLabel label = new JLabel(image);
				label.setFont(ConstantList.WORD_FONT);
				label.setText(String.valueOf(student.getCode()));
				label.setHorizontalTextPosition(JLabel.CENTER);
				panel.add(label);
			}
		}
	}
}
