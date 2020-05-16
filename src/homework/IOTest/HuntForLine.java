package homework.IOTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuntForLine {

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String string =  "";
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }

        bufferedReader.close();
    }
}
