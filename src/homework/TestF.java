package homework;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storge;

    public FixedSizeStack (int size) {
        storge = new Object[size];
    }

    public void push(T item) {
        storge[index ++] = item;
    }

    public T pop() {
        return (T) storge[index --];
    }

}


public class TestF {

    public static final int SIZE = 5;

    public static void main(String[] args) {
        FixedSizeStack<String> fixedSizeStack = new FixedSizeStack<>(SIZE);

        for(String s : "A B C D".split(" ")) {
            fixedSizeStack.push(s);
        }

        for (int i = 0; i < SIZE; i++) {
            String s = fixedSizeStack.pop();
            System.out.println(s);
        }

       /* Class a1 = new ArrayList<Integer>().getClass();
        Class a2 = new ArrayList<String>().getClass();
        System.out.println(a1 == a2);


        List list = new ArrayList();

        list.add(1);
        list.add("s");

        List<?> list1 = new ArrayList<>();



        System.out.println(list);
        System.out.println(list1);*/




    }

}
