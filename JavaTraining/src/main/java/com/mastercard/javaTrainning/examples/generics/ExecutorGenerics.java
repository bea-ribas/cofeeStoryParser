package com.mastercard.javaTrainning.examples.generics;

public class ExecutorGenerics {
	public static void main(String[] args) {
		Vector<Integer> a = new Vector<Integer>(10);
		Vector<Integer> b = new Vector<Integer>(15);

		for (int i = 0; i < 10; i++) {
			a.setElement(i, (Integer) i);
			System.out.println("a[" + i + "] =" + a.getElement(i));
		}

		System.out.println();

		for (int i = 0; i < 15; i++) {
			b.setElement(i, i + 5); // Wrapping
			System.out.println("b[" + i + "] =" + b.getElement(i));
		}

		System.out.println();

		Vector<Integer> c = a.intersection(b);

		for (int i = 0; i < c.getSize(); i++) {
			System.out.print("c[" + i + "] = " + c.getElement(i) + " | ");
		}
		System.out.println();
	}
}
