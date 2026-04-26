import model.Apple;
import model.Food;
import model.Meat;
import model.constants.Color;
import service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Food meat = new Meat(5, 100);
        Food redApple = new Apple(10, 50, Color.RED);
        Food greenApple = new Apple(8, 60, Color.GREEN);
        Food[] shoppingCart = {meat, redApple, greenApple};
        ShoppingCart cart = new ShoppingCart(shoppingCart);

        System.out.println("Общая сумма товаров без скидки: " + cart.getPriceWhithoutDiscount());
        System.out.println("Общая сумма товоров со скидкой: " + cart.getPriceWhithDiscount());
        System.out.println("Сумма всех вегетарианских товаров без скидки: " + cart.getPriceWhithoutDiscountForVegetarianFood());

    }
}
