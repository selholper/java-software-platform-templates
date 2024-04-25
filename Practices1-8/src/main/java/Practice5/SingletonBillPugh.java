package Practice5;

// Синглтон с использованием статического класса
public class SingletonBillPugh {
    private SingletonBillPugh() {
    }

    private static class Singleton {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static synchronized SingletonBillPugh getInstance() {
        return Singleton.INSTANCE;
    }
}
