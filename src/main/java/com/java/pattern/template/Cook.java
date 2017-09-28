package com.java.pattern.template;

public abstract class Cook {
	
	/**
	 * 操作步骤不能被重写，所以需要是final。具体每一步怎么做可以被重写
	 */
	public final void cookMeal(){
		operation1();
		operation2();
		operation3();
	}
	
	abstract void operation1();
	
	public void operation2(){
		
	}
	
	public void operation3(){
		
	}

}
