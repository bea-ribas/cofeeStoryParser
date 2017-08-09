package com.mastercard.javaTrainning.examples.generics;

public class Vector <Blouwers>{
	private Blouwers[] element;
	private int size = 0;
	
	public Vector(int size) {
		element = (Blouwers[]) new Object[size];
		this.size = size;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public Blouwers getElement(int index){
		if((index >= 0 ) && (index < size)){
			return element[index];
		}
		else{
			return null;
		}
	}
	
	public void setElement(int index, Blouwers value){
		if((index >= 0 ) && (index < size)){
			element[index] = value;
		}
	}
	
	Vector<Blouwers> intersection(Vector<Blouwers> vector){
		int num = 0;
		Vector<Blouwers> inter;
		
		for(int i=0; i<this.size; i++){
			for(int j=0; j<vector.getSize(); j++){
				if(this.getElement(i).equals(vector.getElement(j))){
					num++;
					break;
				}
			}
		}
		
		inter = new Vector<Blouwers>(num);
		num = 0;
		
		for(int i=0; i<this.size; i++){
			for(int j=0; j<vector.getSize(); j++){
				if(this.getElement(i) == (vector.getElement(j))){
					inter.setElement(num, this.getElement(i));
					num++;
					break;
				}
			}
		}
		return inter;
	}
}
