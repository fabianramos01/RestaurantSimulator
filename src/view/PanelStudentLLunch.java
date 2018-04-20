package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.ConstantList;
import model.Student;

public class PanelStudentLLunch extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelStudentLLunch() {
		setBorder(BorderFactory.createTitledBorder(ConstantList.EAT_QUEUE));
	}

	public void loadStudents(ArrayList<Student> list) {
		removeAll();
		setLayout(new GridLayout(15, 15));
		for (Student student : list) {
			add(UtilityList.createJLabel(student.toString(), ConstantList.WORD_FONT, Color.BLACK));
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		g.drawImage(new ImageIcon(getClass().getResource(ConstantList.BACKGROUND_IMG)).getImage(), 0, 0,
//				(int) getSize().getWidth(), (int) getSize().getHeight(), this);
	}
}