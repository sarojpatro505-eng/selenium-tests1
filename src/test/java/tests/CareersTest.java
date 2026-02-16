package tests;

import base.BaseTest;
import pages.HomePage;
import pages.CareersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersTest extends BaseTest {

    // Test 1: Page load
    @Test
    public void verifyCareersPageOpens() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickCareers();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("careers"));

        System.out.println("Careers page opened");
    }

    // Test 2: Form visible
    @Test
    public void verifyCareersFormVisible() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickCareers();
        Thread.sleep(2000);

        CareersPage careers = new CareersPage(driver);
        Assert.assertTrue(careers.isCareersFormVisible());

        System.out.println("Careers form visible");
    }

    // Test 3: Valid form submission
    @Test
    public void verifyCareersFormSubmission() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickCareers();
        Thread.sleep(2000);

        CareersPage careers = new CareersPage(driver);
        careers.fillValidForm();
        careers.clickSubmit();

        Thread.sleep(3000);

        String page = driver.getPageSource();

        Assert.assertTrue(
            page.contains("Thank") ||
            page.contains("success") ||
            page.contains("submitted"),
            "Careers form submission failed"
        );

        System.out.println("Careers form submitted");
    }
}
