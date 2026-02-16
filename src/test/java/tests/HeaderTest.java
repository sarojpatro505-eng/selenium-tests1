package tests;

import base.BaseTest;
import pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class HeaderTest extends BaseTest {

    @Test
    public void verifyHeaderLinksCount() {

        HomePage home = new HomePage(driver);
        int count = home.getHeaderLinkCount();

        System.out.println("Header links: " + count);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void verifyAllHeaderLinksClickable() throws InterruptedException {

        HomePage home = new HomePage(driver);
        List<WebElement> links = home.getHeaderLinks();

        for (int i = 0; i < links.size(); i++) {

            links = home.getHeaderLinks(); // refresh elements
            WebElement link = links.get(i);

            String text = link.getText();
            String oldUrl = driver.getCurrentUrl();

            link.click();
            Thread.sleep(1500); // wait for page load

            String newUrl = driver.getCurrentUrl();

            System.out.println("Clicked: " + text);
            System.out.println("Old URL: " + oldUrl);
            System.out.println("New URL: " + newUrl);
            
            // verify page changed
            Assert.assertNotEquals(newUrl, oldUrl);

            driver.navigate().back();
            Thread.sleep(1000); // wait for home page
        }
    }
}
