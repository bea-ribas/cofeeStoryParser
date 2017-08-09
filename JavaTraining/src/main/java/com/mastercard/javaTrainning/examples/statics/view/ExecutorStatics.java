package com.mastercard.javaTrainning.examples.statics.view;

import com.mastercard.javaTrainning.examples.statics.control.FrequencyController;
import com.mastercard.javaTrainning.examples.statics.model.Animal;
import com.mastercard.javaTrainning.examples.statics.model.Cat;
import com.mastercard.javaTrainning.examples.statics.model.Employee;

public class ExecutorStatics {

	static FrequencyController fc = new FrequencyController();
	
	public static void employeeFrequencyController(){
		Employee employee = new Employee();
		employee.setName("Chesterton");
		Employee employee2 = new Employee();
		employee2.setName("Chuck Norris");
		employee2.setLeaves(2);
		fc.addEmployee(employee);
		
		/*        See here the static variable usage        */
		//----------------------------------------------------
		Employee.frequency = 5;
		//----------------------------------------------------
		
		System.out.println("Name:" + employee.getName());
		System.out.println("Freq:"+ employee.frequency);
		System.out.println("Leaves:" + employee.getLeaves());
		System.out.println("Name:" + employee2.getName());
		System.out.println("Freq:"+ employee2.frequency);
		System.out.println("Leaves:" + employee2.getLeaves());
	}
	
	public static void animalInheritanceExecutor(){
		Cat myCat = new Cat();
		Animal myAnimal = myCat;
		Animal.testClassMethod(); //hidded method
		myAnimal.testInstanceMethod(); //overrided method
	}
	
	
	public static void main(String[] args) {
		System.out.println("Employee example\n-------------------------\n");
		ExecutorStatics.employeeFrequencyController();
		System.out.println("\nAnimal inheritance example\n---------------------------\n");
		ExecutorStatics.animalInheritanceExecutor();
	}
}