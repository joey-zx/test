package homework.TestObserve;

import java.io.IOException;
import java.util.*;

class Child implements Runnable{

    private List<WakeUpListener> wakeUpListeners = new ArrayList<>();

    public void addWakeUpListener(WakeUpListener listener) {
        wakeUpListeners.add(listener);
    }

    public void wakenUp() {
        for (WakeUpListener wakeUpListener : wakeUpListeners) {
            wakeUpListener.ActionToWakenUp(new WakeUpEvent(System.currentTimeMillis(),"Bed",this));
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.wakenUp();
    }
}


class Dad implements WakeUpListener{
    @Override
    public void ActionToWakenUp(WakeUpEvent event) {
        System.out.println("feed Child");
    }
}

class GrandFather implements WakeUpListener{
    @Override
    public void ActionToWakenUp(WakeUpEvent event) {
        System.out.println("Hug Child");
    }
}

public class TestObserver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Child child = new Child();

        Properties properties = PropMrg.getProperties();

        Iterator iterator = properties.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry prop = (Map.Entry) iterator.next();
            String classname = (String) prop.getValue();
            Class clz = Class.forName(classname);
            child.addWakeUpListener((WakeUpListener) clz.newInstance());
        }
        new Thread(child).start();
    }
}


class PropMrg {

    private static Properties properties = new Properties();

    private PropMrg() {

    }

    static {
        try {
            properties.load(TestObserver.class.getClassLoader().getResourceAsStream("Observe.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
