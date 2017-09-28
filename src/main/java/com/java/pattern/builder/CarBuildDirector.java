package com.java.pattern.builder;

public class CarBuildDirector {
	
	private CarBuilder carBuilder;
	
	public CarBuildDirector(CarBuilder cb){
		carBuilder = cb;
	}
	
	public Car construct(){
		return carBuilder.setColor("white").setWheels(4).build();
	}

}
