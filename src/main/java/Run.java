import model.ItemName;

public class Run {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if (args.length > 1) {
            ShoppingBasket basket = new ShoppingBasket();
            for (int i = 1; i < args.length; i++) {
                ItemName itemName = ItemName.fromString(args[i]);
                basket.addItemByName(itemName);
            }
            basket.getTotal();
        } else {
            System.out.println("Please input a price basket!");
        }
    }
}
