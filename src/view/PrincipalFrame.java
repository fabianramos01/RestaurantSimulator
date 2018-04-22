package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PrincipalFrame() {
		setTitle(ConstantList.TITLE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}