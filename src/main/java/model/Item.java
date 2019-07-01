package model;

import repository.PriceRepository;

public abstract class Item {

    private ItemName name;
    private double price;

    // This is a replacement for a DB repository object that would query DB for prices.
    private PriceRepository priceRepository = new PriceRepository();

    public Item(ItemName name) {
        this.name = name;
        this.price = priceRepository.getPrice(name);
    }

    public ItemName getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}