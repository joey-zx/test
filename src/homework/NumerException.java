package homework;

public class NumerException extends  RuntimeException {
    private String messsage;

    public NumerException(String messsage) {
        this.messsage = messsage;
    }

    public String getMesssage() {
        return messsage;
    }
}
