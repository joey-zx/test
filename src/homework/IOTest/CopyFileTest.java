package homework.IOTest;

import java.io.*;

public class CopyFileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\b.txt");

        //File file1 = new File("E:\\b.txt");

       // FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] cs = new byte[1024];
        int i;
        while((i = fileInputStream.read(cs)) != -1 ) {
            System.out.println(new String(cs,0,i,"gbk"));
        }
    }
}
