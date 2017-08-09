package com.mastercard.javaTrainning.examples.strings;

public class StringCoolMethods {

	public static void main(String[] args) {
		String str = "Java is best programming language";

		if (str.indexOf("Java") != -1) {
			System.out.println("String contains Java at index :" + str.indexOf("Java"));
		}

		if (str.matches("J.*")) {
			System.out.println("String Starts with J");
		}

		str = "Do you like Java ME or Java EE";

		if (str.lastIndexOf("Java") != -1) {
			System.out.println("String contains Java lastly at: " + str.lastIndexOf("Java"));
		}

		// this will return part of String str from index 0 to 12
		String subString = str.substring(0, 12);

		System.out.println("Substring: " + subString);

		// String formating
		System.out.println("Formating string...");
		String myString = "(//*[contains(%s,%s)])[%d]";
		for (int i = 0; i < 10; i++) {
			System.out.println(String.format(myString, "@id", "ui-select-" + (i + 1), i));
		}

	}
}
