package controller;

import javax.swing.ImageIcon;

public enum Command {

	COMMAND_PLAY("COMMAND_PLAY", "Iniciar", "/img/.png"),
	COMMAND_CANCEL("COMMAND_CANCEL", "Cancelar", "/img/.png");
	
	private String command;
	private String title;
	private String image;
	
	private Command(String command, String title, String image) {
		this.command = command;
		this.title = title;
		this.image = image;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ImageIcon getImage() {
		return new ImageIcon(getClass().getResource(image));
	}
}