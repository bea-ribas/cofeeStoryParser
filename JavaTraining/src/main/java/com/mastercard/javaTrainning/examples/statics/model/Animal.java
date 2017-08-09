package com.mastercard.javaTrainning.examples.statics.model;

public class Animal {
	
//	protected final String name = "Animal";
	
	public static void testClassMethod() {
		System.out.println("The static method in Animal");
	}
	
	//Try to put final here after show static and override!!! ;)
	public void testInstanceMethod() {
		System.out.println("The instance method in Animal");
	}
}