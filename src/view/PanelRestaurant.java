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
	private PanelStudentLLunch paEsLunch;
	private ImageIcon imageStandScaled;
	private ImageIcon imageStudentCScaled;
	private ImageIcon imageStudentLScaled;

	public PanelRestaurant() {
		imageStandScaled = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STAND_IMG)), 100,
				100);
		imageStudentCScaled = UtilityList
				.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_CREDIT_IMG)), 100, 100);
		setLayout(new BorderLayout());
		imageStudentLScaled = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_IMG)),
				100, 100);
		panelCredits = new JPanel();
		panelCredits.setBorder(BorderFactory.createTitledBorder(ConstantList.CREDITS_QUEUE));
		add(panelCredits, BorderLayout.NORTH);
		panelLunch = new JPanel();
		panelLunch.setBorder(BorderFactory.createTitledBorder(ConstantList.LUNCH_QUEUE));
		add(panelLunch, BorderLayout.WEST);
		paEsLunch = new PanelStudentLLunch();
		add(paEsLunch, BorderLayout.CENTER);
	}

	public void loadCredits(ArrayList<Student> list) {
		panelCredits.removeAll();
		panelCredits.add(new JLabel(imageStandScaled));
		loadPanelList(panelCredits, imageStudentCScaled, list);
		revalidate();
	}

	public void loadLunch(ArrayList<Student> list) {
		panelLunch.removeAll();
		if (list != null) {
			panelLunch.setLayout(new GridLayout(list.size(), 1));
			loadPanelList(panelLunch, imageStudentLScaled, list);
		}
		revalidate();
	}

	public void loadEat(ArrayList<Student> list) {
		paEsLunch.loadStudents(list);
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
