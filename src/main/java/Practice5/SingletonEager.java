package Practice5;


// Синглтон с нетерпеливой загрузкой
public class SingletonEager {
    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}
