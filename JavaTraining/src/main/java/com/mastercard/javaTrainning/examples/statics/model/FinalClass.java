package com.mastercard.javaTrainning.examples.statics.model;

public final class FinalClass {
	protected String parameter = "This is my paramete";
	
	public void setParameter(String parameter){
		this.parameter = parameter;
	}
	
	public String getParameter(){
		return this.parameter;
	}
	
	public int specialMethodWithInnerClass(){
		final class ASet{
			final int value1 = 2;
		}
		
		final class BSet{
			final int value1 = 3;
		}
		
		ASet a = new ASet();
		BSet b = new BSet();
		int value =  b.value1 - a.value1;
		return value;
	}
}
