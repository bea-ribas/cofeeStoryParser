package com.mastercard.javaTrainning.examples.statics.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mastercard.javaTrainning.examples.statics.model.Employee;

public class FrequencyController {
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void setFrequencyOfSomeEmployees(int i, int value){
		employees.get(i).frequency = value;
	}
	
	public int getFrequency(Employee e){
		return e.frequency;
	}
	
	public void addEmployee(Employee employee){
		employees.add(employee);
	}
	
	public boolean removeEmployee(Employee employee){
		return employees.remove(employee);
	}

	public Iterator<Employee> employeeIterator(){
		return employees.iterator();
	}
}
