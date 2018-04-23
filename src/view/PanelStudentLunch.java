package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;
import model.Student;

public class PanelStudentLunch extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageStudentEat;

	public PanelStudentLunch() {
		imageStudentEat = UtilityList
				.scaledImage(new ImageIcon(getClass().getResource(ConstantList.STUDENT_EAT_IMG)), 150, 150);
		setBorder(BorderFactory.createTitledBorder(ConstantList.EAT_QUEUE));
	}

	public void loadStudents(ArrayList<Student> list) {
		removeAll();
		setLayout(new GridLayout(5, 5));
		for (Student student : list) {
			JLabel label = new JLabel(imageStudentEat);
			label.setFont(ConstantList.WORD_FONT);
			label.setText(String.valueOf(student.getCode()));
			label.setHorizontalTextPosition(JLabel.CENTER);
			add(label);
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource(ConstantList.BACKGROUND_IMG)).getImage(), 0, 0,
				(int) getSize().getWidth(), (int) getSize().getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}