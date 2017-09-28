package com.java.pattern.decorator;

/**
 * 能装饰别人也能继续被别人装饰
 * @author duanyaochang
 *
 */
public class VerticalScrollBarDecorator extends WindowDecorator {
	public VerticalScrollBarDecorator (Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }
	
	@Override
    public void draw() {
		// 在被装饰者前后添加一些动作
        super.draw();
        drawVerticalScrollBar();
    }

    private void drawVerticalScrollBar() {
        // Draw the vertical scrollbar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including vertical scrollbars";
    }

}
