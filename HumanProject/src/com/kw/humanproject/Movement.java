package com.kw.humanproject;

public interface Movement {

	abstract void waves();
	
	public default void walks() {
		System.out.println("The animal walks about the room");
	}
	
	
}
