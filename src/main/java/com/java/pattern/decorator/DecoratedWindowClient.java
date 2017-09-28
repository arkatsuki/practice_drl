package com.java.pattern.decorator;

public class DecoratedWindowClient {
	
	public static void main(String[] args){
		Window decoratedWindow = new HorizontalScrollBarDecorator (new VerticalScrollBarDecorator (new SimpleWindow()));
		decoratedWindow.draw();
		System.out.println(decoratedWindow.getDescription());
	}

}
