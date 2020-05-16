package homework.FruitExample;


import java.util.ArrayList;
import java.util.List;

public class FruitTest {

    public static void main(String[] args) {

        List<Fruit> fruitList = new ArrayList<Fruit>();

        fruitList.add(new Apple());
        fruitList.add(new Oriange());
        fruitList.add(new Fruit());

        List<Fruit> fruits = fruitList;



    }
}
