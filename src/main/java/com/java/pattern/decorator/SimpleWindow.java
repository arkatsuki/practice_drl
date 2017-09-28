package com.java.pattern.decorator;

/**
 * 纯粹被装饰者，没有装饰功能
 * @author duanyaochang
 *
 */
public class SimpleWindow implements Window {

	@Override
	public void draw() {
		// draw some simple shape
	}

	@Override
	public String getDescription() {
		return "simple window";
	}

}
