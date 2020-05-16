package homework.TestObserve;

public class TestMyButton {
    public static void main(String[] args) {
        MyButton myButton = new MyButton();
        myButton.addActionListener(new KeyBroad());
        myButton.onClick();
    }
}
