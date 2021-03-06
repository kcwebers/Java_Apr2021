package com.kw.coffeeoop.interfaces;

public interface BevMaker9000 {
    // constant that is public, static, and final
    // why static and final? Because ALL member variables/instance fields in an interface are static and final! This cannot be changed!
    // although this is the future pinnacle of technology, there are still limits! Maybe our BevMaker9000 can only handle making a single drink at a time... but man is it good..
    double maxNumberOfDrinks = 1.0;
    
    // default method that does not need implementation
    // this mean the sayHello() method doesn't require the class to define how the function with operate
    default void pourBeverage() {
        System.out.println("After preparing your drink, I'll pour it in a fancy glass and make it look pretty!");
    }
    
    // static method that does not need implementation
    // why? elements of a class/interface that are declared static belong to the CLASS and not the INSTANCES
    static void drinkStatus() {
        System.out.println("*flips cups in the air* Your drink is being made!");
    }
    
    // these last 2 methods will need to be implemented by the class that implements the interface
    public double getCost();
    public String[] getIngredients();

}
