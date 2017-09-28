package com.java.pattern.builder;

public class CarBuilderImpl1 implements CarBuilder {
	
	private Car car;
	
	public CarBuilderImpl1(){
		car = new Car();
	}

	@Override
	public Car build() {
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public CarBuilder setColor(String color) {
		car.setColor(color);
		return this;
	}

	@Override
	public CarBuilder setWheels(int wheels) {
		car.setWheels(wheels);
		return this;
	}

}
