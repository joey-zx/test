package homework.ExceptionExer;

import java.io.File;

public class ExceptionTestDemo {

    public static void main(String[] args){

        String path = "D:\\a.txt";

        try {
            String result = readTxtFile(path);
            System.out.println(result);
        } catch (PathNotExistException e) {
            System.out.println(e.getMessage());
        } catch (FileFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readTxtFile(String path) throws PathNotExistException, FileFormatException{
        if(!new File(path).exists()) {
            throw new PathNotExistException("Path is not exists, Please confirm again!");
        }

        int index = path.lastIndexOf('.');
        String suffix = path.substring(index + 1);

        if(!suffix.equals("txt")) {
            throw new FileFormatException("The File type " + suffix + " is not right");
        }

        return "Success to get";
    }
}
