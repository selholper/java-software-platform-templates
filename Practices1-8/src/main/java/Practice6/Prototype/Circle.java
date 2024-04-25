package Practice6.Prototype;

import lombok.Getter;

@Getter
public class Circle extends Shape {
    private final double radius;

    public Circle(double r, double x, double y, String color) {
        super(x, y, color);
        this.radius = r;
    }

    private Circle(Circle circle) {
        super(circle);
        this.radius = circle.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return String.format(
            "Circle={radius=%f, x=%f, y=%f, color=%s}",
            radius,
            x,
            y,
            color
        );
    }
}
