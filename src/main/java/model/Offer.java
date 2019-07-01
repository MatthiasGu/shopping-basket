package model;

import java.text.DecimalFormat;

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

    public String toString() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return offerItem.getValue() + " " + format.format((offerAmount * 100)) + "%" + " off:";
    }
}
