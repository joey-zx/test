package homework.Strategy;

public class DisCountStrategy implements Discount{

    @Override
    public double cost(double cost) {
        return cost * 0.8;
    }
}
