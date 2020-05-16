package homework.IOTest;
import java.io.*;

public class ReadLineInJava {

    private static int sum = 0;

    public int readLine(File file) {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        int line = 0;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            line = 0;

            while (bufferedReader.readLine() != null) {
                line ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                bufferedReader = null;
                fileReader = null;
            }
        }
        return line;
    }


    public void countJavaCode(File file) {
        if(file.isFile()) {
            if(file.getName().endsWith(".java")) {
                sum += readLine(file);
            }

        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                countJavaCode(file1);
            }
        }
    }

    public static void main(String[] args) {
        new ReadLineInJava().countJavaCode(new File("D:\\joey.java"));
        System.out.println(sum);
    }

}
