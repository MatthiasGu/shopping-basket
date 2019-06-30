import model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private Map<Item, Integer> items;

    public ShoppingBasket(Map<Item, Integer> items) {
        this.items = items;
    }

    public ShoppingBasket() {
        this.items = new HashMap<>();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void addItem(Item item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}
