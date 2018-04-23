package controller;

import javax.swing.ImageIcon;

public enum Command {

	COMMAND_PLAY("COMMAND_PLAY", "Iniciar", "/img/play.png"),
	COMMAND_ACCEPT("COMMAND_ACCEPT", "Aceptar", ""),
	COMMAND_STOP("COMMAND_STOP", "Detener", "/img/cancel.png"), 
	COMMAND_REPORT("COMMAND_REPORT", "Generar reporte", "/img/report.png"), 
	COMMAND_NEW_SIMULATION("COMMAND_NEW_SIMULATION", "Nueva simulación", "");
	
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