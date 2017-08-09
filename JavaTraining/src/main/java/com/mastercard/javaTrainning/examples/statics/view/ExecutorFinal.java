package com.mastercard.javaTrainning.examples.statics.view;

import com.mastercard.javaTrainning.examples.statics.model.FinalClass;

public class ExecutorFinal {

	public static void main(String[] args) {
		FinalClass instance = new FinalClass();
		instance.setParameter("This");
		System.out.println(instance.getParameter());
		System.out.println("The difference is: " + instance.specialMethodWithInnerClass());
	}
}
