package homework.IOTest;

import java.io.*;

public class WriteToFile {

    public void writeToFile(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            //写出数据
            //在写数据的时候，这个数据并不直接写到文件中而是先写到缓冲区中
            //当缓冲区满了之后，再将缓冲区中的数据写到文件中
            //在缓冲区没有满的时候，程序就已经结束了
            //结果导致数据死在了缓冲区中
            fileWriter.write("abc");

            //冲刷缓冲区
            //将数据从缓冲区冲到文件中

            //防止关流失败而没有冲刷导致数据丢失
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流
                //为了释放文件允许别的流操作当前文件
                //流一旦关闭，就不能重新开启
                //close之前，流自动进行一次flush操作以避免数据死在缓冲区
                //对象释放，回收内存
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                //如果关流失败，则将该流标记成为垃圾回收对象
                //如果关流成功，则将该流标记为垃圾回收对象释放内存
                fileWriter = null;
            }
        }
    }


    public void readFile(File file) {
        try(FileReader fileReader = new FileReader(file)){

            int i;

            while((i = fileReader.read()) != -1) {
                System.out.println((char)i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //new WriteToFile().writeToFile(new File("D:\\b.txt"));
        new WriteToFile().readFile(new File("D:" + File.separator + "b.txt"));
    }
}
