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

    public void addItem(Item item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}
