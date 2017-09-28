package com.java.pattern.abstract_factory_method;

public class ConcreteFactory1 implements Factory {

	@Override
	public ProductA createProductA() {
		return new ProductA1();
	}

	@Override
	public ProductB createProductB() {
		return new ProductB1();
	}

}
