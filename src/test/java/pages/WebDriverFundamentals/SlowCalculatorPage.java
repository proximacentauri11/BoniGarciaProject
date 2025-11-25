package pages.WebDriverFundamentals;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SlowCalculatorPage extends BasePage {
    public SlowCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public SlowCalculatorPage setDelay(int second) {
        WebElement delay = getDriver().findElement(By.id("delay"));

        delay.clear();
        delay.sendKeys(String.valueOf(second));

        return this;
    }

    public SlowCalculatorPage enterNumber(int number) {
        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            clickDigit(Character.getNumericValue(c));
        }

        return this;
    }

    public void clickDigit(int digit) {
        By locator = By.xpath(String.format("//span[text()='%d']", digit));
        getWait5().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
