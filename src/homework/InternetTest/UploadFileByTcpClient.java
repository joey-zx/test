package homework.InternetTest;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class UploadFileByTcpClient {

    public static void upload(File file) {
        FileInputStream fileInputStream = null;
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost",8089));
            OutputStream out = socket.getOutputStream();
            fileInputStream = new FileInputStream(file);

            byte[] bytes = new byte[1024];
            int len;

            while((len = fileInputStream.read(bytes)) != -1) {
                out.write(bytes);
            }
            socket.shutdownInput();
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
                } finally {
                    fileInputStream = null;
                }
            }

            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    socket = null;
                }
            }
        }

    }

    public static void main(String[] args) {
        File file = new File("D:\\a.txt");
        upload(file);
    }
}
