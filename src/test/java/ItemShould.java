import model.*;
import org.junit.Assert;
import org.junit.Test;

public class ItemShould {

    @Test
    public void getCorrectPricesForAllItems() {
        Assert.assertEquals(0.65, Item.getPrice(Item.SOUP), 0.0);
        Assert.assertEquals(0.8, Item.getPrice(Item.BREAD), 0.0);
        Assert.assertEquals(1.30, Item.getPrice(Item.MILK), 0.0);
        Assert.assertEquals(1.00, Item.getPrice(Item.APPLES), 0.0);
    }
}
