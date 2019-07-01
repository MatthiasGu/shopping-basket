package model;

import java.text.DecimalFormat;

public class Offer {

    private Item requiredItem;
    private int requiredQuantity;
    private Item offerItem;
    private double offerAmount;

    public Offer(Item requiredItem, int requiredQuantity, Item offerItem, double offerAmount) {
        this.requiredItem = requiredItem;
        this.requiredQuantity = requiredQuantity;
        this.offerItem = offerItem;
        this.offerAmount = offerAmount;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public Item getOfferItem() {
        return offerItem;
    }

    public double getOfferAmount() {
        return offerAmount;
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return offerItem.getName() + " " + format.format((offerAmount * 100)) + "%" + " off:";
    }
}
