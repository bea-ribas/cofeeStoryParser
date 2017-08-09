package com.mastercard.javaTrainning.examples.statics.model;

public class Employee {

	private String name;
	private int leaves;
	
	public static int frequency = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}
	
}
