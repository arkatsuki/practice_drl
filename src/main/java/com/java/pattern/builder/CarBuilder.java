package com.java.pattern.builder;

public interface CarBuilder {
	
	Car build();
	
	CarBuilder setColor(String color);
	
	CarBuilder setWheels(int wheels);

}
