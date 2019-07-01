import model.Item;

public class Run {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if (args.length > 1) {
            ShoppingBasket basket = new ShoppingBasket();
            for (int i = 1; i < args.length; i++) {
                Item item = Item.fromString(args[i]);
                basket.addItem(item, 1);
            }
            basket.getTotal();
        } else {
            System.out.println("Please input a price basket!");
        }
    }
}
