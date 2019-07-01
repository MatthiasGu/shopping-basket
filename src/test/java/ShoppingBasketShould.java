
import model.Apples;
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
        basket.addItem(soup, 1);
        Assert.assertEquals(1, basket.getItems().size());
        Assert.assertTrue(basket.getItems().keySet().contains(soup));
        Assert.assertEquals(1, (int) basket.getItems().get(soup));
    }

    @Test
    public void beAbleToAddMultipleOfTheSameItemManually() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        basket.addItem(soup, 1);
        basket.addItem(soup, 1);
        Assert.assertEquals(1, basket.getItems().size());
        Assert.assertTrue(basket.getItems().keySet().contains(soup));
        Assert.assertEquals(2, (int) basket.getItems().get(soup));
    }

    @Test
    public void beAbleToAddMultipleOfTheSameItem() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        basket.addItem(soup, 2);
        Assert.assertEquals(1, basket.getItems().size());
        Assert.assertTrue(basket.getItems().keySet().contains(soup));
        Assert.assertEquals(2, (int) basket.getItems().get(soup));
    }

    @Test
    public void returnCorrectSubtotal() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item milk = new Milk();
        basket.addItem(soup,2);
        basket.addItem(milk, 1);
        Assert.assertEquals(2.60, basket.getSubtotal(), 0.0);
    }

    @Test
    public void shouldCorrectlyApply10PercentOffForApples(){
        ShoppingBasket basket = new ShoppingBasket();
        Item apples = new Apples();
        basket.addItem(apples, 1);
        Assert.assertEquals(-0.1, basket.applyOffers(), 0.0);
    }
}

