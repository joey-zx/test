package homework;

class Base implements aa {
    void test() {
        System.out.print("Base.test()");
        aa.add();
    }
}
class Child extends Base {
    void test() {
        System.out.print("Child.test()");
    }
    static public void main(String[] a) {
        Child anObj = new Child();
        Base baseObj = anObj;
        baseObj.test();
    }
}


interface  aa{
    public static void add() {
        System.out.println("sss");
    }
}