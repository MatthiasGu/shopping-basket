import model.Item;
import model.ItemName;
import model.Offer;
import repository.OfferRepository;

import java.util.*;

public class ShoppingBasket {

    private Map<Item, Integer> items;

    // This is a replacement for a DB repository object that would query DB for offers.
    private OfferRepository offersRepository = new OfferRepository();

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

    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : items.keySet()) {
            subtotal += items.get(item) * item.getPrice();
        }
        System.out.printf("\nSubtotal: \u00A3%.2f\n", subtotal);
        return subtotal;
    }

    public double applyOffers() {
        double offerTotal = 0;
        for (Item item : items.keySet()) {
            offerTotal += checkOffers(item);
        }
        return offerTotal;
    }

    private double checkOffers(Item item) {
        double itemTotal = 0.0;
        ItemName itemName = item.getName();
        List<Offer> offersForItem = offersRepository.getOffersByItemName(itemName);
        int numberOfItemsInBasket = items.get(item);
        for (Offer offer : offersForItem) {
            ItemName requiredItem = offer.getRequiredItem();
            int numberOfQualifiedOffers = getQuantityByName(requiredItem) / offer.getRequiredQuantity();
            int timesToApply = Math.min(numberOfQualifiedOffers, numberOfItemsInBasket);
            itemTotal += offer.getOfferAmount() * timesToApply * item.getPrice();
            System.out.print("\n"+ offer.toString());
            System.out.printf(" -\u00A3%.2f\n", itemTotal);
        }
        return itemTotal;
    }

    private int getQuantityByName(ItemName itemName) {
        int quantity = 0;
        for (Item item : items.keySet()) {
            if (item.getName() == itemName) {
                quantity += items.get(item);
            }
        }
        return quantity;
    }
}
