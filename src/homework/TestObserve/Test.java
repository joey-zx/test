package homework.TestObserve;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Button button = new Button(1);
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListener2());
        button.buttonPress();
    }
}


class Button {

    private int buttonId;

    public Button(int buttonId) {
        this.buttonId = buttonId;
    }

    private List<ActionListener> actionListeners = new ArrayList<>();

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    public void buttonPress() {

        ActionEvent actionEvent = new ActionEvent(System.currentTimeMillis(),this);

        for (ActionListener actionListener : actionListeners) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "buttonId=" + buttonId +
                '}';
    }
}


class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Button " +  event.getSource() + " press at " + new Date(event.getWhen()));
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Button press at 2 " + new Date(event.getWhen()));
    }
}


