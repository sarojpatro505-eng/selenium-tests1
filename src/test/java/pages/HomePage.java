package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // header links locator
    By headerLinks = By.cssSelector("#navbar .nav-links a");

    public int getHeaderLinkCount() {
        return driver.findElements(headerLinks).size();
    }

    public List<WebElement> getHeaderLinks() {
        return driver.findElements(headerLinks);
    }
    By productsLink = By.linkText("Products");

    public void clickProducts() {
        driver.findElement(productsLink).click();
    }
    By contactLink = By.linkText("CONTACT US");

    public void clickContact() {
        driver.findElement(contactLink).click();
    }
    By careersLink = By.linkText("CAREERS");

    public void clickCareers() {
        driver.findElement(careersLink).click();
    }


}
