package pages.WebDriverFundamentals.NavigationPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPageOne extends BasePage {
    public NavigationPageOne(WebDriver driver) {
        super(driver);
    }

    public String getNavigationTextOneText() {
        return getDriver().findElement(By.xpath("//p[@class = 'lead']"))
                .getText();
    }

    public NavigationPageTwo clickNextFromPageOne() {
        getDriver().findElement(By.xpath("//a[text() = 'Next']"))
                .click();

        return new NavigationPageTwo(getDriver());
    }

    public NavigationPageTwo clickNavigationPageTwo() {
        getDriver().findElement(By.xpath("//a[text() = '2']"))
                .click();

        return new NavigationPageTwo(getDriver());
    }

    public NavigationPageThree clickNavigationPageThree() {
        getDriver().findElement(By.xpath("//a[text() = '3']"))
                .click();

        return new NavigationPageThree(getDriver());
    }


}
