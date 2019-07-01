package repository;

import model.ItemName;
import model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferRepository {
    private List<Offer> offers = new ArrayList<Offer>() {{
        add(new Offer(ItemName.APPLES, 1, ItemName.APPLES, 0.1));
    }};

    public OfferRepository() {

    }

    public List<Offer> getOffersByItemName(ItemName itemName) {
        List<Offer> returnedOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getOfferItem() == itemName) {
                returnedOffers.add(offer);
            }
        }
        return returnedOffers;

    }
}
