package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestUtils;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public <T> T chooseCategory(String locatorName, Class<T> Page){
        WebElement category = getWait5().until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText(locatorName))
        );

        TestUtils.scrollAndClickWithJS(getDriver(), category);

        try {
            return Page.getConstructor(WebDriver.class).newInstance(getDriver());
        } catch (Exception e) {
            throw new RuntimeException("Page instantiation failed for: " + Page.getSimpleName(), e);
        }
    }
}
