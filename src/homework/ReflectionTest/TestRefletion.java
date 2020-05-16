package homework.ReflectionTest;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class TestRefletion {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Person person = new Person("Amy");
        person.setAge(15);

        Person p2 = (Person) clone(person);
        System.out.println(p2);
    }

    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person("Amy");
        person.setAge(15);

        Person p2 = (Person) clone(person);
        System.out.println(p2);
    }

    @Test
    public void testFlection() {
        Class<String> clz = String.class;

        Class[] is = clz.getInterfaces();

        for (Class i : is) {
            System.out.println(i);
        }
    }


    public static Object clone(Object o) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Object> clz = (Class<Object>) o.getClass();
        //Object o1 = clz.newInstance();

        Constructor<Object>[] cs = (Constructor<Object>[]) clz.getDeclaredConstructors();

        Constructor<Object> constructor = cs[0];

        Class[] cc = constructor.getParameterTypes();

        Object[] oo = new Object[cc.length];

        for (int i = 0; i < cc.length; i++) {

            if(cc[i].isPrimitive()){
                if(cc[i] == boolean.class) {
                    oo[i] = false;
                } else if(cc[i] == char.class) {
                    oo[i] = '\u0000';
                } else {
                    oo[i] = 0;
                }
            } else {
                oo[i] = null;
            }
        }

        constructor.setAccessible(true);

        Object o1 = constructor.newInstance(oo);

        Field[] fs = clz.getDeclaredFields();

        for (Field f : fs) {

            if((f.getModifiers() & Modifier.FINAL)!= 0 ) {
                continue;
            }

            f.setAccessible(true);
            Object value = f.get(o);
            f.set(o1,value);
        }

        return o1;
    }
}


class Person implements Serializable {

    private static final long serialVersionUID = -6510644632472010982L;
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
