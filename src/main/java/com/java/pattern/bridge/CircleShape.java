package com.java.pattern.bridge;

public class CircleShape extends Shape {

	private double x, y, radius;
    public CircleShape(final double x, final double y, final double radius, final Drawing drawing) {
        super(drawing);
        this.x = x;  this.y = y;  this.radius = radius;
    }

    // low-level i.e. Implementation specific
    public void draw() {
        drawing.drawCircle(x, y, radius);
    }
    // high-level i.e. Abstraction specific
    public void resizeByPercentage(final double pct) {
        radius *= (1.0 + pct/100.0);
    }

}
