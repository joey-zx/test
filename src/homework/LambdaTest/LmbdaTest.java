package homework.LambdaTest;

public class LmbdaTest {

    public static void main(String[] args) {
       /* Calculate calculate =  (d) -> {
            return Math.sqrt(d);
        };
        System.out.println(calculate.calulate(81));*/

    /*    Calculate calculate =  d -> Math.sqrt(d);

        System.out.println(calculate.calulate(81));*/

        /*Calculate calculate = System.out::println;

        calculate.calulate("123");*/

        Calculate cc = Person::new;

        cc.create("Joey");

        //System.out.println(person);

    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
