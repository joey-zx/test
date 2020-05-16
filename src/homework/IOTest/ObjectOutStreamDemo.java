package homework.IOTest;

import homework.IOTest.Model.Person;

import java.io.*;

public class ObjectOutStreamDemo {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Joey",28);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\person.data"));
        out.writeObject(person);
        out.close();
    }
}
