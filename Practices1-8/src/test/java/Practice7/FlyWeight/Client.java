package Practice7.FlyWeight;

public class Client {

    public static void main(String[] args) {
        Shape redShape = ShapeFactory.getShape("red");
        Shape blueShape = ShapeFactory.getShape("blue");
        Shape redShapeCopy = ShapeFactory.getShape("red");

        System.out.println(redShape.color() + " " + blueShape.color() + " " + redShapeCopy.color());
        System.out.println(redShape == redShapeCopy);
    }
}
