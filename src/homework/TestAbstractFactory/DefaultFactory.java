package homework.TestAbstractFactory;


public class DefaultFactory extends AbstractFactory {

    @Override
    public Vihecle createVihecle() {
        return new Car();
    }

    @Override
    public Weapen createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }

}
