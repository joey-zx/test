package homework.TestFactory;

public class CarFactory implements SimpleFactory {
    @Override
    public Moveable create() {
        return CarCreator.car;
    }

    private static class CarCreator{
        private static Car car = new Car();
    }
}
