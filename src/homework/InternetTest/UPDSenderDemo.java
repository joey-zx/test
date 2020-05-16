package homework.InternetTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UPDSenderDemo {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket("hello".getBytes(),"hello".getBytes().length,new InetSocketAddress("localhost",8081));
            ds.send(dp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds != null) {
                ds.close();
            }
        }
    }
}
