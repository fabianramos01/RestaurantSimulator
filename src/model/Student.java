 package model;

import java.util.Random;

public class Student {

	private int code;
	private boolean credit;
	private boolean eat;

	public Student() {
		Random random = new Random();
		code = random.nextInt(1000);
		credit = random.nextBoolean();
	}

	public boolean isCredit() {
		return credit;
	}

	public void addCredit() {
		credit = true;
	}

	public boolean isEat() {
		return eat;
	}

	public void setEat() {
		eat = true;
	}

	public int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return String.valueOf(code);
	}
}