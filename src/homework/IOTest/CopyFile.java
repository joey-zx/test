package homework.IOTest;

import java.io.*;

public class CopyFile {

    public void copyFile(File file) {
        File file1 = new File("D:\\b.txt");

        char[] cc = new char[5];

        try( FileReader fileReader = new FileReader(file);
             FileWriter FileWriter = new FileWriter(file1)) {
            int c;
            while((c = fileReader.read(cc)) != -1) {
                FileWriter.write(new String(cc,0,c));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile1(File file) {
        File file1 = new File("D:\\b.txt");

        byte[] bytes = new byte[1024];

        try(FileOutputStream outputStream = new FileOutputStream(file1);
            FileInputStream inputStream = new FileInputStream(file)) {

            int c;
            while((c = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        //new CopyFile().copyFile(new File("D:\\a.txt"));
        new CopyFile().copyFile1(new File("D:\\a.txt"));
    }
}
