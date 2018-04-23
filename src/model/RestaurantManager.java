package model;

import java.util.ArrayList;
import java.util.Stack;

import controller.ConstantList;

public class RestaurantManager {

	private MyQueue<Student> creditQueue;
	private MyQueue<Student> lunchQueue;
	private MyQueue<Student> returnQueue;
	private Stack<Tray> trayStack;
	private MyQueue<Student> eatList;
	private int credits;
	private int lunchCount;
	
	public RestaurantManager() {
		creditQueue = new MyQueue<>();
		lunchQueue = new MyQueue<>();
		returnQueue = new MyQueue<>();
		trayStack = new Stack<>();
		eatList = new MyQueue<>();
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
		Node<Student> student = creditQueue.dequeue();
		credits++;
		student.setNext(null);
		lunchQueue.enqueue(student);
	}
	
	public void addToReturn() {
		Node<Student> student = eatList.dequeue();
		student.setNext(null);
		returnQueue.enqueue(student);
	}
	
	public void addToEat() {
		Node<Student> student = lunchQueue.dequeue();
		student.setNext(null);
		eatList.enqueue(student);
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
		return eatList.getList();
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