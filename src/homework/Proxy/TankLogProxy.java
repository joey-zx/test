package homework.Proxy;


//静态代理
public class TankLogProxy implements Moveable{

    private Moveable t;

    public TankLogProxy(Moveable t) {
        this.t = t;
    }

    @Override
    public void move() {
        System.out.println("Starting....");
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("Stoping....");
    }
}
