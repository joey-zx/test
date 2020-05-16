package homework.InternetTest;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPThreadTest {

    public static void main(String[] args){
        Receive receive = new Receive();
        Sender sender = new Sender();
        new Thread(receive).start();
        new Thread(sender).start();
    }
}


class Receive implements Runnable {
    @Override
    public void run() {
        DatagramSocket ds = null;

        DatagramPacket dp = null;
        try {
            ds = new DatagramSocket(8082);
            dp = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                ds.receive(dp);
                int len = dp.getLength();
                String result = new String(dp.getData(), 0, len);
                System.out.println(result);

                if("end".equals(result)) {
                    System.out.println("你以下线");
                    break;
                }
                //Thread.sleep(500);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}

class Sender implements Runnable {
    @Override
    public void run() {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        Scanner scanner = new Scanner(System.in);
        InetSocketAddress iddr = new InetSocketAddress("localhost", 8082);
        try {
            ds = new DatagramSocket();
            while (true) {
                String string = scanner.next();
                dp = new DatagramPacket(string.getBytes(), string.getBytes().length, iddr);
                ds.send(dp);
                System.out.println("发送成功");
                if("end".equals(string)) {
                    System.out.println("您已下线");
                    break;
                }
                //Thread.sleep(500);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }

            if(scanner != null) {
                scanner.close();
            }
        }
    }
}