package homework;

import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Field;

public class DeleteFile {

    private static int index;

    public static void deleteDierctory(String location) {
        File file = new File(location);

        if (file.isFile()) {
            file.delete();
            return;
        } else if(file.isDirectory() && file.listFiles().length > 0){
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteDierctory(file1.getPath());
            }
        }

        if(file.listFiles().length == 0) {
            file.delete();
        }

    }

    public static void printDiectory(String location,int layer) {

        File file = new File(location);

        if(file.isFile()) {
            System.out.println(getFormerStarts(layer) + file.getName());
            return;
        } else if(file.isDirectory() && file.listFiles().length > 0) {
            System.out.println(getFormerStarts(layer) + file.getName());
            File[] files = file.listFiles();
            for (File file1 : files) {
                printDiectory(file1.getPath(),layer + 1);
            }
        } else {
            System.out.println(getFormerStarts(layer) + file.getName());
        }
    }

    public static String getFormerStarts(int layer) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < layer; i++) {
            stringBuilder.append("    ");
        }

        return stringBuilder.toString();
    }

    public static void sumJavaFiles(String location) {
        File file = new File(location);

        if(file.isFile()) {
           if(file.getName().endsWith(".java")) {
               index ++;
           }
        } else if(file.isDirectory() && file.listFiles().length > 0) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                sumJavaFiles(file1.getPath());
            }
        }
    }

    public static void main(String[] args) {
        //deleteDierctory("D:\\a");
       /* File file = new File("D:\\a\\b\\c");
        file.delete();*/


        printDiectory("E:" +  File.separator + "code" + File.separator + "JavaSETesting",0);
        /*sumJavaFiles("D:\\a");
        System.out.println(index);

        File file = new File("D:/a.txt");

        System.out.println(file.getAbsolutePath());

        if(file.isFile()) {
            System.out.println("true");
        }


      /*  File file = new File("D:" + File.separator + "code","abc");
        System.out.println(file);*/

    }
}
