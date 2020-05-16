package StringDemo;

import java.util.Stack;

public class MyAr {
    public static void main(String argv[]) {
        IA ia = new myClass();
        System.out.println(ia);



    }
}

class myClass implements IA {

    @Override
    public void m1() {

    }

    @Override
    public String toString() {
        return "MyClass";
    }
}



