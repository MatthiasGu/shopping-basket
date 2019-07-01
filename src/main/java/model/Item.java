package model;

import repository.PriceRepository;

public enum Item {
    SOUP("Soup"),
    BREAD("Bread"),
    MILK("Milk"),
    APPLES("Apples");

    private String name;
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
        return null;
    }

    public static double getPrice(Item item) {
        return priceRepository.getPrice(item);
    }

}
