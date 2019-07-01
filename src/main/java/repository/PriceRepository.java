package repository;

import model.Item;

import java.util.HashMap;
import java.util.Map;

import static model.Item.*;

public class PriceRepository {
    private Map<Item, Double> prices = new HashMap<Item, Double>() {{
        put(SOUP, 0.65);
        put(BREAD, 0.8);
        put(MILK, 1.30);
        put(APPLES, 1.00);
        put(NOT_FOR_SALE, 0.00);
    }};

    public PriceRepository() {

    }

    public double getPrice(Item item) {
        return prices.get(item);
    }
}
