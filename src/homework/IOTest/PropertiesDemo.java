package homework.IOTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("name","joey");
        properties.setProperty("age","28");

        properties.put("1123","4231");

        System.out.println(properties);

        FileOutputStream fileOutputStream = new FileOutputStream("ticket.txt");

        properties.store(fileOutputStream,"first Test");
    }
}
