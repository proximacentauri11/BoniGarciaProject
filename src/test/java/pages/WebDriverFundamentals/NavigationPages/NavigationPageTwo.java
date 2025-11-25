package pages.WebDriverFundamentals.NavigationPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPageTwo extends BasePage {
    public NavigationPageTwo(WebDriver driver) {
        super(driver);
    }

    public String getNavigationTextTwoText() {
        return getDriver().findElement(By.xpath("//p[@class = 'lead']"))
                .getText();
    }

    public NavigationPageThree clickNextFromPageTwo() {
        getDriver().findElement(By.xpath("//a[text() = 'Next']"))
                .click();

        return new NavigationPageThree(getDriver());
    }

    public NavigationPageOne clickPreviousFromPageTwo() {
        getDriver().findElement(By.xpath("//a[text() = 'Previous']"))
                .click();

        return new NavigationPageOne(getDriver());
    }

    public NavigationPageOne clickNavigationPageOne() {
        getDriver().findElement(By.xpath("//a[text() = '1']"))
                .click();

        return new NavigationPageOne(getDriver());
    }

    public NavigationPageThree clickNavigationPageThree() {
        getDriver().findElement(By.xpath("//a[text() = '3']"))
                .click();

        return new NavigationPageThree(getDriver());
    }
}
