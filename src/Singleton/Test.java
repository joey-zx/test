package Singleton;

public class Test {
    public static void main(String[] args) {
        Singleton intance = Singleton.INSTANCE;
        intance.doSomething();
    }
}
