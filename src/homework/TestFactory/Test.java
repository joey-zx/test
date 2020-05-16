package homework.TestFactory;

public class Test {
    public static void main(String[] args) {
        /*PlaneFactory factory = new PlaneFactory();*/
        SimpleFactory simpleFactory = new PlaneFactory();
        Moveable m = simpleFactory.create();
        m.run();
    }
}
