package model;

public class Tray {

	private static int id;
	
	public Tray() {
		++id;
	}
	
	public int getId() {
		return id;
	}
}
