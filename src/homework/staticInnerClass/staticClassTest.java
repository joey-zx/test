package homework.staticInnerClass;

public class staticClassTest {

    public static void main(String[] args) {
        //A a = new A();
        A.B b = new A.B();
    }
}

class A {

    public A() {
        System.out.println("A loaded");
    }

    static class B {
        static{
            System.out.println("B loaded");
        }
    }
}
