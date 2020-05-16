package homework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.FileReader;
import java.io.IOException;

public class JunitTest {

    FileReader fileReader;

    @Before
    public void init() throws IOException {
        System.out.println("init ---- ");
        fileReader = new FileReader("D:\\a.txt");
    }

    @Test
    public void mm() throws IOException {

        int i = 0;
        char[] cs = new char[1024];
        while((i = fileReader.read(cs)) != -1) {
            String str = new String(cs,0,i);
            System.out.println(str);
        }
    }

    @After
    public void test() throws IOException {
        fileReader.close();
    }
}
