package pages.WebDriverFundamentals;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebFormSubmitPage extends BasePage {
    public WebFormSubmitPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getWait5().until
                (ExpectedConditions.visibilityOfElementLocated(By.className("display-6")))
                .getText();
    }

    public String getSmallText() {
        return getWait5().until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//p[@class = 'lead']")))
                .getText();
    }
}
