package com.java.pattern.adapter;

public class Adapter extends Target {
	
	private Adaptee adaptee;
	
	public int operation(){
		// 一般需要在调用被适配者的otherOperation之后做一些修改操作
		return adaptee.otherOperation() + 1;
	}

	public Adaptee getAdaptee() {
		return adaptee;
	}

	public void setAdaptee(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	

}
