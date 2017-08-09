package com.mastercard.javaTrainning.examples.nestedClasses.control;

import com.mastercard.javaTrainning.examples.nestedClasses.model.OuterClass;
import com.mastercard.javaTrainning.examples.nestedClasses.model.OuterInnerClass;
import com.mastercard.javaTrainning.examples.nestedClasses.model.OuterInnerClass.InnerClass;

public class Controller {
	public static void showValueStaticNestedClass(int value){
		OuterClass.StaticNestedClass.value = value;
		System.out.println("The value in static nested class is: " + OuterClass.StaticNestedClass.value);
	}
	
	public static void showValueInnerClass(int valueInner, int valueOuter){
		OuterInnerClass outer = new OuterInnerClass();
		outer.setValue(valueOuter);
		System.out.println("The value in outer inner class is: "+ outer.getValue());
		InnerClass inner = outer.new InnerClass();
		inner.setValue(valueInner);
		System.out.println("The value in inner class is: " + inner.getValue());
	}
}
