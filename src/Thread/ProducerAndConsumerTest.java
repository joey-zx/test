package Thread;

public class ProducerAndConsumerTest {

    public static void main(String[] args) {
        Basket basket = new Basket(5);

        new Thread(new Producer(basket),"Joey").start();
        new Thread(new Producer(basket),"David").start();
        new Thread(new Consumer(basket),"Mark").start();
        new Thread(new Consumer(basket),"Louis").start();

    }
}


class Basket {
    private WoTou[] WoTou;

    private int size;

    public Basket(int len) {
        this.WoTou = new WoTou[len];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public WoTou[] getWoTou() {
        return WoTou;
    }

    public void setWoTou(WoTou[] woTou) {
        WoTou = woTou;
    }
}

class Producer implements Runnable {

    private Basket wotous;

    public Producer(Basket wotous) {
        this.wotous = wotous;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (wotous) {
                    while (wotous.getSize() == wotous.getWoTou().length) {
                        wotous.wait();
                    }
                    WoTou woTou = new WoTou((int) (Math.random() * 100));
                    int size = wotous.getSize();
                    WoTou[] woTous = wotous.getWoTou();
                    woTous[size++] = woTou;
                    wotous.setSize(size);
                    System.out.println(Thread.currentThread().getName() + " 生产者生产了一个窝头 " + woTou.getId());
                    //Thread.sleep(200);
                    wotous.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {

    private Basket wotous;

    public Consumer(Basket wotous) {
        this.wotous = wotous;
    }

    @Override
    public void run() {
        synchronized (wotous) {
            while (true) {
                try {
                    while(wotous.getSize() == 0) {
                        wotous.wait();
                    }
                    int size = wotous.getSize();
                    WoTou woTou = wotous.getWoTou()[--size];
                    wotous.setSize(size);
                    System.out.println(Thread.currentThread().getName() + " 消费者消费了一个窝头 " + woTou.getId());
                    //Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wotous.notify();
            }
        }
    }
}