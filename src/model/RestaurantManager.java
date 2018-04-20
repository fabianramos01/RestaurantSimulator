package model;

import java.util.ArrayList;
import java.util.Stack;

import controller.ConstantList;

public class RestaurantManager {

	private MyQueue<Student> creditQueue;
	private MyQueue<Student> lunchQueue;
	private MyQueue<Student> returnQueue;
	private Stack<Tray> trayStack;
	private NodeList<Student> eatList;
	private int credits;
	private int lunchCount;
	
	public RestaurantManager() {
		creditQueue = new MyQueue<>();
		lunchQueue = new MyQueue<>();
		returnQueue = new MyQueue<>();
		trayStack = new Stack<>();
		eatList = new NodeList<>();
		addToTray();
	}
	
	public static Node<Student> newStudent() {
		return new Node<Student>(new Student()) ;
	}
	
	public void addPersonToSystem() {
		Node<Student> student = newStudent();
		if (student.getInfo().isCredit()) {
			lunchQueue.enqueue(student);
		} else {
			creditQueue.enqueue(student);
		}
	}
	
	public void buyCredit() {
		lunchQueue.enqueue(creditQueue.dequeue());
	}
	
	public void addToReturn() {
		returnQueue.enqueue(eatList.getFirst());
	}
	
	public void addToEat() {
		eatList.addFirst(lunchQueue.dequeue());
		lunchCount++;
	}
	
	public void addToTray() {
		for (int i = 0; i < ConstantList.TRAY_COUNT; i++) {
			trayStack.push(new Tray());
		}
	}
	
	public int studentLunch() {
		return eatList.size();
	}
	
	public ArrayList<Student> getLunchQueue() {
		return lunchQueue.getList();
	}

	public ArrayList<Student> getReturnQueue() {
		return returnQueue.getList();
	}

	public int getTrayStackSize() {
		return trayStack.size();
	}

	public ArrayList<Student> getEatList() {
		return eatList.getInfoList();
	}
	

	public int getCredits() {
		return credits;
	}

	public int getLunchCount() {
		return lunchCount;
	}

	public ArrayList<Student> getCreditQueue() {
		return creditQueue.getList();
	}
}