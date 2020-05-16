package homework.TestFactory;

public class PlaneFactory implements SimpleFactory {
    @Override
    public Moveable create() {
        return PlaneCreator.airPlane;
    }

    private static class PlaneCreator{
        private static AirPlane airPlane = new AirPlane();
    }
}
