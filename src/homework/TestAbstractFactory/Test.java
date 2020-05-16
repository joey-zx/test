package homework.TestAbstractFactory;

public class Test {
    public static void main(String[] args) {
        AbstractFactory factory = new MagicFactory();

        Vihecle vihecle = factory.createVihecle();
        Weapen weapen = factory.createWeapon();
        Food food = factory.createFood();

        vihecle.run();
        weapen.shoot();
        food.eat();

    }
}
