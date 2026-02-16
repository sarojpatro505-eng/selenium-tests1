package tests;

import base.BaseTest;
import pages.FooterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class FooterTest extends BaseTest {

    // helper scroll method
    public void scrollToFooter() throws InterruptedException {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000); // wait so you can see
    }

    @Test
    public void verifyFooterQuickLinks() throws InterruptedException {

        FooterPage footer = new FooterPage(driver);

        // Products
        scrollToFooter();
        footer.clickProducts();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("products"));

        // Clients
        scrollToFooter();
        footer.clickClients();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("clients"));

        // Careers
        scrollToFooter();
        footer.clickCareers();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("careers"));

        // Contact
        scrollToFooter();
        footer.clickContact();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("contact"));

        // Foreign collaborations
        scrollToFooter();
        footer.clickForeignCollab();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("foreign"));

        System.out.println("Footer quick links verified");
    }

    @Test
    public void verifyFooterSocialLinks() throws InterruptedException {

        FooterPage footer = new FooterPage(driver);
        String originalWindow = driver.getWindowHandle();

        scrollToFooter();

        // LinkedIn
        footer.clickLinkedIn();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(originalWindow);

        scrollToFooter();

        // Facebook
        footer.clickFacebook();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        driver.close();
        driver.switchTo().window(originalWindow);

        scrollToFooter();

        // Instagram
        footer.clickInstagram();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("instagram"));
        driver.close();
        driver.switchTo().window(originalWindow);

        scrollToFooter();

        // Google Maps
        footer.clickMaps();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        driver.close();
        driver.switchTo().window(originalWindow);

        System.out.println("Footer social links verified");
    }

    // helper method
    public void switchToNewTab(String originalWindow) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
