package view;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import controller.ConstantList;
import controller.Controller;

public class DialogInformation extends JDialog {

	private static final long serialVersionUID = 1L;
	private PanelInfo panelInfo;

	public DialogInformation(Controller controller) {
		setTitle(ConstantList.TITLE);
		panelInfo = new PanelInfo(controller);
		add(panelInfo);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_APP)).getImage());
		setSize(ConstantList.WIDTH_DIALOG, ConstantList.HEIGTH_DIALOG);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public int getPersonTime() {
		return panelInfo.getPersonTime();
	}
	
	public int getCreditTime() {
		return panelInfo.getCreditTime();
	}
	
	public int getLunchTime() {
		return panelInfo.getLunchTime();
	}
}