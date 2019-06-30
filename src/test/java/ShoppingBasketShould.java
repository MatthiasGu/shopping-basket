
import model.Item;
import model.Milk;
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

    @Test
    public void beAbleToAddMultipleOfTheSameItem() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        basket.addItem(soup);
        basket.addItem(soup);
        Assert.assertEquals(1, basket.getItems().size());
        Assert.assertTrue(basket.getItems().keySet().contains(soup));
        Assert.assertEquals(2, (int) basket.getItems().get(soup));
    }

}

