package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;
import model.RestaurantManager;

public class DialogReport extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialogReport(RestaurantManager manager) {
		setTitle(ConstantList.TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setSize(ConstantList.WIDTH_DIALOG_R, ConstantList.HEIGTH_DIALOG_R);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.add(UtilityList.createJLabel(ConstantList.REPORT, ConstantList.TITLE_FONT, Color.BLACK));
		panel.add(createLabel(UtilityList.createJLabel(ConstantList.MONEY + (manager.getCredits() * ConstantList.COST_CREDIT),
				ConstantList.WORD_FONT, Color.BLACK), manager));
		add(panel);
		setVisible(true);
	}

	private JLabel createLabel(JLabel label, RestaurantManager manager) {
		String info = "<html>" + ConstantList.MONEY + (manager.getCredits() * ConstantList.COST_CREDIT) + "<br>"
				+ ConstantList.STUDENT_ATTEND + manager.getLunchCount() + "<br>" + ConstantList.STUDENT_OUT
				+ manager.getReturnQueue().size() + "<br>" + ConstantList.STUDENT_QUEUE_LUNCH
				+ manager.getLunchQueue().size() + "<br>" + ConstantList.STUDENT_QUEUE_CREDIT
				+ manager.getReturnQueue().size();
		label.setText(info);
		return label;
	}

}