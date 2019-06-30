package repository;

import model.ItemName;

import java.util.HashMap;
import java.util.Map;

import static model.ItemName.*;

public class PriceRepository {
    private Map<ItemName, Double> prices = new HashMap<ItemName, Double>() {{
        put(SOUP, 0.65);
        put(BREAD, 0.8);
        put(MILK, 1.30);
        put(APPLES, 1.00);
    }};

    public PriceRepository() {

    }

    public double getPrice(ItemName name) {
        return prices.get(name);
    }
}
