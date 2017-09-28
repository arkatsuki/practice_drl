package com.java.pattern.bridge;

/**
 * 抽象和具体分离
 * Shape、CircleShape属于抽象，Drawing相关的是具体，两者通过组合的方式耦合
 *
 */
public abstract class Shape {
	
	protected Drawing drawing;

    protected Shape(final Drawing drawing){
        this.drawing = drawing;
    }

    public abstract void draw();                                 // low-level
    public abstract void resizeByPercentage(final double pct);   // high-level

}
