package homework.InnerClass;


public class JtOuter {

    static class JjInner {

    }

    public static void main(String[] args) {
        JtOuter.JjInner j01 = new JjInner();
    }
}

class CC {
    public void add () {
        JtOuter.JjInner jjInner = new JtOuter.JjInner();
    }
}
