package homework.ListDem;

import com.sun.corba.se.impl.orbutil.ObjectStreamClass_1_3_1;
import com.sun.xml.internal.ws.encoding.ContentTypeImpl;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class ListTest {

    public static void main(String[] args) {

        /*Object[] objects = new String[]{"a","b","c"};

        String[] strings = (String[]) objects;

        for (String s : strings) {
            System.out.println(s);
        }*/

/*
        //泛型擦除引起的类型丢失
        List<String> c = new ArrayList<String>();
        List lists = new ArrayList();

        lists.add("123");
        lists.add(123);
        lists.add(new Object());
        lists.add(new ListTest());*/

//        lists.forEach(String -> System.out.println(String));



       /* c.add("gsfs");
        c.add("b14gsf");
        c.add("agsfs");
        c.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
            }
        });


        System.out.println(c);*/

        LinkedStackTmp<String> linkedStackTmp = new LinkedStackTmp<>();

        String[] strings = "I Love ZengXian".split(" ");

        for (String string : strings) {
            linkedStackTmp.push(string);
        }

        MyList myList = linkedStackTmp.getTop();

        String str = "";


        while ((str = linkedStackTmp.pop()) != null) {
            System.out.println(str +" ");
        }


    }
}
