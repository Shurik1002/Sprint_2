package model;
import model.constants.*;


public class Meat extends Food{

    public Meat(int amount, double price) {
        super(amount, price);
        super.isVegetarian = false;
    }

    @Override
    public double getDiscount() {
        return Discount.DISCOUNT_0;
    }
}
