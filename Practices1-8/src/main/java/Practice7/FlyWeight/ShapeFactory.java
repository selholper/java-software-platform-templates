package Practice7.FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Shape> SHAPES_STATE = new HashMap<>();

    public static Shape getShape(String color) {
        SHAPES_STATE.putIfAbsent(color, new Shape(color));
        return SHAPES_STATE.get(color);
    }
}
