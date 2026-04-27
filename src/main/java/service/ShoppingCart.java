package service;
import model.*;
import model.constants.*;

public class ShoppingCart {
    private Food[] shoppingCart;
    private double priceWhithoutDiscount;
    private double priceWhithDiscount;
    private double priceWhithoutDiscountForVegetarianFood;


    public ShoppingCart(Food[] shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public static double getDiscount(Food food) {
        return (food.getAmount() * food.getPrice()) / Discount.PERCENT_100 * food.getDiscount();
    }

    public double getPriceWhithoutDiscount() {
        for (Food food : shoppingCart) {
            priceWhithoutDiscount = priceWhithoutDiscount + (food.getPrice() * food.getAmount());
        }
        return priceWhithoutDiscount;
    }

    public double getPriceWhithDiscount() {
        for (Food food : shoppingCart) {
            if (food.getVegetarian()) {
                if (food.getDiscount() > 0) {
                    priceWhithDiscount = priceWhithDiscount + ((food.getPrice() * food.getAmount()) - ShoppingCart.getDiscount(food));
                } else {
                    priceWhithDiscount = priceWhithDiscount + (food.getPrice() * food.getAmount());
                }
            } else {
                priceWhithDiscount = priceWhithDiscount + (food.getPrice() * food.getAmount());
            }
        }
        return priceWhithDiscount;
    }

    public double getPriceWhithoutDiscountForVegetarianFood() {
        for (Food food : shoppingCart) {
            if (food.getVegetarian()) {
                if (food.getDiscount() == 0) {
                    priceWhithoutDiscountForVegetarianFood = priceWhithoutDiscountForVegetarianFood + (food.getPrice() * food.getAmount());
                }
            }
        }
        return priceWhithoutDiscountForVegetarianFood;
    }
}
