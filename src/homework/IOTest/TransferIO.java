package homework.IOTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class TransferIO {

    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\b.txt");
        OutputStreamWriter ow = new OutputStreamWriter(fileOutputStream,"utf-8");
        ow.write("中国心");
        ow.close();
    }
}
