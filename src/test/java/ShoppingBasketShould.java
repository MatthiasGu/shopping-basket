
import model.Item;
import model.Soup;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingBasketShould {

    @Test
    public void beEmptyByDefault() {
        ShoppingBasket basket = new ShoppingBasket();
        Assert.assertTrue(basket.isEmpty());
    }

    @Test
    public void beAbleToAddItems() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        basket.addItem(soup);
        Assert.assertEquals(1, basket.getItems().size());
        Assert.assertTrue(basket.getItems().keySet().contains(soup));
        Assert.assertEquals(1, (int) basket.getItems().get(soup));
    }
}

