package homework.InnerClass;


public class Outer {

    private String oname;

    public void eat() {
        System.out.println("eat");
    }

    public void run(Inner inner) {
        inner.say();
    }

    class Inner {
        private final static String Iname = "zs";

        public Outer get() {
            return Outer.this;
        }

        public void say() {
            eat();
            System.out.println("Say" + oname);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
    }
}

class AA {
    public static void add() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer oo = inner.get();
        oo.eat();

    }
}
