package Practice6.Prototype;

import lombok.Getter;

@Getter
public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height, double x, double y, String color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }
    
    private Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public String toString() {
        return String.format(
            "Rectangle={width=%f, height=%f, x=%f, y=%f, color=%s}",
            width,
            height,
            x,
            y,
            color
        );
    }
}
