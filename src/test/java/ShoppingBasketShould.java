
import org.junit.Assert;
import org.junit.Test;

public class ShoppingBasketShould {

    @Test
    public void beEmptyByDefault() {
        ShoppingBasket basket = new ShoppingBasket();
        Assert.assertTrue(basket.isEmpty());
    }
}

