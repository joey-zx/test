package homework;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\a.txt");

        FileReader fileReader = new FileReader(file);

        StringBuilder stringBuilder = new StringBuilder();

        int i;
        String string = "";
        while((i = fileReader.read()) != -1) {
            stringBuilder.append(String.valueOf((char)i));
        }

        System.out.println(stringBuilder.toString().getBytes().length);
    }

}
