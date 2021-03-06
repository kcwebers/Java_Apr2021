package com.kw.coffeeoop.classes;
import com.kw.coffeeoop.abstracts.Coffee;

public class IcedLatte extends Coffee {
    private int milkAmount = 30;
    private double cost = 4.5;
    private String[] ingredientList = {"Milk", "Espresso", "Ice"};
    
    public IcedLatte(String roastType) {
        this.isIced = true;
        this.roastType = roastType;
        numberOfCoffees ++;
    }
    
    
    public void addMilk() {
        System.out.println("We add some freshly frothed milk to make this a latte!");
    }
    
    public int getMilkAmount() {
		return milkAmount;
	}


	public void setMilkAmount(int milkAmount) {
		this.milkAmount = milkAmount;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String[] getIngredientList() {
		return ingredientList;
	}


	public void setIngredientList(String[] ingredientList) {
		this.ingredientList = ingredientList;
	}


	// let's implement our abstract method!
	public void pourIntoCup() {
	    System.out.println("Because this is iced, we can use any fancy cup we want!");
	}
        
    
    // let's also implement the methods from our interface!
    public String[] getIngredients(){
        return ingredientList;
    }
    
    

}
