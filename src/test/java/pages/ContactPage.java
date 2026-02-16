package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    // form locators
    By nameField = By.id("name");
    By emailField = By.id("email");
    By phoneField = By.id("phone");
    By companyField = By.id("company");
    By subjectDropdown = By.id("subject");
    By messageField = By.id("message");
    By submitButton = By.cssSelector("button.contact-btn");

    // social links locators
    By linkedinLink = By.cssSelector("a[title='LinkedIn']");
    By facebookLink = By.cssSelector("a[title='Facebook']");
    By instagramLink = By.cssSelector("a[title='Instagram']");
    By whatsappLink = By.cssSelector("a[title='WhatsApp']");
    By mapsLink = By.cssSelector("a[title='Google Maps']");

    // fill form slowly (human-like)
    public void fillValidForm() throws InterruptedException {

        driver.findElement(nameField).sendKeys("Test User");
        Thread.sleep(700);

        driver.findElement(emailField).sendKeys("test@gmail.com");
        Thread.sleep(700);

        driver.findElement(phoneField).sendKeys("9999999999");
        Thread.sleep(700);

        driver.findElement(companyField).sendKeys("Test Company");
        Thread.sleep(700);

        Select subject = new Select(driver.findElement(subjectDropdown));
        subject.selectByVisibleText("Product Inquiry");
        Thread.sleep(700);

        driver.findElement(messageField)
              .sendKeys("This is a test message from automation.");
        Thread.sleep(700);
    }

    // submit after filling form
    public void clickSubmit() throws InterruptedException {

        WebElement button = driver.findElement(submitButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", button);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);

        Thread.sleep(1000);
    }

    // submit empty form
    public void submitEmptyForm() throws InterruptedException {

        WebElement button = driver.findElement(submitButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", button);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);

        Thread.sleep(1000);
    }

    // social link actions
    public void clickLinkedIn() {
        driver.findElement(linkedinLink).click();
    }

    public void clickFacebook() {
        driver.findElement(facebookLink).click();
    }

    public void clickInstagram() {
        driver.findElement(instagramLink).click();
    }

    public void clickWhatsApp() {
        driver.findElement(whatsappLink).click();
    }

    public void clickMaps() {
        driver.findElement(mapsLink).click();
    }
}
