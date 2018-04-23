package view;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.Command;
import controller.ConstantList;

public class MenuBarSimulation extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private JMenu menuSimulation;

	public MenuBarSimulation(ActionListener listener) {
		menuSimulation = new JMenu(ConstantList.SIMULATION);
		menuSimulation.add(addJMenuItem(Command.COMMAND_NEW_SIMULATION, 'A', listener));
		add(menuSimulation);
	}

	private JMenuItem addJMenuItem(Command commandApp, Character keyStroke, ActionListener controller) {
		JMenuItem menuItem = new JMenuItem(commandApp.getTitle());
		menuItem.addActionListener(controller);
		menuItem.setActionCommand(commandApp.getCommand());
		menuItem.setAccelerator(
				KeyStroke.getKeyStroke(keyStroke, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		return menuItem;
	}
}
