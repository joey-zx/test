package homework.FXX;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class AAAA {

}

public class psvm {

    List<String> mList = new ArrayList<>();

    public void onCreate() {
        mList.add("joey");

        try{
            Field field = getClass().getDeclaredField("mList");
            field.setAccessible(true);
            List list = (List)field.get(this);
            list.add(new AAAA());
        }  catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(mList);
    }

    public static void main(String[] args) {
        new psvm().onCreate();
    }
}
