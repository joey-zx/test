package homework.TestObserve;

public class ActionEvent {

    private long when;

    private Object source;

    public ActionEvent(long when,Object source) {
        this.when = when;
        this.source = source;
    }


    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public Object getSource() {
        return this.source;
    }
}
