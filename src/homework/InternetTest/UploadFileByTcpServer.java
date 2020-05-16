package homework.InternetTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileByTcpServer {

    public static void receiveFileToSave(File file) {
        FileOutputStream fileOutputStream = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8089);
            Socket socket = ss.accept();
            fileOutputStream = new FileOutputStream(file);
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while((len = in.read(bytes)) != -1) {
                fileOutputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            System.out.println("上传成功");
            fileOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fileOutputStream = null;
                }
            }

            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    ss = null;
                }
            }
        }

    }

    public static void main(String[] args) {
        File file = new File("E:\\b.txt");
        receiveFileToSave(file);
    }
}
