package repository;

import model.Item;
import model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferRepository {
    private List<Offer> offers = new ArrayList<Offer>() {{
        add(new Offer(Item.APPLES, 1, Item.APPLES, 0.1));
        add(new Offer(Item.SOUP, 2, Item.BREAD, 0.5));
    }};

    public OfferRepository() {

    }

    public List<Offer> getOffersForItem(Item item) {
        List<Offer> returnedOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getOfferItem() == item) {
                returnedOffers.add(offer);
            }
        }
        return returnedOffers;

    }
}
