package model;

public class Offer {

    private ItemName requiredItem;
    private int requiredQuantity;
    private ItemName offerItem;
    private double offerAmount;

    public Offer(ItemName requiredItem, int requiredQuantity, ItemName offerItem, double offerAmount) {
        this.requiredItem = requiredItem;
        this.requiredQuantity = requiredQuantity;
        this.offerItem = offerItem;
        this.offerAmount = offerAmount;
    }

    public ItemName getRequiredItem() {
        return requiredItem;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public ItemName getOfferItem() {
        return offerItem;
    }

    public double getOfferAmount() {
        return offerAmount;
    }
}
