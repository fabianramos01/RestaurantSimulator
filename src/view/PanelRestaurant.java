package view;

import java.awt.BorderLayout;
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
	private JPanel panelReturn;
	private PanelStudentLunch paEsLunch;
	private ImageIcon imageStandScaled;
	private ImageIcon imageStudentCScaled;
	private ImageIcon imageStudentLScaled;
	private ImageIcon imageRestaurantLScaled;

	public PanelRestaurant() {
		imageStandScaled = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STAND_IMG)), 100,
				100);
		imageStudentCScaled = UtilityList
				.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_CREDIT_IMG)), 100, 100);
		setLayout(new BorderLayout());
		imageStudentLScaled = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)),
				100, 100);
		imageRestaurantLScaled = UtilityList
				.scaledImage(new ImageIcon(getClass().getResource(ConstantList.RESTAURANT_IMG)), 100, 100);
		init();
	}
	
	private void init() {
		panelCredits = new JPanel(new BorderLayout());
		panelCredits.setBorder(BorderFactory.createTitledBorder(ConstantList.CREDITS_QUEUE));
		panelCredits.add(new JLabel(imageStandScaled), BorderLayout.WEST);
		add(panelCredits, BorderLayout.NORTH);
		panelLunch = new JPanel();
		panelLunch.setBorder(BorderFactory.createTitledBorder(ConstantList.LUNCH_QUEUE));
		panelLunch.add(new JLabel(imageRestaurantLScaled));
		add(panelLunch, BorderLayout.WEST);
		paEsLunch = new PanelStudentLunch();
		add(paEsLunch, BorderLayout.CENTER);
		panelReturn = new JPanel();
		add(panelReturn, BorderLayout.EAST);
	}

	public void loadCredits(ArrayList<Student> list) {
		panelCredits.removeAll();
		panelCredits.setLayout(new BorderLayout());
		panelCredits.add(new JLabel(imageStandScaled), BorderLayout.WEST);
		JPanel panel = new JPanel(new GridLayout(1, list.size() + 1));
		loadPanelList(panel, imageStudentCScaled, list);
		panelCredits.add(panel, BorderLayout.CENTER);
		revalidate();
	}

	public void loadLunch(ArrayList<Student> list) {
		panelLunch.removeAll();
		panelLunch.setLayout(new BorderLayout());
		panelLunch.add(new JLabel(imageRestaurantLScaled), BorderLayout.NORTH);
		JPanel panel = new JPanel(new GridLayout(list.size() + 1, 1));
		loadPanelList(panel, imageStudentLScaled, list);
		panelLunch.add(panel, BorderLayout.CENTER);
		revalidate();
	}

	public void loadEat(ArrayList<Student> list) {
		paEsLunch.loadStudents(list);
		repaint();
	}
	
	public void loadReturn(ArrayList<Student> list) {
		panelReturn.removeAll();
		panelReturn.setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(list.size() + 1, 1));
		loadPanelList(panel, imageStudentLScaled, list);
		panelReturn.add(panel, BorderLayout.EAST);
		revalidate();
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
