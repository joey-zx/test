package homework.InternetTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8081);

        byte[] bytes = new byte[1024];

        DatagramPacket dp = new DatagramPacket(bytes,1024);

        ds.receive(dp);

        int len = dp.getLength();

        System.out.println(new String(dp.getData(),0,len));
    }
}
