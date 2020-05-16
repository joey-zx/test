package homework;

public class Day_07 {

    public static int add(int n) {
        if(n == 1) {
            return 1;
        } else {
            return n* add(n-1);
        }
    }

    public static void main(String[] args) {
        //System.out.println(add(5));
        Animal animal = new Animal("Joey");

    }
}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
        eat();
    }

    public void eat() {
        System.out.println("eating ...");
    }
}

