package homework.Strategy;

public class Hall {

    Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void cost(double costMoney) {
        System.out.println(discount.cost(costMoney));
    }
}
