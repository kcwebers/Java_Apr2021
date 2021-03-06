package com.kw.coffeeoop.abstracts;
import com.kw.coffeeoop.interfaces.BevMaker9000;

public abstract class Coffee implements BevMaker9000 {
    public int brewingTempurature = 200;
    public Boolean isIced = false;
    public String roastType;
    
    public static int numberOfCoffees = 0;
    
    
    public void getBrewingTempurature() {
        System.out.println("This is a random method that is implemented in this class! I'm here to tell you that we brewed your coffee at 200 degrees!");
    }
    
    public static int getNumberOfCoffees() {
    	return numberOfCoffees;
    }
    
    // abstract method to be implemented by the class that extends upon this one!
    public abstract void pourIntoCup();
    
    
}
