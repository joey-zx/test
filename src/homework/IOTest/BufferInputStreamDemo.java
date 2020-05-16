package homework.IOTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\a.txt"));

        int len;
        byte[] bs = new byte[1024];
        while((len = bufferedInputStream.read(bs)) != -1) {
            System.out.println(new String(bs,0,len));
        }
    }
}
