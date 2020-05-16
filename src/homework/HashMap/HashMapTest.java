package homework.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class HashMapTest {

    public static void calculateTheTime(String str) {

        Map<String,Integer> maps = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            String string = str.charAt(i) + "";

            if(maps.get(string) != null) {
                maps.put(string,maps.get(string) + 1);
            } else {
                maps.put(string,1);
            }
        }

        System.out.println(maps);
    }

    public static void main(String[] args) {
       /* String string = "11gsdsg151231aada31";
        calculateTheTime(string);*/

       /* HashMap<String,String> maps = new HashMap<>();
        maps.put("1","joey");
        maps.put("2","David");
        maps.put("3","Eason");*/

        Hashtable<String,String> table = new Hashtable<>();
        table.put("1",null);

        System.out.println(table);

        /*Set<Map.Entry<String, String>> lists = maps.entrySet();
        Iterator iterator = lists.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());

        }*/

    }

}
