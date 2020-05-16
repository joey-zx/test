package homework.Proxy;

public class Tank implements Moveable{

    @Override
    public void move() {
        System.out.println("Tank Moving");
        try {
            Thread.sleep((int)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
