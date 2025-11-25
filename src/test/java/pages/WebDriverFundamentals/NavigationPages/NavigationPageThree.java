package pages.WebDriverFundamentals.NavigationPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPageThree extends BasePage {
    public NavigationPageThree(WebDriver driver) {
        super(driver);
    }

    public String getNavigationTextThreeText() {
        return getDriver().findElement(By.xpath("//p[@class = 'lead']"))
                .getText();
    }

    public NavigationPageTwo clickPreviousFromPageThree() {
        getDriver().findElement(By.xpath("//a[text() = 'Previous']"))
                .click();

        return new NavigationPageTwo(getDriver());
    }

    public NavigationPageOne clickNavigationPageOne() {
        getDriver().findElement(By.xpath("//a[text() = '1']"))
                .click();

        return new NavigationPageOne(getDriver());
    }

    public NavigationPageTwo clickNavigationPageTwo() {
        getDriver().findElement(By.xpath("//a[text() = '2']"))
                .click();

        return new NavigationPageTwo(getDriver());
    }
}
