package homework.IOTest;

import java.io.*;

public class CopyAnything {
    public void copyFile(File file) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        File file1 = new File("E:\\david.jpg");

        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            byte[] bytes = new byte[100];

            int len;

            while((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new CopyAnything().copyFile(new File("D:\\joey.jpg"));
    }
}
