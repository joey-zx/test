package homework.DynamicProxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject execute request()");
    }
}
