package tests;

import base.BaseTest;
import pages.HomePage;
import pages.ContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    // Test 1: Valid form submission
    @Test
    public void verifyContactFormSubmission() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickContact();
        Thread.sleep(2000);

        ContactPage contact = new ContactPage(driver);
        contact.fillValidForm();
        contact.clickSubmit();

        Thread.sleep(3000);

        String page = driver.getPageSource();

        Assert.assertTrue(
            page.contains("Thank") ||
            page.contains("success") ||
            page.contains("submitted"),
            "Form submission failed"
        );

        System.out.println("Contact form submission verified");
    }

    // Test 2: Empty form validation
    @Test
    public void verifyEmptyFormValidation() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickContact();
        Thread.sleep(2000);

        ContactPage contact = new ContactPage(driver);
        contact.submitEmptyForm();

        Thread.sleep(1500);

        String page = driver.getPageSource();

        Assert.assertTrue(
            page.contains("required") ||
            page.contains("Please") ||
            page.contains("fill"),
            "Validation message not shown"
        );

        System.out.println("Empty form validation verified");
    }

    // Test 3: All social links navigation
    @Test
    public void verifySocialLinksClickable() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickContact();
        Thread.sleep(3000);

        ContactPage contact = new ContactPage(driver);
        String originalWindow = driver.getWindowHandle();

        // LinkedIn
        contact.clickLinkedIn();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(originalWindow);

        // Facebook
        contact.clickFacebook();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        driver.close();
        driver.switchTo().window(originalWindow);

        // Instagram
        contact.clickInstagram();
        Thread.sleep(4000);
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("instagram"));
        driver.close();
        driver.switchTo().window(originalWindow);

        // Google Maps (slow + visible)
        contact.clickMaps();
        Thread.sleep(3000);
        switchToNewTab(originalWindow);

        // extra wait so you can see maps page
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Maps URL: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("google"));

        driver.close();
        driver.switchTo().window(originalWindow);

        System.out.println("All social links verified");
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
