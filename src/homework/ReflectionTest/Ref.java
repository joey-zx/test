package homework.ReflectionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ref {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Teacher> clz = Teacher.class;
        Object object = clz.newInstance();
        Method mm =clz.getMethod("teach");
        Object oo = mm.invoke(object);
        Method m2 = clz.getMethod("teach",String.class);
        m2.setAccessible(true);
        Object ooo = m2.invoke(object, "2020-4-23");
        System.out.println(ooo);
    }
}


class Teacher {
    public void teach() {
        System.out.println("Teach");
    }

    public void teach(String time) {
        System.out.println( time + "teach");
    }
}