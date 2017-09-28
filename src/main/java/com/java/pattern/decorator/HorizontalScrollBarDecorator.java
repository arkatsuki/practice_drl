
package com.java.pattern.decorator;

/**
 * 能装饰别人也能继续被别人装饰
 * @author duanyaochang
 *
 */
public class HorizontalScrollBarDecorator extends WindowDecorator {
	public HorizontalScrollBarDecorator (Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontalScrollBar();
    }

    private void drawHorizontalScrollBar() {
        // Draw the horizontal scrollbar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including horizontal scrollbars";
    }

}
