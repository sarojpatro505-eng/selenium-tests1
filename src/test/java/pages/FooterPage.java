package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class FooterPage {

    WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    // quick links
    By products = By.cssSelector("a[href='/products']");
    By clients = By.cssSelector("a[href='/clients']");
    By careers = By.cssSelector("a[href='/careers']");
    By contact = By.cssSelector("a[href='/contact']");
    By foreignCollab = By.cssSelector("a[href='/foreign-collaborations']");

    // social links
    By linkedin = By.cssSelector("a[title='LinkedIn']");
    By facebook = By.cssSelector("a[title='Facebook']");
    By instagram = By.cssSelector("a[title='Instagram']");
    By maps = By.cssSelector("a[title='Google Maps']");

    // scroll to footer
    private void scrollToFooter() throws InterruptedException {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000); // visible scroll
    }

    // highlight element
    private void highlight(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].style.border='3px solid red'",
            driver.findElement(locator)
        );
    }

    // quick link clicks
    public void clickProducts() throws InterruptedException {
        scrollToFooter();
        highlight(products);
        Thread.sleep(1000);
        driver.findElement(products).click();
    }

    public void clickClients() throws InterruptedException {
        scrollToFooter();
        highlight(clients);
        Thread.sleep(1000);
        driver.findElement(clients).click();
    }

    public void clickCareers() throws InterruptedException {
        scrollToFooter();
        highlight(careers);
        Thread.sleep(1000);
        driver.findElement(careers).click();
    }

    public void clickContact() throws InterruptedException {
        scrollToFooter();
        highlight(contact);
        Thread.sleep(1000);
        driver.findElement(contact).click();
    }

    public void clickForeignCollab() throws InterruptedException {
        scrollToFooter();
        highlight(foreignCollab);
        Thread.sleep(1000);
        driver.findElement(foreignCollab).click();
    }

    // social clicks
    public void clickLinkedIn() throws InterruptedException {
        scrollToFooter();
        highlight(linkedin);
        Thread.sleep(1000);
        driver.findElement(linkedin).click();
    }

    public void clickFacebook() throws InterruptedException {
        scrollToFooter();
        highlight(facebook);
        Thread.sleep(1000);
        driver.findElement(facebook).click();
    }

    public void clickInstagram() throws InterruptedException {
        scrollToFooter();
        highlight(instagram);
        Thread.sleep(1000);
        driver.findElement(instagram).click();
    }

    public void clickMaps() throws InterruptedException {
        scrollToFooter();
        highlight(maps);
        Thread.sleep(1000);
        driver.findElement(maps).click();
    }
}
