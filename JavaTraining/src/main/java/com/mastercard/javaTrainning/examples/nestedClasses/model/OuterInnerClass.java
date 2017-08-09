package com.mastercard.javaTrainning.examples.nestedClasses.model;

public class OuterInnerClass {
	
	private int value;

	public class InnerClass{
		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
