package homework.Strategy;

public class TestStrategy {
    public static void main(String[] args) {
        Hall hall = new Hall();
        hall.setDiscount(new DisCountStrategy());
        hall.cost(500);
    }
}
