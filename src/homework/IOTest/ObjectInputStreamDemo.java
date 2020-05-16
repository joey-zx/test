package homework.IOTest;

import homework.IOTest.Model.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\person.data"));

        Person person = (Person) in.readObject();

        System.out.println(person);

        in.close();
    }
}
