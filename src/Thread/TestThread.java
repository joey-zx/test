package Thread;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestThread {

    public static void main(String[] args) throws IOException {

        Properties pp = new Properties();

        pp.load(new FileReader("Observe.properties"));

        Ticket ticket = new Ticket();

        ticket.setTicket(Integer.parseInt(pp.getProperty("ticket")));

        Thread t1 = new Thread(new Seller(ticket),"A");
        Thread t2 = new Thread(new Seller(ticket),"B");
        Thread t3 = new Thread(new Seller(ticket),"C");
        Thread t4 = new Thread(new Seller(ticket),"D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Seller implements Runnable {

    private Ticket ticket;

    public Seller(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
       while(ticket.getTicket() > 0) {
           String name = Thread.currentThread().getName();
           synchronized (ticket) {
               if(ticket.getTicket() > 0) {
                   ticket.setTicket(ticket.getTicket() - 1);
                   System.out.println(name + " 卖了一张票，还剩" + ticket.getTicket() + "张票");
               }
           }


       }
    }
}

class Ticket {

    private int ticket;

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
}
