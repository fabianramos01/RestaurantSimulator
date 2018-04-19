package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PrincipalFrame() {
		setTitle(ConstantList.TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setLocationRelativeTo(null);
		setResizable(false);
	}
}