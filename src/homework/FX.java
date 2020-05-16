package homework;


class Fruit {}

class Apple extends Fruit {

}

class Jonathan extends  Apple {

}

class Orange extends Fruit {

}

public class FX {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}