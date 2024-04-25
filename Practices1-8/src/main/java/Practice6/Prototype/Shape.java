package Practice6.Prototype;

import lombok.Getter;

@Getter
public abstract class Shape {
    protected final double x;
    protected final double y;
    protected final String color;

    protected Shape(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    } 
    
    protected Shape(Shape shape) {
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    @Override
    public abstract Shape clone();
    @Override
    public abstract String toString();
}
