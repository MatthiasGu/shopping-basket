import model.*;
import org.junit.Assert;
import org.junit.Test;

public class ItemShould {

    @Test
    public void beAbleToCreateSoup() {
        Item soup = new Soup();
        Assert.assertEquals(ItemName.SOUP, soup.getName());
    }

    @Test
    public void beAbleToCreateBread() {
        Item bread = new Bread();
        Assert.assertEquals(ItemName.BREAD, bread.getName());
    }

    @Test
    public void beAbleToCreateMilk() {
        Item milk = new Milk();
        Assert.assertEquals(ItemName.MILK, milk.getName());
    }

    @Test
    public void beAbleToCreateApples() {
        Item apples = new Apples();
        Assert.assertEquals(ItemName.APPLES, apples.getName());
    }

    @Test
    public void createAllItemsWithCorrectPrice() {
        Item soup = new Soup();
        Item bread = new Bread();
        Item milk = new Milk();
        Item apples = new Apples();
        Assert.assertEquals(0.65, soup.getPrice(), 0.0);
        Assert.assertEquals(0.8, bread.getPrice(), 0.0);
        Assert.assertEquals(1.30, milk.getPrice(), 0.0);
        Assert.assertEquals(1.00, apples.getPrice(), 0.0);
    }
}
