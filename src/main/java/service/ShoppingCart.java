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
        for (int i = 0; i < shoppingCart.length; i++) {
            priceWhithoutDiscount = priceWhithoutDiscount + (shoppingCart[i].getPrice() * shoppingCart[i].getAmount());
        }
        return priceWhithoutDiscount;
    }

    public double getPriceWhithDiscount() {
        for (int i = 0; i < shoppingCart.length; i++) {
            if (shoppingCart[i].getVegetarian()) {
                if (shoppingCart[i].getDiscount() > 0) {
                    priceWhithDiscount = priceWhithDiscount + ((shoppingCart[i].getPrice() * shoppingCart[i].getAmount()) - ShoppingCart.getDiscount(shoppingCart[i]));
                } else {
                    priceWhithDiscount = priceWhithDiscount + (shoppingCart[i].getPrice() * shoppingCart[i].getAmount());
                }
            } else {
                priceWhithDiscount = priceWhithDiscount + (shoppingCart[i].getPrice() * shoppingCart[i].getAmount());
            }
        }
        return priceWhithDiscount;
    }

    public double getPriceWhithoutDiscountForVegetarianFood() {
        for (int i = 0; i < shoppingCart.length; i++) {
            if (shoppingCart[i].getVegetarian()) {
                if (shoppingCart[i].getDiscount() == 0) {
                    priceWhithoutDiscountForVegetarianFood = priceWhithoutDiscountForVegetarianFood + (shoppingCart[i].getPrice() * shoppingCart[i].getAmount());
                }
            }
        }
        return priceWhithoutDiscountForVegetarianFood;
    }
}
