package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // page heading
    By pageHeading = By.tagName("h1");

    // category tabs
    By categories = By.cssSelector(".category-tab");

    // product cards
    By productCards = By.cssSelector(".product-card");

    // check page loaded
    public boolean isProductsPageLoaded() {
        return driver.findElement(pageHeading).isDisplayed();
    }

    // count categories
    public int getCategoryCount() {
        return driver.findElements(categories).size();
    }

    // count products
    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    // get all categories
    public List<WebElement> getCategories() {
        return driver.findElements(categories);
    }

    // click category by text
    public void clickCategoryByText(String text) {
        List<WebElement> tabs = driver.findElements(categories);

        for (WebElement tab : tabs) {
            if (tab.getText().toLowerCase().contains(text.toLowerCase())) {
                tab.click();
                break;
            }
        }
    }
}
