package model;

public enum ItemName {
    SOUP("Soup"),
    BREAD("Bread"),
    MILK("Milk"),
    APPLES("Apples");

    private String value;

    ItemName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ItemName fromString(String text) {
        for (ItemName itemName : ItemName.values()) {
            if (itemName.value.equalsIgnoreCase(text)) {
                return itemName;
            }
        }
        return null;
    }
}
