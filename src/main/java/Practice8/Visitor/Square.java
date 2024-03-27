package Practice8.Visitor;

public class Square implements Shape {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
