package homework.IOTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalculateWords {

    public void calculateWords(File file) {
        BufferedReader bufferedReader = null;
        BufferedWriter br = null;
        Map<String,Integer> words = new HashMap<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            br = new BufferedWriter(new FileWriter(new File("E:\\words.txt")));
            String str = "";
            while((str = bufferedReader.readLine()) != null) {
                String[] strs = str.split(" ");
                for (String s : strs) {
                    if(words.get(s) != null) {
                        words.put(s,words.get(s) + 1);
                    } else {
                        words.put(s,1);
                    }
                }
            }

            Set<String> ww = words.keySet();

            for (String string : ww) {
                br.write(string + " show times: " + words.get(string));
                br.newLine();
                br.flush();
            }
            //System.out.println(words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    bufferedReader = null;
                }
            }

            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    br = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        new CalculateWords().calculateWords(new File("D:\\word.txt"));
    }

}
