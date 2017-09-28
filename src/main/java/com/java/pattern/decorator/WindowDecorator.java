package com.java.pattern.decorator;
import com.java.pattern.decorator.Window;

/**
 * 提供了装饰者的框架
 * @author duanyaochang
 *
 */
public abstract class WindowDecorator implements Window {
	
	protected Window windowToBeDecorated;
	
	public WindowDecorator (Window windowToBeDecorated) {
        this.windowToBeDecorated = windowToBeDecorated;
    }

	@Override
	public void draw() {
		windowToBeDecorated.draw();
	}

	@Override
	public String getDescription() {
		return windowToBeDecorated.getDescription();
	}

}
