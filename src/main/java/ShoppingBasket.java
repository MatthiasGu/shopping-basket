import model.*;
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
            subtotal += items.get(item) * Item.getPrice(item);
        }
        System.out.printf("\nSubtotal: \u00A3%.2f\n", subtotal);
        return subtotal;
    }

    public double applyOffers() {
        double offerTotal = 0;
        for (Item item : items.keySet()) {
            offerTotal += checkOffers(item);
        }
        if (offerTotal == 0) {
            System.out.println("No offers available.");
        }
        return offerTotal;
    }

    private double checkOffers(Item item) {
        double itemTotal = 0.0;
        List<Offer> offersForItem = offersRepository.getOffersForItem(item);
        int numberOfItemsInBasket = items.get(item);
        for (Offer offer : offersForItem) {
            Item requiredItem = offer.getRequiredItem();
            int numberOfQualifiedOffers = getQuantity(requiredItem) / offer.getRequiredQuantity();
            int timesToApply = Math.min(numberOfQualifiedOffers, numberOfItemsInBasket);
            itemTotal += offer.getOfferAmount() * timesToApply * Item.getPrice(item);
            if (itemTotal > 0) {
                System.out.print("\n" + offer.toString());
                System.out.printf(" -\u00A3%.2f\n", itemTotal);
            }
        }
        return itemTotal;
    }

    private int getQuantity(Item item) {
        return items.getOrDefault(item, 0);
    }

    public double getTotal() {
        double subtotal = getSubtotal();
        double offers = applyOffers();
        double total = subtotal - offers;
        System.out.printf("\nTotal price: \u00A3%.2f\n", total);
        return total;
    }
}
