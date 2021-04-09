package com.kw.coffeeoop.classes;
import com.kw.coffeeoop.abstracts.Coffee;

public class Americano extends Coffee {
    private int waterAmount = 50;
    private double cost = 3.5;
    private String[] ingredientList = {"Hot Water", "Coffee"};

    public void addHotWater() {
    	System.out.println("We add some hot water with our espresso to make this an americano!");
    }

    // let's implement our abstract method!
    public void pourIntoCup() {
    	System.out.println("Because this is a hot beverage, we will pour this into a mug!");
    }

    // let's also implement the methods from our interface!
    public String[] getIngredients(){
        return ingredientList;
    }
    
    
    public Americano(String roastType) {
    	this.roastType = roastType;
    	numberOfCoffees ++;
    }

	public int getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(int waterAmount) {
		this.waterAmount = waterAmount;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setIngredientList(String[] ingredientList) {
		this.ingredientList = ingredientList;
	}

	public double getCost() {
		return cost;
	}

	public String[] getIngredientList() {
		return ingredientList;
	}

    //GETTERS AND SETTERS HEREAFTER ========================================
    
    

}