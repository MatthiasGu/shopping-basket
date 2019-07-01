
import model.*;
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
        Assert.assertEquals(2.60, basket.getSubtotal(), 0.001);
    }

    @Test
    public void correctlyApply10PercentOffForApples(){
        ShoppingBasket basket = new ShoppingBasket();
        Item apples = new Apples();
        basket.addItem(apples, 1);
        Assert.assertEquals(0.1, basket.applyOffers(), 0.001);
    }

    @Test
    public void correctlyApply10PercentOffForMultipleApples(){
        ShoppingBasket basket = new ShoppingBasket();
        Item apples = new Apples();
        basket.addItem(apples, 5);
        Assert.assertEquals(0.5, basket.applyOffers(), 0.001);
    }

    @Test
    public void correctlyApply50PercentOffForBread() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        basket.addItem(soup, 2);
        basket.addItem(bread, 1);
        Assert.assertEquals(0.4, basket.applyOffers(), 0.001);
    }

    @Test
    public void correctlyApply50PercentOffForMultipleBreads() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        basket.addItem(soup, 6);
        basket.addItem(bread, 3);
        Assert.assertEquals(1.2, basket.applyOffers(), 0.001);
    }

    @Test
    public void onlyApply50PercentOffTwiceIfThereAreTwoBreadsAndTenSoups() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        basket.addItem(soup,10);
        basket.addItem(bread, 2);
        Assert.assertEquals(0.8, basket.applyOffers(), 0.001);
    }

    @Test
    public void onlyApply50PercentOffTwiceIfThereAreFiveBreadsAndFourSoups() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        basket.addItem(soup,4);
        basket.addItem(bread, 5);
        Assert.assertEquals(0.8, basket.applyOffers(), 0.001);
    }

    @Test
    public void onlyApply50PercentOffOnceIfThereAreTwoBreadsAndThreeSoups() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        basket.addItem(soup,3);
        basket.addItem(bread, 2);
        Assert.assertEquals(0.4, basket.applyOffers(), 0.001);
    }

    @Test
    public void applyMultipleOffersMultipleTimes() {
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        Item bread = new Bread();
        Item apples = new Apples();
        basket.addItem(soup,4);
        basket.addItem(bread, 2);
        basket.addItem(apples, 5);
        Assert.assertEquals(1.3, basket.applyOffers(), 0.001);
    }

    @Test
    public void notApplyOffersIfNoQualifiedItemsInTheBasket(){
        ShoppingBasket basket = new ShoppingBasket();
        Item soup = new Soup();
        basket.addItem(soup, 5);
        Assert.assertEquals(0, basket.applyOffers(), 0.001);
    }
}

