package homework.IOTest;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceStreamDemo {

    public static void main(String[] args) throws IOException {

        Vector<InputStream> vector = new Vector();

        FileInputStream t1 = new FileInputStream("D:\\a.txt");
        FileInputStream t2 = new FileInputStream("D:\\b.txt");
        FileInputStream t3 = new FileInputStream("D:\\c.txt");

        vector.add(t1);
        vector.add(t2);
        vector.add(t3);

        Enumeration<InputStream> ele = vector.elements();

        SequenceInputStream sis = new SequenceInputStream(ele);

        byte[] b = new byte[1024];
        int i;

        while ((i = sis.read(b)) != -1) {
            String s = new String(b, 0, i, "UTF-8");
            System.out.println(s);
        }

        sis.close();
    }

}
