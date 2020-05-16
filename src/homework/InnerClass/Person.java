package homework.InnerClass;

public class Person {

    public void say() {
        System.out.println("Say..");
    }

    public void eat() {
        class Cooker {
            public void cook() {
                System.out.println("Cook");
            }
        }

        Cooker cooker = new Cooker();
        cooker.cook();
        System.out.println("Eat..");
    }
}
