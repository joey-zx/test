package homework.ListDem;

import homework.Lambda.Add;

class A {
    public static <E> void swap(List<E> lists, int i, int j) {

    }
}

public class ArrayLisTest {

    public static void main(String[] args) {

        /*String[] arr = new String[]{"123","234"};

        List<String> lists = Arrays.asList(arr);

        lists.size();

        String string = lists.get(0);

        //lists.add("1234");

        System.out.println(lists.size());


        LinkedStack linkedStack = new LinkedStack();

        MyList myList = linkedStack.getTop();

        myList.end();*/


       /* ArrayLis arrayLis = new ArrayLis(1);
        arrayLis.add("f");
        arrayLis.add("b");
        arrayLis.add("s");
        arrayLis.add(0,"d");
        arrayLis.add("m");
        arrayLis.add("n");
        arrayLis.add("k");
        arrayLis.add("l");*/

        /*System.out.println(arrayLis);*/

      /*  LinkList list = new LinkList();

        list.set(0,"a");

        System.out.println(list);*/

        /*LinkedStack linkedStack = new LinkedStack();

        linkedStack.push("Zeng Xian");
        linkedStack.push("Love");
        linkedStack.push("I");

        while (!linkedStack.top.end()) {
            System.out.print(linkedStack.pop() + " ");
        }*/

      /*  LinkedStack linkedStack = new LinkedStack();

        String s = "";



        linkedStack.push("Zeng Xian");
        linkedStack.push("Love");
        linkedStack.push("I");


        while(!linkedStack.top.end()) {
            System.out.print(linkedStack.pop() + " ");
        }*/

       /* Stack<String> dataStack = new Stack<String>();


        MinStack miniStack = new MinStack();

        miniStack.push("12");
        miniStack.push("24");
        miniStack.push("36");


        System.out.println(miniStack);

        System.out.println(miniStack.getMinStack());

        miniStack.pop();
        System.out.println(miniStack);

        System.out.println(miniStack.getMinStack());*/


    /*   List<String> lists = new ArrayList<>();

       lists.add("Joey");
       lists.add("12412");

       lists.stream().forEach(System.out::println);*/

        /*lists.stream().forEach(System.out::println);*/

        /*List<Integer> listString;

        List<?> listss = lists;

        listString = (List<Integer>) listss;

        System.out.println(listString);*/


        List<String> al = new LinkedListTmp<>();
        al.add("Joey");
        al.add("David");

        Iterator<String> it = al.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
