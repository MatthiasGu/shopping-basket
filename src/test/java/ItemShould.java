import org.junit.Assert;
import org.junit.Test;

public class ItemShould {

    @Test
    public void beAbleToCreateSoup() {
        Item soup = new Soup();
        Assert.assertEquals(ItemName.SOUP, soup.getName());
    }
}
