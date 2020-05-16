package homework.ReflectionTest;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectionTest {

    public static Object clone(Object o) {
        Class<Object> clz = (Class<Object>) o.getClass();

        Constructor<Object>[] cc = (Constructor<Object>[]) clz.getDeclaredConstructors();

        Constructor c = cc[0];

        Class[] type = c.getParameterTypes();

        Object[] o1 = new Object[type.length];

        for (int i = 0; i <type.length ; i++) {
            if(type[i].isPrimitive()) {
                if(boolean.class == type[i]) {
                    o1[i] = false;
                } else if(char.class == type[i]) {
                    o1[i] = '\u0000';
                } else {
                    o1[i] = 0;
                }
            } else {
                o1[i] = null;
            }
        }

        Object ooo = null;
        try {
            ooo = c.newInstance(o1);

            Field[] fields = clz.getDeclaredFields();

            for (Field field : fields) {

                if((field.getModifiers() & Modifier.FINAL)!= 0 ) {
                    continue;
                }

                field.setAccessible(true);
                Object value = field.get(o);
                field.set(ooo,value);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return ooo;

    }
    public static void main(String[] args) {
        PersonClass person = new PersonClass("Joey",28);
        PersonClass personClass = (PersonClass) clone(person);
        System.out.println(personClass);
    }

}



class PersonClass{
    private String name;
    private int age;

    public PersonClass(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "PersonClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}