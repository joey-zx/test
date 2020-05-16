package homework.TreeSet;

import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) throws ClassNotFoundException {

        /*TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });

        treeSet.add(new Person("joey",18));
        treeSet.add(new Person("david",19));
        treeSet.add(new Person("mark",20));*/

       /* TreeSet<Person> treeSet = new TreeSet<>();


        ParameterizedType pp = (ParameterizedType) treeSet;

        Type[] types = pp.getActualTypeArguments();

        System.out.println(types);*/

        /*treeSet.add(new Person("joey",18));
        treeSet.add(new Person("david",19));
        treeSet.add(new Person("mark",20));
*/
        /* System.out.println(treeSet);*/


        List<String> lists = new ArrayList<String>();
        lists.add("Joey");
        lists.add("David");
        lists.add("Mark");
        lists.add("Leon");

        Iterator<String> iterator = lists.iterator();

        try {
            while (iterator.hasNext()) {
                String string = iterator.next();
                if("Mark".equals(string))
                lists.remove(string);
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        System.out.println(lists);

    }

}
