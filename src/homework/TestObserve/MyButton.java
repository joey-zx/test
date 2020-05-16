package homework.TestObserve;

import java.util.ArrayList;
import java.util.List;

public class MyButton {

    private List<myActionListener> actionListenerList = new ArrayList<>();

    public void addActionListener(myActionListener listener) {
        actionListenerList.add(listener);
    }

    public void onClick() {
        for (myActionListener myActionListener : actionListenerList) {
            myActionListener.ActionExectute(new myActionEvent(1));
        }
    }

}

class KeyBroad implements myActionListener {
    @Override
    public void ActionExectute(myActionEvent event) {
        if(event.getClickTime() == 1){
            System.out.println("click one time");
        } else {
            System.out.println("click two time");
        }
    }
}





