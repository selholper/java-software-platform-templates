package Practice8.Visitor;

public class NameGetter implements Visitor {
    @Override
    public void visit(Circle circle) {
        System.out.println(circle.getClass().getSimpleName());
    }

    @Override
    public void visit(Square square) {
        System.out.println(square.getClass().getSimpleName());
    }
}
