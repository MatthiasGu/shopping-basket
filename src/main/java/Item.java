public abstract class Item {

    private ItemName name;

    public Item(ItemName name) {
        this.name = name;
    }

    public ItemName getName() {
        return name;
    }
}
