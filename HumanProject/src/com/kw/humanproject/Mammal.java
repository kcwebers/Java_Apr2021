package com.kw.humanproject;

public abstract class Mammal {
	
    private boolean sleeping = false;
    private boolean warmBlooded = true;
    private boolean hairy = true;
    
	abstract void movesForward();
    
    public void regulateTemperature() {
        System.out.println("My temperature is just right now.");
    }
    
    public void startSleeping() {
        sleeping = true;
        System.out.println("ZzZz");
    }
    
    public boolean isSleeping(){
        return sleeping;
    }
    
    // getters and setters
	public boolean isWarmBlooded() {
		return warmBlooded;
	}
	public void setWarmBlooded(boolean warmBlooded) {
		this.warmBlooded = warmBlooded;
	}
	public boolean isHairy() {
		return hairy;
	}
	public void setHairy(boolean hairy) {
		this.hairy = hairy;
	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
    
}

