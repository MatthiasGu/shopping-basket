import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<String> items;

    public ShoppingBasket(List<String> items) {
        this.items = items;
    }

    public ShoppingBasket() {
        this.items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }
}
