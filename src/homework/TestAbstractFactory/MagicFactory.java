package homework.TestAbstractFactory;

public class MagicFactory extends AbstractFactory {

    @Override
    public Vihecle createVihecle() {
        return new Broom();
    }

    @Override
    public Weapen createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food createFood() {
        return new MashRoom();
    }
}
