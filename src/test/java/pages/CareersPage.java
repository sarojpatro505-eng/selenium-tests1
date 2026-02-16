package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CareersPage {

    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By nameField = By.id("name");
    By emailField = By.id("email");
    By phoneField = By.id("phone");
    By positionDropdown = By.id("position");
    By experienceDropdown = By.id("experience");
    By resumeUpload = By.id("resume");
    By coverLetter = By.id("coverLetter");
    By captchaAnswer = By.cssSelector("input[placeholder='Enter answer']");
    By submitButton = By.xpath("//button[contains(text(),'SUBMIT')]");

    public boolean isCareersFormVisible() {
        return driver.findElement(nameField).isDisplayed();
    }

    public void fillValidForm() {

        driver.findElement(nameField).sendKeys("Test User");
        driver.findElement(emailField).sendKeys("test@gmail.com");
        driver.findElement(phoneField).sendKeys("9999999999");

        Select position = new Select(driver.findElement(positionDropdown));
        position.selectByIndex(1);

        Select experience = new Select(driver.findElement(experienceDropdown));
        experience.selectByIndex(1);

        // resume upload (local file path)
        driver.findElement(resumeUpload)
              .sendKeys("C:\\test\\resume.pdf");

        driver.findElement(coverLetter)
              .sendKeys("This is a test cover letter.");

        // captcha: 6 + 7 = 13
        driver.findElement(captchaAnswer).sendKeys("13");
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
