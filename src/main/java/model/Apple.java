package model;
import model.constants.*;


public class Apple extends Food {
    public String color;

    public Apple(int amount, double price, String color) {
        super(amount, price);
        super.isVegetarian = true;
        this.color = color;
    }

    @Override
    public double getDiscount() {
        if (color.equals(Color.RED)) {
            return Discount.DISCOUNT_60;
        }
        return Discount.DISCOUNT_0;
    }
}
