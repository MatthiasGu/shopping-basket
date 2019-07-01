package model;

import repository.PriceRepository;

// Previously I had separate classes for each item, but it proved to be unnecessary.
public enum Item {
    SOUP("Soup"),
    BREAD("Bread"),
    MILK("Milk"),
    APPLES("Apples"),
    NOT_FOR_SALE("Not for sale");

    private String name;

    // This is a replacement for a DB repository object that would query DB for prices.
    private static PriceRepository priceRepository = new PriceRepository();

    Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Item fromString(String text) {
        for (Item item : Item.values()) {
            if (item.name.equalsIgnoreCase(text)) {
                return item;
            }
        }
        return NOT_FOR_SALE;
    }

    public static double getPrice(Item item) {
        return priceRepository.getPrice(item);
    }

}
