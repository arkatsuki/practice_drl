package com.java.pattern.singleton;

public class Singleton {
	
	private Singleton(){};
	
	private static class InnerHolder{
		public static final Singleton singleton = new Singleton();
	}
	
	public Singleton getSingleton(){
		return InnerHolder.singleton;
	}
	
}
