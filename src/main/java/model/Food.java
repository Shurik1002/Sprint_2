package model;

public abstract class Food implements Discountable{

    protected int amount;
    protected double price;
    protected boolean isVegetarian;

    protected Food(int amount, double price, boolean isVegetarian) {
        this.amount = amount;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    public boolean getVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

}
