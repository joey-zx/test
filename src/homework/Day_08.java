package homework;

public class Day_08 {


    static{
        System.out.println("Static 1");
    }

    static{
        System.out.println("Static 2");
    }

    static String s1 = "12313121";

    public static void change(Integer i) {
        short s = i.byteValue();



        System.out.println(s);
    }

    public static void main(String[] args) {
        /*Integer ii = 129;
        change(ii);
        System.out.println(ii);
        System.out.println(s1);*/

        Person1 person = new Person1();
        System.out.println(person);

    }

}

class Person {
    private static String name;
    private static int age;

    static{
        Person.name = "joey";
        Person.age = 18;
    }

    public String toString() {
        return name + ":" + age;
    }
}
